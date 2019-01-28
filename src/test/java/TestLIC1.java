import org.junit.Assert;
import org.junit.Test;

/**
 Test that LIC1 can successfully determine if there exists one set of three consecutive
 data points that cannot all be contained within a circle of radius1.
 */
public class TestLIC1 {

    /**
     * Assert that three consecutive data points which fit within a circle of radius1=10 yield
     * a negative result.
     */
    @Test
    public void testInCircle() {
        Parameters params = new Parameters(0, 0, 10, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(3, 2);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));
    }

    /**
     * Generates a three points on the x-axis from -2 to 2, asserts that points exactly radius1
     * from the center yields a negative result.
     */
    @Test
    public void testOnCircle() {
        Parameters params = new Parameters(0, 0, 2, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, -2);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));
    }

    /**
     * Assert that three consecutive data points that cannot all be contained within a circle of
     * radius1 yields a positive result.
     */
    @Test
    public void testOutsideCircle() {
        Parameters params = new Parameters(0, 0, 5, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(10, 10);
        Point c = new Point(1, 1);
        Point[] pts = {a, b, c};
        Assert.assertTrue(Decide.LIC1(pts, params));
    }

    /**
     * Testing points where the third point can't fit into a circle drawn with diameter.
     */
    @Test
    public void testTriangularPoints() {
        // between the first and second points.
        Parameters params = new Parameters(0, 0, 5, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0);
        Point a = new Point(4, 0);
        Point b = new Point(-4, 0);
        Point c = new Point(0, 7);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));

        Point d = new Point(0, 9);
        Point[] pts2 = {a, b, d};
        Assert.assertTrue(Decide.LIC1(pts2, params));
    }

    /**
     * Testing points forming a line.
     * First asserting that a line that can fit into a circle of radius1 yields a negative result.
     * Secondly the opposite.
     */
    @Test
    public void testLines() {
        Parameters params = new Parameters(0, 0, 5, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0);
        Point a = new Point(0, 0);
        Point b = new Point(2, 3);
        Point c = new Point(4, 6);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC1(pts, params));

        Point d = new Point(6, 9);
        Point[] pts2 = {a, b, d};
        Assert.assertTrue(Decide.LIC1(pts2, params));
    }

    /**
     * Assert that an IllegalArgumentException is thrown when radius is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        Point[] pts = {a, b, c};
        Parameters params = new Parameters(0, 0, -1, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0);

        Decide.LIC1(pts, params);
    }
}
