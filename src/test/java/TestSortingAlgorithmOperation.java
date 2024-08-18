import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmOperation;
import org.junit.jupiter.api.Test;


class TestSortingAlgorithmOperation {

  final String className = "TestSortingAlgorithmOperation";

  @Test
  void testInitialiseSortingAlgorithmOperation_Swap() {
    String testName = "testInitialiseSortingAlgorithmOperation_Swap";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmOperation testOperation = SortingAlgorithmOperation.SWAP;
      assertTrue(testOperation == SortingAlgorithmOperation.SWAP,
          "Test that a new SortingAlgorithmObject correctly initialises with operation SWAP");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e
          + " thrown while testing creating a SortingAlgorithmOperation object of type SWAP; "
          + e.getMessage());
    }
  }

  @Test
  void testInitialiseSortingAlgorithmOperation_Compare() {
    String testName = "testInitialiseSortingAlgorithmOperation_Compare";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmOperation testOperation = SortingAlgorithmOperation.COMPARE;
      assertTrue(testOperation == SortingAlgorithmOperation.COMPARE,
          "Test that a new SortingAlgorithmObject correctly initialises with operation COMPARE");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e
          + " thrown while testing creating a SortingAlgorithmOperation object of type COMPARE; "
          + e.getMessage());
    }
  }

  @Test
  void testInitialiseSortingAlgorithmOperation_Move_Literal() {
    String testName = "testInitialiseSortingAlgorithmOperation_Move_Literal";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmOperation testOperation = SortingAlgorithmOperation.MOVE_LITERAL;
      assertTrue(testOperation == SortingAlgorithmOperation.MOVE_LITERAL,
          "Test that a new SortingAlgorithmObject correctly initialises with "
          + "operation MOVE_LITERAL");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e
          + " thrown while testing creating a SortingAlgorithmOperation object of "
          + "type MOVE_LITERAL; "
          + e.getMessage());
    }
  }

}
