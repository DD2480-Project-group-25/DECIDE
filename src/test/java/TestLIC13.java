import org.junit.Assert;
import org.junit.Test;

public class TestLIC13 {
  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalA() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC13
            0, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 0, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0),
    };

    TestUtils.checkErrorMessage(
        () -> Decide.LIC13(pts, params), "A_PTS must be greater or equal to 1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalB() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC13
            0, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC13
            0, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0),
    };

    TestUtils.checkErrorMessage(
        () -> Decide.LIC13(pts, params), "B_PTS must be greater or equal to 1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalAB() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC13
            0, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 0, // Only interesting parameters for LIC13
            0, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0),
    };

    TestUtils.checkErrorMessage(
        () -> Decide.LIC13(pts, params), "A_PTS and B_PTS must be greater or equal to 1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalRadius2() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC13
            -1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0),
    };

    TestUtils.checkErrorMessage(
        () -> Decide.LIC13(pts, params), "RADIUS2 must be greater or equal to 0");
  }

  @Test
  public void TestFewerThanFivePoints() {
    Parameters params =
        new Parameters(
            0, 0, 0, // Only interesting parameters for LIC13
            0, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0),
    };

    Assert.assertFalse(Decide.LIC13(pts, params));
  }

  @Test
  public void TestBothConditionsOk() {
    Parameters params =
        new Parameters(
            0, 0, 2, // Only interesting parameters for LIC13
            4, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(2, 0), new Point(4, 0), new Point(6, 0), new Point(8, 0),
    };

    Assert.assertTrue(Decide.LIC13(pts, params));
  }

  @Test
  public void TestFirstConditionsOk() {
    Parameters params =
        new Parameters(
            0, 0, 2, // Only interesting parameters for LIC13
            3, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(2, 0), new Point(4, 0), new Point(6, 0), new Point(8, 0),
    };

    Assert.assertFalse(Decide.LIC13(pts, params));
  }

  @Test
  public void TestSecondConditionsOk() {
    Parameters params =
        new Parameters(
            0, 0, 4, // Only interesting parameters for LIC13
            2, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(2, 0), new Point(4, 0), new Point(6, 0), new Point(8, 0),
    };

    Assert.assertFalse(Decide.LIC13(pts, params));
  }

  @Test
  public void TestNoConditionsOk() {
    Parameters params =
        new Parameters(
            0, 0, 4, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0, 0, 0, 0, 1, // Only interesting parameters for LIC13
            1, // Only interesting parameters for LIC13
            0, 0, 0, 0, 0);

    Point[] pts = {
      new Point(0, 0), new Point(2, 0), new Point(4, 0), new Point(6, 0), new Point(8, 0),
    };

    Assert.assertFalse(Decide.LIC13(pts, params));
  }
}
