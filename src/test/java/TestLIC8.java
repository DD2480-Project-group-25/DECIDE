import org.junit.Assert;
import org.junit.Test;

public class TestLIC8 {
  /** Test that an exception is thrown when A_PTS is invalid. */
  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalA() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // Only interesting parameters for LIC8
            1, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0);

    Point[] pts = {new Point(0, 0)};

    TestUtils.checkErrorMessage(
        () -> Decide.LIC8(pts, params), "A_PTS must be greater or equal to 1");
  }

  /** Test that an exception is thrown when B_PTS is invalid. */
  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalB() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC8
            0, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0);

    Point[] pts = {new Point(0, 0)};

    TestUtils.checkErrorMessage(
        () -> Decide.LIC8(pts, params), "B_PTS must be greater or equal to 1");
  }

  /** Test that false is returned when there are fewer than five points. */
  @Test
  public void TestFewerThanFivePoints() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC8
            1, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3),
    };

    Assert.assertFalse(Decide.LIC8(pts, params));
  }

  /**
   * Test that an exceptions is thrown if there are fewer points than required as a consequence of
   * A_PTS and B_PTS.
   */
  @Test(expected = IllegalArgumentException.class)
  public void TestFewerPointsThanRequired() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0, 0, 0, 0, 0, 5, // Only interesting parameters for LIC8
            5, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(3, 3),
    };

    TestUtils.checkErrorMessage(
        () -> Decide.LIC8(pts, params), "A_PTS + B_PTS not less or equal to NUMPOINTS -3");
  }

  /** Test that true is returned with an example of an input that do satisfy LIC8. */
  @Test
  public void TestPositive() {
    Parameters params =
        new Parameters(
            0, 0, 2, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC8
            1, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(2, 0), new Point(4, 0), new Point(6, 0), new Point(8, 0),
    };

    Assert.assertTrue(Decide.LIC8(pts, params));
  }

  /** Test that false is returned with an example of an input that do not satisfy LIC8. */
  @Test
  public void TestNegative() {
    Parameters params =
        new Parameters(
            0, 0, 4, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC8
            1, // Only interesting parameters for LIC8
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(2, 0), new Point(4, 0), new Point(6, 0), new Point(8, 0),
    };

    Assert.assertFalse(Decide.LIC8(pts, params));
  }
}
