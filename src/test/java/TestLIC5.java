import org.junit.Assert;
import org.junit.Test;

public class TestLIC5 {

  /**
   * Test that method finds the negative distance difference between point c and point b, when the
   * c.X - b.X is calculated, and returns true
   */
  @Test
  public void testNegativeDifference() {
    Point a = new Point(1, 0);
    Point b = new Point(4, 0);
    Point c = new Point(1, 0);
    Point[] pts = {a, b, c};
    Assert.assertTrue(Decide.LIC5(pts));
  }

  /**
   * Test that method find the positive distance difference between point b and point a, and point c
   * and point b, and returns false
   */
  @Test
  public void testPositiveDifference() {
    Point a = new Point(1, 0);
    Point b = new Point(2, 0);
    Point c = new Point(3, 0);
    Point[] pts = {a, b, c};
    Assert.assertFalse(Decide.LIC5(pts));
  }

  /**
   * Test that the method returns false when there is no difference between the points x-coordinates
   */
  @Test
  public void testNoDifference() {
    Point a = new Point(1, 0);
    Point b = new Point(1, 0);
    Point c = new Point(1, 0);
    Point[] pts = {a, b, c};
    Assert.assertFalse(Decide.LIC5(pts));
  }

  /** Test that method handles an empty point array correct and returns false */
  @Test
  public void testEmptyPointArray() {
    Point[] pts = {};
    Assert.assertFalse(Decide.LIC5(pts));
  }
}
