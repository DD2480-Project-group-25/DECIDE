import org.junit.Assert;
import org.junit.Test;

public class TestLIC9 {
  /**
   * Test that LIC9 method works when c_pts = d_pts = 1 and epsilon = 1. The data points form the
   * triangle ace with the angle 0.519rad. This angle fulfills the requriment angle < (PI − EPSILON)
   */
  @Test
  public void testEqualCptsDpts() {
    Parameters params = new Parameters(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    // Triangle ace, angle is 0.519rad
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(-7, 4);
    Point d = new Point(0, 0);
    Point e = new Point(3, 4);
    Point[] pts = {a, b, c, d, e};
    Assert.assertTrue(Decide.LIC9(pts, params));
  }

  /**
   * Test that LIC9 method works epsilon = 1 and different values for c_pts and d_pts. (c_pts = 2
   * and d_pts = 3) The data points form the triangle adh with the angle 0.519rad. This angle
   * fulfills the requriment angle < (PI − EPSILON)
   */
  @Test
  public void testNonEqualCptsDpts() {
    Parameters params = new Parameters(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0);
    // Triangle adh, angle is 0.519rad
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(-2, 1);
    Point d = new Point(-7, 4);
    Point e = new Point(0, 0);
    Point f = new Point(7, 6);
    Point g = new Point(-2, -9);
    Point h = new Point(3, 4);
    Point[] pts = {a, b, c, d, e, f, g, h};
    Assert.assertEquals(true, Decide.LIC9(pts, params));
  }

  /**
   * Test that LIC9 method returns false when epsilon = 3 and c_pts = d_pts = 1. The data points
   * form the triangle ace with the angle 0.519rad. This angle does not fulfill the requriments
   * angle < (PI − EPSILON) or angle > (PI + EPSILON)
   */
  @Test
  public void testNegative() {
    Parameters params = new Parameters(0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    // Triangle ace, angle is 0.519rad
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(-7, 4);
    Point d = new Point(0, 0);
    Point e = new Point(3, 4);
    Point[] pts = {a, b, c, d, e};
    Assert.assertEquals(false, Decide.LIC9(pts, params));
  }

  /** Test that LIC9 method returns false when number of data points is less than 5. */
  @Test
  public void testLessThanFivePoints() {
    Parameters params = new Parameters(0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    Point a = new Point(0, 0);
    Point b = new Point(-7, 4);
    Point c = new Point(3, 4);
    Point[] pts = {a, b, c};
    Assert.assertEquals(false, Decide.LIC9(pts, params));
  }

  /** Check that IllegalArgumentException is thrown c_pts value is invalid */
  @Test(expected = IllegalArgumentException.class)
  public void testCptsIsZero() {
    Parameters params = new Parameters(0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0);
    Point a = new Point(0, 0);
    Point b = new Point(-7, 4);
    Point c = new Point(0, 0);
    Point d = new Point(3, 4);
    Point e = new Point(11, 4);
    Point[] pts = {a, b, c, d, e};

    Decide.LIC9(pts, params);
  }
}
