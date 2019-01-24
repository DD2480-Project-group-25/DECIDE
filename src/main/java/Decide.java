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
}