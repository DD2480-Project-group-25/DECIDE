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
        if (params.length1 < 0)
            throw new IllegalArgumentException("Length1 must be greater than or equal to 0");
        Point a;
        Point b;
        for (int i = 0; i < pts.length; i++) {
            if (i + 1 == pts.length)
                return false;
            a = pts[i];
            b = pts[i + 1];
            if (a.distance(b) > params.length1)
                return true;
        }
        return false;
    }
}