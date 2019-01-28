import org.junit.Assert;
import org.junit.Test;

/**
 * Assert that LIC11 can successfully determine if there exists at least one set of two data points,
 * separated by exactly g_pts consecutive intervening points, such that the first data point is to
 * the right of the second point on the x-axis.
 */
public class TestLIC11 {

  /**
   * Assert that two points a:(0,1) c:(2,3) separated by g_pts are evaluated as true as a is to the
   * right of c on the x-axis.
   */
  @Test
  public void testPositive() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    Point a = new Point(2, 3);
    Point b = new Point(1, 1);
    Point c = new Point(0, 1);
    Point[] pts = {a, b, c};
    Assert.assertTrue(Decide.LIC11(pts, params));
  }

  /**
   * Assert that two points a:(2,3) c:(0,1) separated by g_pts are evaluated as false as a is NOT to
   * the right of c on the x-axis.
   */
  @Test
  public void testNegative() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
    Point a = new Point(0, 1);
    Point b = new Point(1, 1);
    Point c = new Point(2, 3);
    Point[] pts = {a, b, c};
    Assert.assertFalse(Decide.LIC11(pts, params));
  }

  /**
   * Assert that lack of enough data points yields a negative result. Firstly asserting that LIC11
   * return false if there is less than three data points. Secondly asserts that LIC11 returns false
   * if number of data points-2 are less than g_pts.
   */
  @Test
  public void badData() {
    Point a = new Point(1, 1);
    Point b = new Point(3, 3);
    Point c = new Point(4, 4);

    Point[] pts0 = {a, b};
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    Assert.assertFalse(Decide.LIC11(pts0, params));
      
    Point[] pts1 = {a, b, c};
    Parameters bigGpts = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);
    Assert.assertFalse(Decide.LIC11(pts1, bigGpts));
  }

  /** Assert that an IllegalArgumentException is thrown if g_pts < 1. */
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
