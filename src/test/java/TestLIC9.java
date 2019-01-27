import org.junit.Assert;
import org.junit.Test;

public class TestLIC9 {

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

  @Test
  public void testNegative() {
    Parameters params = new Parameters(0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    // Triangle ace, angle is 0.519rad, epsilon=3
    Point a = new Point(0, 0);
    Point b = new Point(2, 3);
    Point c = new Point(-7, 4);
    Point d = new Point(0, 0);
    Point e = new Point(3, 4);
    Point[] pts = {a, b, c, d, e};
    Assert.assertEquals(false, Decide.LIC9(pts, params));
  }

  @Test
  public void testLessThanFivePoints() {
    Parameters params = new Parameters(0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0);
    Point a = new Point(0, 0);
    Point b = new Point(-7, 4);
    Point c = new Point(3, 4);
    Point[] pts = {a, b, c};
    Assert.assertEquals(false, Decide.LIC9(pts, params));
  }

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
