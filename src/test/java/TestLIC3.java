import org.junit.Assert;
import org.junit.Test;

public class TestLIC3 {

  /** Test that LIC3 can correctly identify a triangle with area larger than area1. */
  @Test
  public void testPositive() {
    Parameters params =
        new Parameters(
            0, 0, 0, 0, 0, 10, // Only interesting parameter for LIC3
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point[] pts = {
      new Point(10, 5),
      new Point(0, 0), // -------
      new Point(10, 0), // these form a triangle with area 50
      new Point(0, 10), // -------
      new Point(6, 6)
    };

    boolean actual = Decide.LIC3(pts, params);

    Assert.assertTrue(actual);
  }

  /** Test that LIC3 can correctly identify if there is no triangle with area larger than area1. */
  @Test
  public void testNegative() {
    Parameters params =
        new Parameters(
            0, 0, 0, 0, 0, 77, // Only interesting parameter for LIC3
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point[] pts = {
      new Point(10, 5),
      new Point(0, 0), // -------
      new Point(10, 0), // these form a triangle with area 50
      new Point(0, 10), // -------
      new Point(6, 6)
    };

    boolean actual = Decide.LIC3(pts, params);

    Assert.assertFalse(actual);
  }

  /** Test that an exception is raised when 0<=AREA1 isn't true. */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArea1Parameter() {
    Parameters params =
        new Parameters(
            0, 0, 0, 0, 0, -101, // Only interesting parameter for LIC3
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    Point[] pts = {
      new Point(10, 5),
      new Point(0, 0), // -------
      new Point(10, 0), // these form a triangle with area 50
      new Point(0, 10), // -------
      new Point(6, 6)
    };

    TestUtils.checkErrorMessage(
        () -> Decide.LIC3(pts, params), "AREA1 must be greater or equal to 0");
  }
}
