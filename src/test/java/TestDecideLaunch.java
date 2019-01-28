import org.junit.Assert;
import org.junit.Test;

public class TestDecideLaunch {

  /** Test that decideLanuch method returns true when all elements in the PUV are false. */
  @Test
  public void testDecideLaunchYes() {
    Parameters params = new Parameters(1, 1, 1, 1, 0, 1, 1, 1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1);
    Point[] pts = {new Point(1, 1), new Point(2, 2), new Point(2, 3)};

    for (int i = 0; i < 15; i++) {
      Decide.PUV[i] = false;
    }
    boolean expected = true;
    boolean result = Decide.decideLaunch(pts, params);
    Assert.assertEquals(expected, result);
  }
  /**
   * Test that decideLanuch method returns false when there are less than 3 points (most LICs are
   * not met when datapoints are less than 3)
   */
  @Test
  public void testDecideLaunchNo() {
    Parameters params = new Parameters(1, 1, 1, 1, 0, 1, 1, 1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1);
    Point[] pts = {new Point(1, 1), new Point(2, 2)};
    boolean expected = false;
    boolean result = Decide.decideLaunch(pts, params);
    Assert.assertEquals(expected, result);
  }

  /** Test the calculatePUM method */
  @Test
  public void testCalculatePUM() {
    Decide.CMV[0] = true;
    Decide.CMV[1] = true;
    Decide.CMV[2] = false;
    Decide.CMV[3] = true;
    Decide.CMV[4] = true;
    Decide.CMV[5] = false;
    Decide.CMV[6] = false;
    Decide.CMV[7] = true;
    Decide.CMV[8] = false;
    Decide.CMV[9] = true;
    Decide.CMV[10] = true;
    Decide.CMV[11] = false;
    Decide.CMV[12] = false;
    Decide.CMV[13] = false;
    Decide.CMV[14] = false;

    boolean[][] PUM = {
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, false, false, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, false, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
    };

    boolean[][] result = Decide.calculatePUM();

    Assert.assertArrayEquals(PUM, result);
  }
  /** Test the calculateFUV method */
  @Test
  public void testCalculateFUV() {
    boolean[][] PUM = {
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, false, false, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, false, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
      {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
    };

    boolean[] tmp = {
      true, true, true, true, true, false, false, false, false, false, false, false, false, false,
      false
    };
    for (int i = 0; i < 15; i++) {
      Decide.PUV[i] = tmp[i];
    }
    boolean[] result = Decide.calculateFUV(PUM);
    boolean[] FUV = {
      true, true, false, false, true, true, true, true, true, true, true, true, true, true, true
    };
    Assert.assertArrayEquals(FUV, result);
  }
}
