import org.junit.Assert;
import org.junit.Test;

public class TestLIC10 {

    @Test
    public void testTriangle() {
        Parameters params = new Parameters(0,0,0,0,0,2.99,
                0, 0,0,0,0,0,0,0,0,0,1,
                2,0);
        Point a = new Point(0,0);
        Point b = new Point(1,1);
        Point c = new Point(0,0);
        Point d = new Point(4,1);
        Point e = new Point(0,0);
        Point f = new Point(0,0);
        Point g = new Point(4,3);
        // Check triangle with area 3
        Point[] pts = {a, b, c, d, e, f, g};
        Assert.assertTrue(Decide.LIC10(pts, params));
    }

    @Test
    public void testNegativeTrianglePoints() {
        Parameters params = new Parameters(0,0,0,0,0,2.99,
                0, 0,0,0,0,0,0,0,0,0,1,
                2,0);
        Point a = new Point(0,0);
        Point b = new Point(-1,-1);
        Point c = new Point(0,0);
        Point d = new Point(2,-1);
        Point e = new Point(0,0);
        Point f = new Point(0,0);
        Point g = new Point(2,1);
        // Check triangle with area 3
        Point[] pts = {a, b, c, d, e, f, g};
        Assert.assertTrue(Decide.LIC10(pts, params));
    }

    @Test
    public void testNoTriangle() {
        Parameters params = new Parameters(0,0,0,0,0,3,
                0, 0,0,0,0,0,0,0,0,0,1,
                2,0);
        Point a = new Point(0,0);
        Point b = new Point(1,1);
        Point c = new Point(0,0);
        Point d = new Point(4,1);
        Point e = new Point(0,0);
        Point f = new Point(0,0);
        Point g = new Point(4,3);
        // Check triangle with area 3
        Point[] pts = {a, b, c, d, e, f, g};
        Assert.assertFalse(Decide.LIC10(pts, params));

    }

    @Test
    public void testNumPoints() {
        Parameters params = null;
        Point a = new Point(0,0);
        Point b = new Point(0,0);
        Point c = new Point(0,0);
        Point d = new Point(0,0);
        // Too few points
        Point[] pts = {a, b, c, d};
        Assert.assertFalse(Decide.LIC10(pts, params));
    }

    @Test
    public void testEmptyPointArray() {
        Parameters params = null;
        Point[] pts = {};
        Assert.assertFalse(Decide.LIC10(pts, params));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalEptsFpts() {
        Parameters params = new Parameters(0,0,0,0,0,3,
                0, 0,0,0,0,0,0,0,0,0,0,
                0,0);
        Point a = new Point(0,0);
        Point b = new Point(0,0);
        Point c = new Point(0,0);
        Point d = new Point(0,0);
        Point e = new Point(0,0);
        Point[] pts = {a, b, c, d, e};
        TestUtils.checkErrorMessage(() -> Decide.LIC10(pts, params),
                "e_pts and f_pts must be greater than or equals to 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSumEptsFpts() {
        Parameters params = new Parameters(0,0,0,0,0,3,
                0, 0,0,0,0,0,0,0,0,0,1,
                2,0);
        Point a = new Point(0,0);
        Point b = new Point(0,0);
        Point c = new Point(0,0);
        Point d = new Point(0,0);
        Point e = new Point(0,0);
        Point[] pts = {a, b, c, d, e};
        TestUtils.checkErrorMessage(() -> Decide.LIC10(pts, params),
                "Condition (e_pts + f_pts) <= (numpoints - 3) is not met.");
    }


}
