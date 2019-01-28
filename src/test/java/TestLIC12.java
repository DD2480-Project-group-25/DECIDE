import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestLIC12 {
  @Rule public final ExpectedException exception = ExpectedException.none();

  /**
   * Creates 6 points along the Y-axis: [0,2,4,4,5,6]. Verifies that it is
   * possible to find at least two instances of points, separated by two
   * consecutive points, where distance for the first set is greater than 4 and
   * the other is less than 3.01.
   */
  @Test
  public void testPositive() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 2);
    Point p3 = new Point(0, 3);
    Point p4 = new Point(0, 4);
    Point p5 = new Point(0, 5);
    Point p6 = new Point(0, 6);
    Point[] pts = new Point[] {p1, p2, p3, p4, p5, p6};
    Parameters params =
        new Parameters(3.99, 3.01, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0);

    boolean res = Decide.LIC12(pts, params);
    Assert.assertTrue(res);
  }

  /**
   * Creates 6 points along the Y-axis: [0,2,4,4,5,6]. Verifies that it is NOT
   * possible to find at least two instances of points, separated by two
   * consecutive points, where distance for the first set is greater than 3.99
   * and the other is less than 3.
   */
  @Test
  public void testNegative() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 2);
    Point p3 = new Point(0, 3);
    Point p4 = new Point(0, 4);
    Point p5 = new Point(0, 5);
    Point p6 = new Point(0, 6);

    Point[] pts = new Point[] {p1, p2, p3, p4, p5, p6};
    Parameters params = new Parameters(3.99, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0);

    boolean res = Decide.LIC12(pts, params);
    Assert.assertFalse(res);
  }

  /**
   * Verify that a list of length 2 generates a false result, as it is not
   * possible to find any set with at least one separating point from a set of
   * two data points.
   */
  @Test
  public void testShortList() {
    Point[] pts = new Point[2];
    Parameters params =
        new Parameters(3.99, 2.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    Boolean res = Decide.LIC12(pts, params);
    Assert.assertFalse(res);
  }

  /**
   * Verify that negative length on parameter length2 causes an exception as
   * stated in LIC12.
   */
  @Test
  public void testException() {
    Point[] pts = new Point[3];
    Parameters params =
        new Parameters(3.99, -0.01, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0);

    exception.expect(IllegalArgumentException.class);
    Decide.LIC12(pts, params);
  }
}
