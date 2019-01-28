import org.junit.Assert;
import org.junit.Test;

public class TestLIC2 {
  /** Assert that exception is thrown if epsilon is configured as higher value than PI */
  @Test(expected = IllegalArgumentException.class)
  public void testTrowsHighEpsilon() {
    Parameters params = new Parameters(0, 0, 0, 0, 3.2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point[] pts = new Point[1];

    TestUtils.checkErrorMessage(
            () -> Decide.LIC2(pts, params), "Condition: 0 ≤ EPSILON < PI, is not fulfilled. Check configuration for EPSILON");
  }

  /** Assert that exception is thrown if epsilon is configured as lower than zero */
  @Test(expected = IllegalArgumentException.class)
  public void testTrowsLowEpsilon() {
    Parameters params = new Parameters(0, 0, 0, 0, -0.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point[] pts = new Point[1];

    TestUtils.checkErrorMessage(
            () -> Decide.LIC2(pts, params), "Condition: 0 ≤ EPSILON < PI, is not fulfilled. Check configuration for EPSILON");
  }

  @Test
  public void testShortList() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point[] pts = new Point[2];
    boolean res = Decide.LIC2(pts, params);
    Assert.assertFalse(res);
  }

  /** This test will generate a angle with PI/2 radians,epsilon is set to 0 */
  @Test
  public void testVerifyAccepting() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point p1 = new Point(0, 4);
    Point p2 = new Point(0, 0);
    Point p3 = new Point(4, 0);
    Point[] pts = new Point[] {p1, p2, p3};

    boolean res = Decide.LIC2(pts, params);

    Assert.assertTrue(res);
  }

  /** This test will generate a angle with PI/2 radians, epsilon is set to 0 */
  @Test
  public void testVerifyRefuse() {
    Parameters params =
        new Parameters(0, 0, 0, 0, Math.PI / 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point p1 = new Point(0, 4);
    Point p2 = new Point(0, 0);
    Point p3 = new Point(4, 0);
    Point[] pts = new Point[] {p1, p2, p3};

    boolean res = Decide.LIC2(pts, params);

    Assert.assertTrue(res);
  }
}
