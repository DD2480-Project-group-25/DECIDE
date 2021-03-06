import org.junit.Assert;
import org.junit.Test;

public class TestLIC14 {
  /**
   * Test that LIC14 method works. Same set of three consecutive data points (a,c,e) satisfies the
   * conditions. e_pts=1, d_pts=1, Area1=20, Area2=30, (area=28)
   */
  @Test
  public void testSameSet() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 20, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0);
    // Triangle ace
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(0, 7);
    Point d = new Point(0, 0);
    Point e = new Point(8, 0);
    Point[] pts = {a, b, c, d, e};
    Assert.assertTrue(Decide.LIC14(pts, params));
  }

  /**
   * Test that LIC14 method works. Different sets of three consecutive points satisfies the
   * conditions (a,c,f and b,d,g) e_pts=1, d_pts=2, Area1=20, Area2=22 Area of triangle acf = 28 &
   * area of triangle bdg = 21
   */
  @Test
  public void testDifferentSet() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 20, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0);
    // Triangles acf and bdg
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(0, 7);
    Point d = new Point(2, 9);
    Point e = new Point(0, 0);
    Point f = new Point(8, 0);
    Point g = new Point(9, 1);

    Point[] pts = {a, b, c, d, e, f, g};
    Assert.assertTrue(Decide.LIC14(pts, params));
  }

  /**
   * Test that LIC14 returns false when ONLY one condition is met. Only one condition is met, area
   * is not lesser than AREA2 e_pts=1, d_pts=1, Area1=20, Area2=27, (area=28)
   */
  @Test
  public void testOneConditionIsMet() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 20, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0);
    // Triangle ace
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(0, 7);
    Point d = new Point(0, 0);
    Point e = new Point(8, 0);
    Point[] pts = {a, b, c, d, e};
    Assert.assertFalse(Decide.LIC14(pts, params));
  }

  /** Test that LIC14 returns false when none of the conditions are met. */
  @Test
  public void testNoConditionIsMet() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 29, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0);
    // Triangle ace
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(0, 7);
    Point d = new Point(0, 0);
    Point e = new Point(8, 0);
    Point[] pts = {a, b, c, d, e};
    Assert.assertFalse(Decide.LIC14(pts, params));
  }

  /** Check that IllegalArgumentException is thrown when area is negative */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeArea() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, -1, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0);
    Point a = new Point(0, 0);
    Point b = new Point(-7, 4);
    Point c = new Point(0, 0);
    Point d = new Point(3, 4);
    Point e = new Point(11, 4);
    Point[] pts = {a, b, c, d, e};

    Decide.LIC14(pts, params);
  }

  /** Test that LIC14 method returns false when number of points is less than 5. */
  @Test
  public void testLessThanFivePoints() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0);
    Point a = new Point(0, 0);
    Point b = new Point(-7, 4);
    Point c = new Point(3, 4);
    Point[] pts = {a, b, c};
    Assert.assertEquals(false, Decide.LIC14(pts, params));
  }
}
