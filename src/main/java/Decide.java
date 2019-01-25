/**
 * DECIDE - Launch Interceptor Program
 * #TODO
 *
 * @author  Alzahraa Salman, Helena Alinder, Jesper Larsson, Marcus Granström, Veronica Hage
 * @version 0.1
 * @since   0.1
 */
public class Decide {

    private boolean[] CMV = new boolean[15];

    /**
     * Decides if the "launch-unlock" signal will be generated.
     * The launch decision is made from the Final Unlocking Vector (FUV), where
     * all values needs to be true in order to unlock the launch signal.
     *
     * @return true iff ALL values in the FUV is true, otherwise the return
     * value is set to false
     */
    boolean decideLaunch() {
        return false;
    }

    /**
     * Checks distance between two points.
     * @param pts array of Point objects
     * @param params Parameter object
     * @return true if two consecutive points are greater than length1 distance apart.
     */
    public static boolean LIC0(Point[] pts, Parameters params) {
        if (params.length1 < 0) {
            throw new IllegalArgumentException("Length1 must be greater than or equal to 0");
        }
        Point a;
        Point b;
        for (int i = 0; i < pts.length - 1; i++) {
            a = pts[i];
            b = pts[i + 1];
            if (a.distance(b) > params.length1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks that there exists at least one set of three data points separated 
     * by exactly c_pts and d_pts consecutive intervening points, respectively, 
     * that form an angle such that: angle < (PI − epsilon) or angle > (PI + epsilon)
     * @param pts array of Point objects
     * @param params Parameter object
     * @return true if the condition, above, for the angle is met
     */
    public static boolean LIC9(Point[] pts, Parameters params) {
        int c_pts = params.c_pts;
        int d_pts = params.d_pts;
        if (pts.length < 5) {
            return false;
        }
        if (c_pts < 1 || d_pts < 1){
            throw new IllegalArgumentException("c_pts and d_pts must be greater or equal to 1");
        }
        for (int i = 0; i < pts.length - c_pts - d_pts - 2; i++) {
            Point x = pts[i];
            Point v = pts[i + c_pts + 1];
            Point y = pts[i + c_pts + d_pts + 2];
            //check if x and v or y and v coincide
            if (x.X == v.X && x.Y == v.Y || y.X == v.X && y.Y == v.Y) {
                continue;
            }
            //calculate angle using law of cosine
            double angle = Math.acos((Math.pow(x.distance(v),2) + Math.pow(y.distance(v),2) - Math.pow(x.distance(y),2))
                /(2 * x.distance(v) * y.distance(v)));
            if (angle < (Math.PI - params.epsilon) || angle > (Math.PI + params.epsilon)) {
                return true;
            }
        }
        return false;
    }

    public static boolean LIC1(Point[] pts, Parameters params) {
        if (params.radius1 < 0)
            throw new IllegalArgumentException("Radius1 must be greater than or equal to 0");

        for (int i=0 ; i < pts.length-2; i++) {
            for (int j=1 ; j<3; j++) {
                if (pts[i].distance(pts[i+j]) > params.radius1)
                    return true;
            }
        }
        return false;
    }

    /**
     * LIC2 - verifies that there exists at least one set of three consecutive
     * data points which from an angle such that:
     *      condition 1: angle < (PI - EPSILON)
     *      condition 2: angle > (PI + EPSILON)
     *
     * The second of the three consecutive points is always the vertex of the
     * angle. If either the first point or the last point (or both) coincides
     * with the vertex, the angle is undefined and the LIC is not satisfied by
     * those three points. (0 ≤ EPSILON < PI)
     *
     * Angle is calculated with "The Law of Cosines"
     *
     * @param params Parameter object, acts as configuration
     * @param pts array filled with coordinates of type Points
     * @return true if condition 1 OR 2 is true, otherwise false will be returned
     */
    public static boolean LIC2(Point[] pts, Parameters params) {
        if (0 <= params.epsilon && params.epsilon < Math.PI) {/* Condition fulfilled */
        } else {
            throw new ArithmeticException("Condition: 0 ≤ EPSILON < PI, is not fulfilled. " +
                    "Check configuration for EPSILON");
        }

        // Last check will be points[i-2], points[i-1
        for (int i = 0; i < pts.length - 2; i++) {
            double a = pts[i].distance(pts[i + 1]);       // dist p1->p2
            double b = pts[i + 2].distance(pts[i + 1]);   // dist p3->p2
            double c = pts[i].distance(pts[i + 2]);       // dist p1->p3

            double angle = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2))
                    / (2 * a * b));

            if (angle < (Math.PI - params.epsilon) || angle > (Math.PI + params.epsilon)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks distance between two points.
     * @param pts array of Point objects
     * @param params Parameter object that includes
     * q_pts, number of consecutive points, and QUADS, number of quadrants
     * @return true if at least one set of Q_PTS consecutive data points lie in more than QUADS quadrants.
     */
    public static boolean LIC4(Point[] pts, Parameters params) {
        int q_pts = params.q_pts;
        int quads = params.quads;
        if (q_pts < 2 || q_pts > pts.length){
            throw new IllegalArgumentException("q_pts should be between 2 and pts.length");
        }
        if (quads < 1 || quads > 3){
            throw new IllegalArgumentException("quads should be between 1 and 3");
        }

        for (int i = 0; i < pts.length - q_pts + 1; i++) {
            boolean quadrants[] = {false, false, false, false};
            for (int j = i; j < q_pts + i; j++) {
                Point p = pts[j];
                if (p.X >= 0 && p.Y >= 0) {
                    quadrants[0] = true;
                }else if (p.X < 0 && p.Y >= 0) {
                    quadrants[1] = true;
                }else if (p.X <= 0 && p.Y < 0) {
                    quadrants[2] = true;
                }else{
                    quadrants[3] = true;
                }
            }
            int numQuads = 0;
            for (boolean b: quadrants) {
                if (b)
                    numQuads++;
            }
            if (numQuads > quads)
                return true;
        }
        return false;
    }
}
