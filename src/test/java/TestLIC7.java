import org.junit.Assert;
import org.junit.Test;

public class TestLIC7 {

  /**
   * Test with 6 points. Finds 2 points with dist greater than 2 with 4 consecutive points between
   */
  @Test
  public void testPositive() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0.5, 0);
    Point p3 = new Point(1, 0);
    Point p4 = new Point(1.5, 0);
    Point p5 = new Point(2, 0);
    Point p6 = new Point(2.5, 0);
    Point[] pts = new Point[] {p1, p2, p3, p4, p5, p6};
    Parameters params = new Parameters(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0);

    boolean res = Decide.LIC7(pts, params);
    Assert.assertTrue(res);
  }

  /** Verify that it is not possible to find two points with 5 points between a set of 6 points */
  @Test(expected = IllegalArgumentException.class)
  public void testException() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0.5, 0);
    Point p3 = new Point(1, 0);
    Point p4 = new Point(1.5, 0);
    Point p5 = new Point(2, 0);
    Point p6 = new Point(2.5, 0);
    Point[] pts = new Point[] {p1, p2, p3, p4, p5, p6};
    Parameters params = new Parameters(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0);

    Decide.LIC7(pts, params);
  }

  /**
   * Verify that there is no set of two points, with two consecutive points between, that have a
   * distance greater than 2
   */
  @Test
  public void testNegative() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0.5, 0);
    Point p3 = new Point(1, 0);
    Point p4 = new Point(1.5, 0);
    Point p5 = new Point(2, 0);
    Point p6 = new Point(2.5, 0);
    Point[] pts = new Point[] {p1, p2, p3, p4, p5, p6};
    Parameters params = new Parameters(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0);

    boolean res = Decide.LIC7(pts, params);
    Assert.assertFalse(res);
  }

  @Test
  public void testShortList() {
    Point[] pts = new Point[2];
    Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0);

    boolean res = Decide.LIC7(pts, params);
    Assert.assertFalse(res);
  }
}
