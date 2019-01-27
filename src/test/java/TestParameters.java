import org.junit.Assert;
import org.junit.Test;

public class TestParameters {
  @Test
  public void testParametersConstruction() {
    Parameters params =
        new Parameters(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
    Assert.assertEquals(params.length1, 1, 0.001);
    Assert.assertEquals(params.radius1, 3, 0.001);
    Assert.assertEquals(params.quads, 10);
    Assert.assertEquals(params.a_pts, 13);
    Assert.assertNotEquals(params.a_pts, 12, 0.001);
  }
}
