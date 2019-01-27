import org.junit.Assert;

/** Collection of helper functions useful in tests. */
class TestUtils {

  /**
   * Asserts error message is as expected, if an error is thrown.
   *
   * <p>If an exception is thrown, then this function will rethrow the exception .
   *
   * @param function function to run
   * @param expectedErrorMessage the expected error message
   */
  static void checkErrorMessage(Runnable function, String expectedErrorMessage) {
    try {
      function.run();
    } catch (Exception e) {
      Assert.assertEquals(expectedErrorMessage, e.getMessage());
      throw e;
    }
  }
}
