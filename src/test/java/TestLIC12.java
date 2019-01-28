import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestLIC12 {
  @Rule public final ExpectedException exception = ExpectedException.none();

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

  @Test
  public void testShortList() {
    Point[] pts = new Point[2];
    Parameters params =
        new Parameters(3.99, 2.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    Boolean res = Decide.LIC12(pts, params);
    Assert.assertFalse(res);
  }

  @Test
  public void testException() {
    Point[] pts = new Point[3];
    Parameters params =
        new Parameters(3.99, -0.01, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0);

    exception.expect(IllegalArgumentException.class);
    Decide.LIC12(pts, params);
  }
}
