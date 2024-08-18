import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import org.junit.jupiter.api.Test;

class TestSortingAlgorithmMetrics {

  final String className = "TestSortingAlgorithmMetrics";

  @Test
  void testCreateSortingAlgorithmMetricsObject() {
    String testName = "testCreateSortingAlgorithmMetricsObject";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertTrue(testMetrics instanceof SortingAlgorithmMetrics,
          "Test that a new instance of SortingAlgorithmMetrics is created successfully");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testGetComparisons() {
    String testName = "testGetComparisons";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getComparisons(), "Test that getComparisons() on a "
          + "SortingAlgorithmMetrics object after initialization returns 0");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing getComparisons() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testGetSwaps() {
    String testName = "testGetSwaps";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getSwaps(), "Test that getSwaps() on a SortingAlgorithmMetrics "
          + "object after initialization returns 0");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing getSwaps() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testGetPasses() {
    String testName = "testGetPasses";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getPasses(), "Test that getPasses() on a SortingAlgorithmMetrics "
          + "object after initialization returns 0");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing getPasses() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testSetComparisons() {
    String testName = "testSetComparisons";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getComparisons(), "Test that getComparisons() on a "
          + "SortingAlgorithmMetrics object before calling setComparisons() returns 0");
      testMetrics.setComparisons(50);
      assertEquals(50, testMetrics.getComparisons(), "Test that getComparisons() on a "
          + "SortingAlgorithmMetrics object after calling setComparisons() returns 50");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing setComparisons() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testSetSwaps() {
    String testName = "testGetSwaps";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getSwaps(), "Test that getSwaps() on a SortingAlgorithmMetrics "
          + "object before calling setSwaps() returns 0");
      testMetrics.setSwaps(100);
      assertEquals(100, testMetrics.getSwaps(), "Test that getSwaps() on a SortingAlgorithmMetrics "
          + "object after calling setSwaps() returns 100");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing setSwaps() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testSetPasses() {
    String testName = "testSetPasses";
    AuxiliaryTestMethods.logMessage(className, testName + "started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getPasses(), "Test that getPasses() on a SortingAlgorithmMetrics "
          + "object before calling setPasses() returns 0");
      testMetrics.setPasses(150);
      assertEquals(150, testMetrics.getPasses(), "Test that getPasses() on a "
          + "SortingAlgorithmMetrics object after calling setPasses() returns 150");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing setPasses() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testIncrementComparisons() {
    String testName = "testIncrementComparisons";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      for (int i = 0; i <= 1000; i++) {
        assertEquals(i, testMetrics.getComparisons(), "Test that the quantity of comparisons in a "
            + "SortingAlgorithmMetrics instance equals " + Integer.toString(i));
        testMetrics.incrementComparisons();
      }
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing incrementComparisons() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testIncrementSwaps() {
    String testName = "testIncrementSwaps";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      for (int i = 0; i <= 1000; i++) {
        assertEquals(i, testMetrics.getSwaps(), "Test that the quantity of swaps in a "
            + "SortingAlgorithmMetrics instance equals " + Integer.toString(i));
        testMetrics.incrementSwaps();
      }
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing incrementSwaps() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testIncrementPasses() {
    String testName = "testIncrementPasses";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      for (int i = 0; i <= 1000; i++) {
        assertEquals(i, testMetrics.getPasses(), "Test that the quantity of passes in a "
            + "SortingAlgorithmMetrics instance equals " + Integer.toString(i));
        testMetrics.incrementPasses();
      }
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing incrementPasses() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testGetArrayAccesses() {
    String testName = "testGetArrayAccesses";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that getArrayAccesses() on a "
          + "SortingAlgorithmMetrics object after initialization returns 0");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing getArrayAccesses() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testSetArrayAccesses() {
    String testName = "testSetArrayAccesses";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that getArrayAccesses() on a "
          + "SortingAlgorithmMetrics object before calling setArrayAccesses() returns 0");
      testMetrics.setArrayAccesses(1550);
      assertEquals(1550, testMetrics.getArrayAccesses(), "Test that getArrayAccesses() on a "
          + "SortingAlgorithmMetrics object after calling setArrayAccesses() returns 50");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing setArrayAccesses() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testIncreaseArrayAccesses() {
    String testName = "testIncreaseArrayAccesses";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that getArrayAccesses() on a "
          + "SortingAlgorithmMetrics object before calling increaseArrayAccesses() returns 0");
      testMetrics.increaseArrayAccesses(128);
      assertEquals(128, testMetrics.getArrayAccesses(), "Test that getArrayAccesses() on a "
          + "SortingAlgorithmMetrics object after calling increaseArrayAccesses() returns 128");
      for (int i = 0; i <= 1000; i++) {
        assertEquals(i * 4 + 128, testMetrics.getArrayAccesses(),
            "Test that the quantity of array accesses in a SortingAlgorithmMetrics instance equals "
                + Integer.toString(i * 4 + 128));
        testMetrics.increaseArrayAccesses(4);
      }
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing testIncreaseArrayAccesses() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }

  @Test
  void testIncreaseComparisons() {
    String testName = "testIncreaseComparisons";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SortingAlgorithmMetrics testMetrics = new SortingAlgorithmMetrics();
      assertEquals(0, testMetrics.getComparisons(), "Test that getComparisons() on a "
          + "SortingAlgorithmMetrics object before calling increaseComparisons() returns 0");
      testMetrics.increaseComparisons(128);
      assertEquals(128, testMetrics.getComparisons(), "Test that getComparisons() on a "
          + "SortingAlgorithmMetrics object after calling increaseComparisons() returns 128");
      for (int i = 0; i <= 1000; i++) {
        assertEquals(i * 4 + 128, testMetrics.getComparisons(),
            "Test that the quantity of comparisons in a SortingAlgorithmMetrics instance equals "
                + Integer.toString(i * 4 + 128));
        testMetrics.increaseComparisons(4);
      }
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing testIncreaseComparisons() on an instance of "
          + "SortingAlgorithmMetrics; " + e.getMessage());
    }
  }
}
