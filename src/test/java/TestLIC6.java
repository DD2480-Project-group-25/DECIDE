import org.junit.Assert;
import org.junit.Test;

/**
 * Assert that LIC6 can successfully determine if there exists at least one set of n_pts
 * consecutive data points such that at least one of the points lies a distance greater
 * than dist from the line joining the first and last of these n_pts points.
 */
public class TestLIC6 {

    /**
     * Assert that LIC6 can recognise when the points are within distance of the line as
     * negative results.
     */
    @Test
    public void testWithinDist() {

        Parameters params = new Parameters(0, 0, 0, 0, 0,
                0, 0, 10, 0, 0, 3, 0, 0, 0,
                0, 0, 0, 0, 0);

        // point at (5,5), line from 0 to 10 on x-axis (distance vector orthogonal to x-axis)
        Point a = new Point(0, 0);
        Point b = new Point(5, 5);
        Point c = new Point(10, 0);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC6(pts, params));

        // point at (0,10), line from 0 to 10 on x-axis, distance = dist
        a = new Point(0, 0);
        b = new Point(0, 10);
        c = new Point(10, 0);
        Point[] pts2 = {a, b, c};
        Assert.assertFalse(Decide.LIC6(pts2, params));

        // point at (5,5), line from 0 to 1 on x-axis (distance vector has a positive slope)
        a = new Point(0, 0);
        b = new Point(5, 5);
        c = new Point(1, 0);
        Point[] pts3 = {a, b, c};
        Assert.assertFalse(Decide.LIC6(pts3, params));
    }

    /**
     * Assert that LIC6 can recognise when the points are NOT within distance of the line as
     * positive results.
     */
    @Test
    public void testOutsideDist() {
        // point and line on y-axis
        Parameters params = new Parameters(0, 0, 0, 0, 0,
                0, 0, 10, 0, 0, 3, 0, 0, 0,
                0, 0, 0, 0, 0);

        // point at (0,80), line from 0 to 10 on y-axis
        Point a = new Point(0, 0);
        Point b = new Point(0, 80);
        Point c = new Point(0, 10);
        Point[] pts = {a, b, c};
        Assert.assertTrue(Decide.LIC6(pts, params));

        // point at (0,80), line from 5 to 10 on x-axis (distance vector has a negative slope)
        a = new Point(5, 0);
        b = new Point(0, 80);
        c = new Point(10, 0);
        Point[] pts2 = {a, b, c};
        Assert.assertTrue(Decide.LIC6(pts2, params));

        // point at (5,11), line from 0 to 10 on x-axis (distance vector from (5,0) to (5,11))
        a = new Point(0, 0);
        b = new Point(5, 11);
        c = new Point(10, 0);
        Point[] pts3 = {a, b, c};
        Assert.assertTrue(Decide.LIC6(pts3, params));
    }

    /**
     * Testing special case where two line end-points is the same point.
     * First when the point is within distance of the coinciding line point.
     * Secondly when point is NOT within distance of the coinciding line point.
     */
    @Test
    public void testLineIsPoint() {
        Parameters params = new Parameters(0, 0, 0, 0, 0,
                0, 0, 10, 0, 0, 3, 0, 0, 0,
                0, 0, 0, 0, 0);

        Point a = new Point(10, 10);
        Point b = new Point(10, 20);
        Point c = new Point(10, 10);
        Point[] pts0 = {a, b, c};
        Assert.assertFalse(Decide.LIC6(pts0, params));

        a = new Point(10, 10);
        b = new Point(10, 21);
        c = new Point(10, 10);
        Point[] pts1 = {a, b, c};
        Assert.assertTrue(Decide.LIC6(pts1, params));

    }

    /**
     * Assert that lack of enough data always yields false.
     */
    @Test
    public void testBadData() {

        // Testing length of pts < 3
        Parameters params = new Parameters(0, 0, 0, 0, 0,
                0, 0, 10, 0, 0, 3, 0, 0, 0,
                0, 0, 0, 0, 0);

        Point a = new Point(0, 0);
        Point[] pts = {a};
        Assert.assertFalse(Decide.LIC6(pts, params));

        // Testing n_pts < 3
        Point b = new Point(10, 20);
        Point d = new Point(10, 10);
        Point[] pts2 = {a, b, d};

        params = new Parameters(0, 0, 0, 0, 0,
                0, 0, 10, 0, 0, 1, 0, 0, 0,
                0, 0, 0, 0, 0);
        Assert.assertFalse(Decide.LIC6(pts2, params));
    }

    /**
     * Assert that IllegalArgumentException is thrown when dist is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        Point[] pts = {a, b, c};
        Parameters params = new Parameters(0, 0, 0, 0, 0,
                0, 0, -1, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0);

        Decide.LIC6(pts, params);
    }
}
