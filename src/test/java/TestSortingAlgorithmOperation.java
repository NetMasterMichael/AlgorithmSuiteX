import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


class TestSortingAlgorithmOperation {

  final String className = "TestSortingAlgorithmOperation";

  @AfterEach
  void cleanupMemory() {
    System.gc();
  }

  @Test
  void testInitialiseSortingAlgorithmOperation_Swap() {
    String testName = "testInitialiseSortingAlgorithmOperation_Swap";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SortingAlgorithmOperation testOperation = SortingAlgorithmOperation.SWAP;
      assertTrue(testOperation == SortingAlgorithmOperation.SWAP,
          "Test that a new SortingAlgorithmObject correctly initialises with operation SWAP");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating a SortingAlgorithmOperation object of"
          + " type SWAP; " + e.getMessage());
    }
  }

  @Test
  void testInitialiseSortingAlgorithmOperation_Compare() {
    String testName = "testInitialiseSortingAlgorithmOperation_Compare";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SortingAlgorithmOperation testOperation = SortingAlgorithmOperation.COMPARE;
      assertTrue(testOperation == SortingAlgorithmOperation.COMPARE, "Test that a new "
          + "SortingAlgorithmObject correctly initialises with operation COMPARE");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating a SortingAlgorithmOperation object of"
          + " type COMPARE; " + e.getMessage());
    }
  }

  @Test
  void testInitialiseSortingAlgorithmOperation_Move_Literal() {
    String testName = "testInitialiseSortingAlgorithmOperation_Move_Literal";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SortingAlgorithmOperation testOperation = SortingAlgorithmOperation.MOVE_LITERAL;
      assertTrue(testOperation == SortingAlgorithmOperation.MOVE_LITERAL, "Test that a new "
          + "SortingAlgorithmObject correctly initialises with operation MOVE_LITERAL");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating a SortingAlgorithmOperation object "
          + "of type MOVE_LITERAL; " + e.getMessage());
    }
  }

}
