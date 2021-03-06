import org.junit.Assert;
import org.junit.Test;

public class TestLIC0 {

  /**
   * Three points where the distance between point b and point c is ≈11,31 and the distances is
   * compared to length1 = 10
   */
  @Test
  public void testDistance() {
    Parameters params = new Parameters(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    // Distance between b and c should be greater than 10
    Point a = new Point(1, 1);
    Point b = new Point(2, 2);
    Point c = new Point(10, 10);
    Point[] pts = {a, b, c};
    Assert.assertTrue(Decide.LIC0(pts, params));
  }

  /**
   * Three points where no consecutive points have a distance between them that is greater than
   * lenght1 = 10. The distance between point b and c is ≈9.90
   */
  @Test
  public void testNoDistance() {
    // There is no distance between two consecutive points that is greater than 10
    Parameters params = new Parameters(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point a = new Point(1, 1);
    Point b = new Point(2, 2);
    Point c = new Point(9, 9);
    Point[] pts = {a, b, c};
    Assert.assertFalse(Decide.LIC0(pts, params));
    Assert.assertFalse(Decide.LIC0(pts, params));
  }

  /** Test that method handles an empty point array correct and returns false */
  @Test
  public void testEmptyPointArray() {
    Parameters params = new Parameters(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point[] pts = {};
    Assert.assertFalse(Decide.LIC0(pts, params));
  }

  /** Test that the method handles negative coordinates in a proper way */
  @Test
  public void testNegativeCoordinates() {
    Parameters params = new Parameters(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point a = new Point(-3, -3);
    Point b = new Point(5, 4);
    Point[] pts1 = {a, b};
    Assert.assertTrue(Decide.LIC0(pts1, params));

    Point c = new Point(-4, -4);
    Point[] pts2 = {a, c};
    Assert.assertFalse(Decide.LIC0(pts2, params));
  }

  /** Test that if length1 < 0, the method should throw an IllegalArgumentException */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgument() {
    Point a = new Point(1, 1);
    Point b = new Point(10, 10);
    Point[] pts = {a, b};
    Parameters params = new Parameters(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Decide.LIC0(pts, params);
  }
}
