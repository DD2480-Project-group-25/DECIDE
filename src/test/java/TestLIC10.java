import org.junit.Assert;
import org.junit.Test;

public class TestLIC10 {

  /**
   * Two test cases: 1) Test that the method can find the right triangle with vertices at point b, d
   * and g, which are separated by 1 and 2 points respectively. The triangle's area is 3, which is
   * greater than area1 = 2.99. Should return true 2) Test that the method can find the oblique
   * triangle with vertices at point b, h, i, which are separated by 1 and 2 points respectively.
   * The triangle's area is 2.5, which is greater than area1 = 2.49. Should return true
   */
  @Test
  public void testTriangle() {
    Parameters params1 = new Parameters(0, 0, 0, 0, 0, 2.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0);
    Point a = new Point(0, 0);
    Point b = new Point(1, 1);
    Point c = new Point(0, 0);
    Point d = new Point(4, 1);
    Point e = new Point(0, 0);
    Point f = new Point(0, 0);
    Point g = new Point(4, 3);
    // Check right triangle with area 3
    Point[] pts1 = {a, b, c, d, e, f, g};
    Assert.assertTrue(Decide.LIC10(pts1, params1));

    Parameters params2 = new Parameters(0, 0, 0, 0, 0, 2.49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0);
    Point h = new Point(4, 2);
    Point i = new Point(5, 4);
    // Check oblique triangle with area 2.5
    Point[] pts2 = {a, b, c, h, e, f, i, f};
    Assert.assertTrue(Decide.LIC10(pts2, params2));
  }

  /**
   * Test that the method handles a triangle with negative coordinates correct. The triangle have
   * vertices in point b, d and g, which are separated by 1 and 2 points respectively. The area of
   * the triangle is 3, which is compared to area1 = 2.99. Should return true.
   */
  @Test
  public void testNegativeTrianglePoints() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 2.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0);
    Point a = new Point(0, 0);
    Point b = new Point(-1, -1);
    Point c = new Point(0, 0);
    Point d = new Point(2, -1);
    Point e = new Point(0, 0);
    Point f = new Point(0, 0);
    Point g = new Point(2, 1);
    // Check right triangle with area 3
    Point[] pts = {a, b, c, d, e, f, g};
    Assert.assertTrue(Decide.LIC10(pts, params));
  }

  /**
   * Test that the method returns false when there is no triangle with area greater than 1.5. The
   * triangle tested have vertices in point b, c and g, separated by 1 and 2 points respectively
   */
  @Test
  public void testNoTriangle() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 1.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0);
    Point a = new Point(0, 0);
    Point b = new Point(2, 1);
    Point c = new Point(0, 0);
    Point d = new Point(4, 2);
    Point e = new Point(0, 0);
    Point f = new Point(0, 0);
    Point g = new Point(5, 4);
    // Check oblique triangle with area 1.5
    Point[] pts = {a, b, c, d, e, f, g};
    Assert.assertFalse(Decide.LIC10(pts, params));
  }

  /** Test that the method returns false when number of points are less than 5 */
  @Test
  public void testNumPoints() {
    Parameters params = null;
    Point a = new Point(0, 0);
    Point b = new Point(0, 0);
    Point c = new Point(0, 0);
    Point d = new Point(0, 0);
    // Too few points
    Point[] pts = {a, b, c, d};
    Assert.assertFalse(Decide.LIC10(pts, params));
  }

  /** Test that the method handles an empty point array in a correct way and returns false */
  @Test
  public void testEmptyPointArray() {
    Parameters params = null;
    Point[] pts = {};
    Assert.assertFalse(Decide.LIC10(pts, params));
  }

  /**
   * Test that the method throws an IllegalArgumentException when e_pts or f_pts are smaller than 1
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalEptsFpts() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point a = new Point(0, 0);
    Point b = new Point(0, 0);
    Point c = new Point(0, 0);
    Point d = new Point(0, 0);
    Point e = new Point(0, 0);
    Point[] pts = {a, b, c, d, e};
    TestUtils.checkErrorMessage(
        () -> Decide.LIC10(pts, params), "e_pts and f_pts must be greater than or equals to 1");
  }

  /**
   * Test that the method throws an IllegalArgumentException when the condition (e_pts + f_pts) <=
   * (numpoints - 3) is not met
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalSumEptsFpts() {
    Parameters params = new Parameters(0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0);
    Point a = new Point(0, 0);
    Point b = new Point(0, 0);
    Point c = new Point(0, 0);
    Point d = new Point(0, 0);
    Point e = new Point(0, 0);
    Point[] pts = {a, b, c, d, e};
    TestUtils.checkErrorMessage(
        () -> Decide.LIC10(pts, params),
        "Condition (e_pts + f_pts) <= (numpoints - 3) is not met.");
  }
}
