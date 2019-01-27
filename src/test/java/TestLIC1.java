import org.junit.Assert;
import org.junit.Test;

public class TestLIC1 {
    // There exists one set of three consecutive data points that cannot all be contained within
    // a circle of radius1.
    @Test
    public void testInCircle() {
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
    public void testOnCircle() {
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
    public void testOutsideCircle(){
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
    public void testTriangularPoints() {
        // Testing points where the third point can't fit into a circle drawn with diameter
        // between the first and second points.
        Parameters params = new Parameters(0, 0, 5, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        Point a = new Point(4, 0);
        Point b = new Point(-4, 0);
        Point c = new Point(0, 7);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));

        Point d = new Point(0, 9);
        Point[] pts2 = {a, b, d};
        Assert.assertTrue(Decide.LIC1(pts2, params));
    }

    @Test
    public void testLines() {
        // Testing points that are forming lines.
        Parameters params = new Parameters(0, 0, 5, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(2, 3);
        Point c = new Point(4, 6);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));

        Point d = new Point(6, 9);
        Point[] pts2 = {a, b, d};
        Assert.assertTrue(Decide.LIC1(pts2, params));
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
