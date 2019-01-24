import org.junit.Assert;
import org.junit.Test;

public class TestLIC4 {

    @Test
    public void testPositive() {
        Parameters params = new Parameters(0, 0, 0, 0,
                0, 0, 0, 0, 3, 2, 0, 0,
                0, 0, 0, 0, 0, 0, 0);

        Point a = new Point(1, 1); //quadrant 1
        Point b = new Point(2, 2); //quadrant 1
        Point c = new Point(-1, 10); //quadrant 2
        Point d = new Point(-4, -3); //quadrant 3

        Point[] pts = {a, b, c, d};
        Assert.assertEquals(true, Decide.LIC4(pts, params));
    }

    @Test
    public void testNegative() {
        Parameters params = new Parameters(0, 0, 0, 0,
                0, 0, 0, 0, 2, 2, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        Point a = new Point(1, 1); //quadrant 1
        Point b = new Point(2, 2); //quadrant 1
        Point c = new Point(-1, 10); //quadrant 2

        Point[] pts = {a, b, c};
        Assert.assertEquals(false, Decide.LIC4(pts, params));
    }

    @Test
    public void testOnAxis() {
        Parameters params = new Parameters(0, 0, 0, 0,
                0, 0, 0, 0, 3, 2, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        Point a = new Point(0, 0); //quadrant 1
        Point b = new Point(0, -1); //quadrant 3
        Point c = new Point(-1, 0); //quadrant 2


        Point[] pts = {a, b, c};
        Assert.assertEquals(true, Decide.LIC4(pts, params));
    }

    @Test
    public void testIllegalArgument() {
        Point a = new Point(1,1);
        Point b = new Point(10,10);
        Point[] pts = {a, b};
        Parameters illegalQpts = new Parameters(0,0,0,0,
                0, 0,0,0,-1,2,0,0,
                0,0,0,0,0,0,0);

        Parameters illegalQuads = new Parameters(0,0,0,0,
                0, 0,0,0,2,-1,0,0,
                0,0,0,0,0,0,0);
        try {
            Decide.LIC4(pts, illegalQpts);
        } catch (IllegalArgumentException ie) {
            Assert.assertEquals("q_pts should be between 2 and pts.length", ie.getMessage());
        }

        try {
            Decide.LIC4(pts, illegalQuads);
        } catch (IllegalArgumentException ie) {
            Assert.assertEquals("quads should be between 1 and 3", ie.getMessage());
        }
    }
}
