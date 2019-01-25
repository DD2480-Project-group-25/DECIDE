import org.junit.Assert;
import org.junit.Test;

public class TestLIC1 {
    // There exists one set of three consecutive data points that cannot all be contained within
    // a circle of radius1.
    @Test
    public void testInRadius() {
        // Testing case where three consecutive data points fit within a circle of radius1
        Parameters params = new Parameters(0, 0, 10, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 2);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));
    }

    @Test
    public void testOnRadius() {
        // Testing that points on the circle don't yield a positive result
        Parameters params = new Parameters(0, 0, 2, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, -2);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));
    }

    @Test
    public void testOutsideRadius(){
        // Three consecutive data points that cannot all be contained within a circle of radius1 yields true
        Parameters params = new Parameters(0, 0, 5, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(10, 10);
        Point c = new Point(1, 1);
        Point[] pts = {a, b, c};
        Assert.assertTrue(Decide.LIC1(pts, params));
    }

    @Test
    public void testIllegalArgument() {
        Point a = new Point(1,1);
        Point b = new Point(2,2);
        Point c = new Point(3,3);
        Point[] pts = {a, b, c};
        Parameters params = new Parameters(0,0,-1,0,
                0, 0,0,0,0,0,0,0,
                0,0,0,0,0,0,0);
        try {
            Decide.LIC1(pts, params);
        } catch (IllegalArgumentException ie) {
            Assert.assertEquals(ie.getMessage(), "Radius1 must be greater than or equal to 0");
        }
    }
}
