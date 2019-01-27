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

    /**
     * Checks that there are three consecutive points, separated by e_pts and f_pts points respectively,
     * that forms a triangle with area greater than params.area1
     * @param pts array of Point objects
     * @param params Parameter object
     * @return true if the condition above is met
     */
    public static boolean LIC10(Point[] pts, Parameters params) {
        if (pts.length < 5) {
            return false;
        }
        int e_pts = params.e_pts;
        int f_pts = params.f_pts;
        if (e_pts < 1 || f_pts < 1) {
            throw new IllegalArgumentException("e_pts and f_pts must be greater than or equals to 1");
        }
        if ((e_pts + f_pts) > pts.length - 3) {
            throw new IllegalArgumentException("Condition (e_pts + f_pts) <= (numpoints - 3) is not met.");
        }
        Point a, b, c;
        double triangleArea;
        for (int i = 0; i < pts.length - e_pts - f_pts - 2; i++) {
            a = pts[i];
            b = pts[i + e_pts + 1];
            c = pts[i + e_pts + f_pts + 2];
            triangleArea = Point.triangleArea(a, b, c);
            if (triangleArea > params.area1) {
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
     * Checks that three exists at least one set of q_pts consecutive data points that lie in more than quads quadrants. 
     * Checks for LIC3 in the input parameters.
     *
     * LIC3 is true if the input contains three consecutive points that forms a
     * triangle with an area larger than AREA1.
     * @param pts array of Points objects
     * @param params Parameter object
     * @return true if LIC3 as described above is true, false otherwise.
     */
    public static boolean LIC3(Point[] pts, Parameters params) {
        if(params.area1 < 0) {
            throw new IllegalArgumentException("AREA1 must be greater or equal to 0");
        }

        for(int i = 0; i < pts.length - 2; i++) {
            Point a = pts[i];
            Point b = pts[i + 1];
            Point c = pts[i + 2];

            double area = Point.triangleArea(a, b, c);
            if(params.area1 < area) {
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


    /**
     * Checks that there exists at least one set of three data points, separated by exactly e_pts
     * and f_pts consecutive points, respectively, that are the vertices of a triangle
     * with area greater than AREA1. 
     * In addition, there exist three data points (can be the same as the mentioned points) separated by 
     * exactly e_pts and f_pts consecutive  points, respectively, that are the vertices of
     * a triangle with area less than AREA2. 
     * @param pts array of Points objects
     * @param params Parameter object
     * @return true if both conditions above are true 
     */
    public static boolean LIC14(Point[] pts, Parameters params) {
        int e_pts = params.e_pts;
        int f_pts = params.f_pts;
        boolean greaterThanArea1 = false;
        boolean lesserThanArea2 = false;

        if (pts.length < 5) {
            return false;
        }
        if(params.area1 < 0 || params.area2 < 0) {
            throw new IllegalArgumentException("AREA1 and AREA2 must be greater than or equal to 0");
        }

        for (int i = 0; i < pts.length - e_pts - f_pts - 2; i++) {
            Point x = pts[i];
            Point v = pts[i + e_pts + 1];
            Point y = pts[i + e_pts + f_pts + 2];
            //calculate area (According to https://www.mathopenref.com/coordtrianglearea.html) and set greater and lesser
            double area = Point.triangleArea(x, v, y);
            if (area > params.area1) {
                greaterThanArea1 = true;
            }
            if (area < params.area2) {
                lesserThanArea2 = true;
            }
            if (greaterThanArea1 && lesserThanArea2) {
                return true;
            }
        }
        return false;
        
    }

    /**
     * Check difference between two points' X-coordinates.
     * @param pts array of Point objects
     * @return true if two consecutive points (X[i],Y[i]), (X[j],Y[j]) fulfills that X[j]-X[i] < 0,
     * where i = j - 1.
     */
    public static boolean LIC5(Point[] pts) {
        Point a;
        Point b;
        for (int i = 0; i < pts.length - 1; i++) {
            a = pts[i];
            b = pts[i + 1];
            if ((b.X - a.X) < 0) {
                return true;
            }
        }
        return false;
    }
    
     /*
     * Checks if there is two points, separated by K_pts consecutive intervening
     * points, with a distance greater than LENGTH1 between each other.
     *
     * @param pts array of data points of type Point
     * @param params Parameter object acting as configuration
     * @return boolean which is true iff LIC7 condition is met
     */
    public static boolean LIC7(Point[] pts, Parameters params) {
        // NUMPOINTS needs to be at least 3
        if (pts.length < 3) {
            return false;
        }

        if (1 <= params.k_pts && params.k_pts <= pts.length - 2) { /* Condition fulfilled */
        } else {
            throw new IllegalArgumentException("K_pts needs to be greater or equal" +
                    " to 1 and lower or equal to amount of data points - 2. Check LIC7");
        }

        // Check distance between point p[i] and p[i + k_pts + 1]
        for (int i = 0; i < pts.length - (params.k_pts + 1); i++) {
            double dist = pts[i].distance(pts[i + params.k_pts + 1]);

            if (dist > params.length1) {
                return true;
            }
        }
        return false;
    }
  
    /**
     * LIC11 is true if there exists at least one set of two data points, separated by exactly g_pts
     * consecutive intervening points, such that the first data point is to the right of the second point
     * on the x-axis.
     * @param pts array of Points objects
     * @param params Parameter object
     * @return true if LIC3 as described above is true, false otherwise.
     */
    public static boolean LIC11(Point[] pts, Parameters params) {
        if (params.g_pts < 1)
            throw new IllegalArgumentException("g_pts must be greater than or equal to 1");
        else if (pts.length < 3) {
            return false;
        }
        Point p1, p2;

        for (int i = 0; i < pts.length - params.g_pts - 1; i++) {
            p1 = pts[i];
            p2 = pts[i + params.g_pts + 1];
            for (int j = 0; j < params.g_pts; j++) {
                if (p2.X - p1.X < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
