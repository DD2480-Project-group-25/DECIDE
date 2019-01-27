import org.junit.Assert;
import org.junit.Test;

public class TestLIC5 {

    @Test
    public void testNegativeDifference() {
        Point a = new Point(1,0);
        Point b = new Point(4,0);
        Point c = new Point(1,0);
        Point[] pts = {a, b, c};
        Assert.assertTrue(Decide.LIC5(pts));
    }

    @Test
    public void testPositiveDifference() {
        Point a = new Point(1,0);
        Point b = new Point(2,0);
        Point c = new Point(3,0);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC5(pts));
    }

    @Test
    public void testNoDifference() {
        Point a = new Point(1,0);
        Point b = new Point(1,0);
        Point c = new Point(1,0);
        Point[] pts = {a, b, c};
        Assert.assertFalse(Decide.LIC5(pts));
    }

    @Test
    public void testEmptyPointArray() {
        Point[] pts = {};
        Assert.assertFalse(Decide.LIC5(pts));
    }
}