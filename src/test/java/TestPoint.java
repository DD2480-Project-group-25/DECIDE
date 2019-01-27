import org.junit.Assert;
import org.junit.Test;

public class TestPoint {
  @Test
  public void testPointConstruction() {
    Point a = new Point(2, 3);
    Assert.assertEquals(a.X, 2, 0.0001);
    Assert.assertEquals(a.Y, 3, 0.0001);
  }

  @Test
  public void testDistance() {
    Point a = new Point(2, 3);
    Point b = new Point(4, 7);

    double distance = a.distance(b);

    Assert.assertEquals(distance, Math.sqrt(2 * 2 + 4 * 4), 0.0001);
  }
}
