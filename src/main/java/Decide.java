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

