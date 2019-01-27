import org.junit.Assert;
import org.junit.Test;

public class TestLIC11 {
  // Tests LIC11, which is true if there exists at least one set of two data points, separated by
  // exactly g_pts consecutive intervening points, such that the first data point is to the right
  // of the second point on the x-axis.

  @Test
  public void testPositive() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    Point a = new Point(2, 2);
    Point b = new Point(1, 1);
    Point c = new Point(0, 0);
    Point[] pts = {a, b, c};
    Assert.assertTrue(Decide.LIC11(pts, params));
  }

  @Test
  public void testNegative() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    Point a = new Point(0, 0);
    Point b = new Point(1, 1);
    Point c = new Point(2, 2);
    Point[] pts = {a, b, c};
    Assert.assertFalse(Decide.LIC11(pts, params));
  }

  @Test
  public void badData() {
    // LIC11 should return false if there is less than three data points.
    Point a = new Point(1, 1);
    Point b = new Point(3, 3);
    Point c = new Point(4, 4);

    Point[] pts0 = {a, b};
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    Assert.assertFalse(Decide.LIC11(pts0, params));

    // LIC11 should return false if number of data points - 2 are less than g_pts.
    Point[] pts1 = {a, b, c};
    Parameters bigGpts = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    Assert.assertFalse(Decide.LIC11(pts1, bigGpts));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument() {
    Point a = new Point(1, 1);
    Point b = new Point(3, 3);
    Point c = new Point(2, 2);
    Point[] pts = {a, b, c};
    Parameters illegalG_pts =
        new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Decide.LIC11(pts, illegalG_pts);
  }
}
