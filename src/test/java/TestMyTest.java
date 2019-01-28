import org.junit.Assert;
import org.junit.Test;

public class TestMyTest {
  @Test
  public void testMessageProvider() {
    String expected = "Hello world!";
    String actual = MyTest.messageProvider();
    Assert.assertEquals(expected, actual);
  }
}
