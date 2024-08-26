import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.controller.SortingAlgorithmController;
import org.junit.jupiter.api.Test;

class TestSortingAlgorithmController {

  final String className = "TestSortingAlgorithmController";

  @Test
  void testCreateSortingControllerObject() { // Test 01
    String testName = "testCreateSortingControllerObject";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SortingAlgorithmController testSortController = new SortingAlgorithmController();
      assertTrue(testSortController instanceof SortingAlgorithmController,
          "Test that a new instance of SortingAlgorithmController is created successfully");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of "
          + "SortingAlgorithmController; " + e.getMessage());
    }
  }

}
