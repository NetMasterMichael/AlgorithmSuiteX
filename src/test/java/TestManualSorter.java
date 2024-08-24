import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.BubbleSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.InsertionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.MergeSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SelectionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmOperation;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestManualSorter {

  final String className = "TestManualSorter";

  @AfterEach
  void cleanupMemory() {
    System.gc();
  }

  @Test
  void testCreateManualSorter() {
    String testName = "testCreateManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertTrue(testManualSorter instanceof ManualSorter,
          "Test that a new instance of ManualSorter is created successfully");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of ManualSorter; "
          + e.getMessage());
    }
  }

  @Test
  void testGetArray() {
    String testName = "testGetArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertArrayEquals(new int[] {1, 2, 3}, testManualSorter.getArray(),
          "Test that getArray() returns the correct array from a ManualSorter instance");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getArray() on an instance of ManualSorter; "
          + e.getMessage());
    }
  }

  @Test
  void testEnqueueOperation() {
    String testName = "testEnqueueOperation";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, 0, 1);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 1);
      assertTrue(true, "Test that enqueueOperation() executes successfully with no exceptions on "
          + "a ManualSorter instance");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing enqueueOperation() on an instance of "
          + "ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testSwapOperation() {
    String testName = "testSwapOperation";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2});
      assertArrayEquals(new int[] {1, 2}, testManualSorter.getArray(),
          "Test that array in ManualSorter is the original array before the swap operation");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 1);
      testManualSorter.step();
      assertArrayEquals(new int[] {2, 1}, testManualSorter.getArray(),
          "Test that array in ManualSorter is modified after the swap operation");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing a swap operation with an instance of "
          + "ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testIsSorted() {
    String testName = "testIsSorted";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3, 5, 4, 6, 7});
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 3, 4);
      assertFalse(testManualSorter.isSorted(),
          "Test that isSorted returns false when array is not sorted");
      testManualSorter.step();
      assertTrue(testManualSorter.isSorted(),
          "Test that isSorted returns true when array is sorted");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing the isSorted() method on a ManualSorter "
          + "instance; " + e.getMessage());
    }
  }

  @Test
  void testIsSortable_BubbleSort() {
    String testName = "testIsSortable_BubbleSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array = new int[] {12, 23, 15, 22, 17, 6, 19, 8, 1, 3, 16, 24, 10, 7, 5, 25, 18, 13, 14,
          9, 4, 20, 2, 11, 21};
      BubbleSort bubbleSorter = new BubbleSort(array);
      ManualSorter testManualSorter = bubbleSorter.preComputeManualSort();
      assertEquals(454, testManualSorter.isSortable(-1), "Test that ManualSorter.isSortable() can "
          + "verify if an array is sortable using operations generated by a BubbleSort object");
      assertEquals(-1, testManualSorter.isSortable(10), "Test that ManualSorter.isSortable() will "
          + "return -1 when the operations limit provided is too small");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 6);
      assertEquals(454, testManualSorter.isSortable(-1),
          "Test that ManualSorter.isSortable() returns the correct number of operations required to"
              + " sort an array, excluding unnecessary operations");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing isSortable() on a ManualSorter instance with "
          + "the bubble sort algorithm; " + e.getMessage());
    }
  }

  @Test
  void testIsSortable_SelectionSort() {
    String testName = "testIsSortable_SelectionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array = new int[] {12, 23, 15, 22, 17, 6, 19, 8, 1, 3, 16, 24, 10, 7, 5, 25, 18, 13, 14,
          9, 4, 20, 2, 11, 21};
      SelectionSort selectionSorter = new SelectionSort(array);
      ManualSorter testManualSorter = selectionSorter.preComputeManualSort();
      testManualSorter = selectionSorter.preComputeManualSort();
      assertEquals(318, testManualSorter.isSortable(-1), "Test that ManualSorter.isSortable() can "
          + "verify if an array is sortable using operations generated by a SelectionSort object");
      assertEquals(-1, testManualSorter.isSortable(10), "Test that ManualSorter.isSortable() will "
          + "return -1 when the operations limit provided is too small");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 6);
      assertEquals(318, testManualSorter.isSortable(-1),
          "Test that ManualSorter.isSortable() returns the correct number of operations required to"
              + " sort an array, excluding unnecessary operations");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing isSortable() on a ManualSorter instance with "
          + "the selection sort algorithm; " + e.getMessage());
    }
  }

  @Test
  void testIsSortable_InsertionSort() {
    String testName = "testIsSortable_InsertionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array = new int[] {12, 23, 15, 22, 17, 6, 19, 8, 1, 3, 16, 24, 10, 7, 5, 25, 18, 13, 14,
          9, 4, 20, 2, 11, 21};
      InsertionSort insertionSorter = new InsertionSort(array);
      ManualSorter testManualSorter = insertionSorter.preComputeManualSort();
      testManualSorter = insertionSorter.preComputeManualSort();
      assertEquals(325, testManualSorter.isSortable(-1), "Test that ManualSorter.isSortable() can "
          + "verify if an array is sortable using operations generated by a InsertionSort object");
      assertEquals(-1, testManualSorter.isSortable(10), "Test that ManualSorter.isSortable() will "
          + "return -1 when the operations limit provided is too small");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 6);
      assertEquals(325, testManualSorter.isSortable(-1),
          "Test that ManualSorter.isSortable() returns the correct number of operations required to"
              + " sort an array, excluding unnecessary operations");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing isSortable() on a ManualSorter instance with "
          + "the insertion sort algorithm; " + e.getMessage());
    }
  }

  @Test
  void testIsSortable_MergeSort() {
    String testName = "testIsSortable_MergeSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array = new int[] {12, 23, 15, 22, 17, 6, 19, 8, 1, 3, 16, 24, 10, 7, 5, 25, 18, 13, 14,
          9, 4, 20, 2, 11, 21};
      MergeSort mergeSorter = new MergeSort(array);
      ManualSorter testManualSorter = mergeSorter.preComputeManualSort();
      testManualSorter = mergeSorter.preComputeManualSort();
      assertEquals(418, testManualSorter.isSortable(-1), "Test that ManualSorter.isSortable() can "
          + "verify if an array is sortable using operations generated by a MergeSort object");
      assertEquals(-1, testManualSorter.isSortable(10), "Test that ManualSorter.isSortable() will "
          + "return -1 when the operations limit provided is too small");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 6);
      assertEquals(418, testManualSorter.isSortable(-1),
          "Test that ManualSorter.isSortable() returns the correct number of operations required to"
              + " sort an array, excluding unnecessary operations");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing isSortable() on a ManualSorter instance with "
          + "the merge sort algorithm; " + e.getMessage());
    }
  }

  @Test
  void testGetCurrentIndexA() {
    String testName = "testGetCurrentIndexA";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertEquals(-1, testManualSorter.getCurrentIndexA(),
          "Test that currentIndexA in a ManualSorter instance starts at -1");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 1, 2);
      assertEquals(-1, testManualSorter.getCurrentIndexA(),
          "Test that currentIndexA in a ManualSorter instance is still -1 after enqueueing an "
              + "operation and before execution");
      testManualSorter.step();
      assertEquals(1, testManualSorter.getCurrentIndexA(),
          "Test that currentIndexA in a ManualSorter instance is now 1 after execution");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing testGetCurrentIndexA() on a ManualSorter "
          + "instance; " + e.getMessage());
    }
  }

  @Test
  void testGetCurrentIndexB() {
    String testName = "testGetCurrentIndexB";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertEquals(-1, testManualSorter.getCurrentIndexB(),
          "Test that currentIndexB in a ManualSorter instance starts at -1");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 1, 2);
      assertEquals(-1, testManualSorter.getCurrentIndexB(), "Test that currentIndexB in a "
          + "ManualSorter instance is still -1 after enqueueing an operation and before execution");
      testManualSorter.step();
      assertEquals(2, testManualSorter.getCurrentIndexB(),
          "Test that currentIndexB in a ManualSorter instance is now 2 after execution");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e
          + " thrown while testing testGetCurrentIndexB() on a ManualSorter instance; "
          + e.getMessage());
    }
  }

  @Test
  void testGetCurrentOperationType() {
    String testName = "testGetCurrentOperationType";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertEquals(null, testManualSorter.getCurrentOperationType(),
          "Test that currentOperationType in a ManualSorter instance starts as null");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 1, 2);
      assertEquals(null, testManualSorter.getCurrentOperationType(),
          "Test that currentOperationType in a ManualSorter instance is still null after enqueueing"
              + " an operation and before execution");
      testManualSorter.step();
      assertEquals(SortingAlgorithmOperation.SWAP, testManualSorter.getCurrentOperationType(),
          "Test that currentOperationType in a ManualSorter instance is now SWAP after execution");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing testGetCurrentOperationType() on a "
          + "ManualSorter instance; " + e.getMessage());
    }
  }

  @Test
  void testStepOnEmptyDequeReturnsFalse() {
    String testName = "testStepOnEmptyDequeReturnsFalse";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertFalse(testManualSorter.step(), "Test that stepping on a ManualSorter instance with no "
          + "queued operations returns false");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 1);
      assertTrue(testManualSorter.step(), "Test that stepping on a ManualSorter instance after "
          + "enqueueing an operation returns true");
      assertFalse(testManualSorter.step(), "Test that stepping on a ManualSorter instance with no "
          + "more queued operations returns false");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing testStepOnEmptyDequeReturnsFalse() on a "
          + "ManualSorter instance; " + e.getMessage());
    }
  }

  @Test
  void testMoveLiteralOperation() {
    String testName = "testMoveLiteralOperation";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
      assertTrue(
          Arrays.equals(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, testManualSorter.getArray()),
          "Test that array in ManualSorter is the original array before the move literal "
              + "operation");
      for (int i = 0; i < 10; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, i + 1, i);
      }
      for (int i = 0; i < 10; i++) {
        testManualSorter.step();
      }
      assertTrue(
          Arrays.equals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, testManualSorter.getArray()),
          "Test that array in ManualSorter matches the expected array after the move literal "
              + "operations");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing the move literal operation with an instance "
          + "of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testGetUsingTemporaryArraysStatus() {
    String testName = "testGetUsingTemporaryArraysStatus";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertFalse(testManualSorter.getUsingTemporaryArraysStatus(), "Test that "
          + "getUsingTemporaryArraysStatus() returns false upon the creation of a new ManualSorter "
          + "instance");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getUsingTemporaryArraysStatus() on an instance"
          + " of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testSetUsingTemporaryArraysStatus() {
    String testName = "testSetUsingTemporaryArraysStatus";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertFalse(testManualSorter.getUsingTemporaryArraysStatus(), "Test that "
          + "getUsingTemporaryArraysStatus() returns false upon the creation of a new ManualSorter "
          + "instance");
      testManualSorter.setUsingTemporaryArraysStatus(true);
      assertTrue(testManualSorter.getUsingTemporaryArraysStatus(),
          "Test that getUsingTemporaryArraysStatus() returns true after calling "
              + "setUsingTemporaryArraysStatus(true)");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing setUsingTemporaryArraysStatus() on an instance"
          + " of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testGetPrimarySelectedArray_Key() {
    String testName = "testGetPrimarySelectedArray_Key";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertEquals(-1, testManualSorter.getPrimarySelectedArray_Key(),
          "Test that getPrimarySelectedArray_Key() returns -1 in a newly created "
              + "ManualSorter instance");
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 15, 4);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, 0, 1, 4);
      assertTrue(testManualSorter.step(),
          "Test that testManualSorter steps and creates an array successfully");
      assertTrue(testManualSorter.step(),
          "Test that testManualSorter steps and loads a compare operation successfully");
      assertEquals(4, testManualSorter.getPrimarySelectedArray_Key(),
          "Test that getPrimarySelectedArray_Key() returns 4 after comparing elements in array 4");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getPrimarySelectedArray_Key() on an instance "
          + "of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testGetPrimarySelectedArray_Array() {
    String testName = "testGetPrimarySelectedArray_Array";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertEquals(null, testManualSorter.getPrimarySelectedArray_Array(),
          "Test that getPrimarySelectedArray_Array() returns null in a newly created ManualSorter "
              + "instance");
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 10, 4);
      for (int i = 0; i < 10; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, i + 1, i, 4);
      }
      for (int i = 0; i < 11; i++) {
        assertTrue(testManualSorter.step(), "Test that the step was executed successfully");
      }
      assertTrue(
          Arrays.equals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
              testManualSorter.getPrimarySelectedArray_Array()),
          "Test that getPrimarySelectedArray_Array() returns the correct array after comparing "
              + "elements in array 4");
      assertArrayEquals(new int[] {1, 2, 3}, testManualSorter.getArray(),
          "Test that the original array in testManualSorter remains unmodified");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing testGetPrimarySelectedArray_Array() on an "
          + "instance of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testMultiArrayOperation_Create_Array() {
    String testName = "testMultiArrayOperation_Create_Array";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 10, 0);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 10, 1);
      assertFalse(testManualSorter.step(),
          "Test that a ManualSorter instance will not overwrite the primary array");
      assertTrue(testManualSorter.step(),
          "Test that a ManualSorter will create a new array of size 10 at key 1");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing a CREATE_ARRAY operation on an instance of "
          + "ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testMultiArrayOperation_Move_Literal() {
    String testName = "testMultiArrayOperation_Move_Literal";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3, 4, 5});
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 10, 1);
      for (int i = 0; i < 10; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, (i + 1) * 10, i,
            1);
      }
      for (int i = 0; i < 11; i++) {
        assertTrue(testManualSorter.step(), "Test that the step is executed successfully");
      }
      assertTrue(
          Arrays.equals(new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100},
              testManualSorter.getPrimarySelectedArray_Array()),
          "Test that the temporary array is populated as expected");
      assertArrayEquals(new int[] {1, 2, 3, 4, 5}, testManualSorter.getArray(),
          "Test that the original array has not been modified");
      for (int i = 0; i < 5; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, (i + 1) * 50, i,
            0);
      }
      for (int i = 0; i < 5; i++) {
        assertTrue(testManualSorter.step(), "Test that the step is executed successfully");
      }
      assertArrayEquals(new int[] {50, 100, 150, 200, 250}, testManualSorter.getArray(),
          "Test that the original array is updated as expected");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing a MOVE_LITERAL operation on "
          + "an instance of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testMultiArrayOperation_Compare() {
    String testName = "testMultiArrayOperation_Compare";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3, 4, 5});
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 4, 1);
      for (int i = 0; i < 4; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, (i + 1) * 10, i,
            1);
      }
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, 3, 4, 0);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, 0, 1, 1);
      for (int i = 0; i < 6; i++) {
        // All CREATE_ARRAY and MOVE_LITERAL operations are executed, as well as the
        // first COMPARE operation
        assertTrue(testManualSorter.step(), "Test that the step is executed successfully");
      }
      assertEquals(3, testManualSorter.getCurrentIndexA(), "Test that getCurrentIndexA returns 3");
      assertEquals(4, testManualSorter.getCurrentIndexB(), "Test that getCurrentIndexB returns 4");
      assertEquals(0, testManualSorter.getPrimarySelectedArray_Key(),
          "Test that getCurrentSelectedArray_Key returns 3");
      assertTrue(testManualSorter.step(), "Test that the next step is executed successfully");
      assertEquals(0, testManualSorter.getCurrentIndexA(), "Test that getCurrentIndexA returns 0");
      assertEquals(1, testManualSorter.getCurrentIndexB(), "Test that getCurrentIndexB returns 1");
      assertEquals(1, testManualSorter.getPrimarySelectedArray_Key(),
          "Test that getCurrentSelectedArray_Key returns 1");
      assertFalse(testManualSorter.step(),
          "Test that there are no operations remaining and step() returns false");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing testMultiArrayOperation_COMPARE() on an "
          + "instance of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testMultiArrayOperation_Swap() {
    String testName = "testMultiArrayOperation_Swap";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3, 4, 5});
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 4, 1);
      for (int i = 0; i < 4; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, (i + 1) * 10, i,
            1);
      }
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 3, 4, 0);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 1, 1);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 0, 0, 1);
      for (int i = 0; i < 6; i++) {
        // All CREATE_ARRAY and MOVE_LITERAL operations are executed, as well as the
        // first SWAP operation
        assertTrue(testManualSorter.step(), "Test that the step is executed successfully");
      }
      assertArrayEquals(new int[] {1, 2, 3, 5, 4}, testManualSorter.getArray(),
          "Test that the SWAP operation was executed on the original array "
              + "successfully in multi-array mode");
      assertTrue(
          Arrays.equals(new int[] {1, 2, 3, 5, 4},
              testManualSorter.getPrimarySelectedArray_Array()),
          "Test that the SWAP operation was executed on the original array successfully in "
              + "multi-array mode");
      assertEquals(3, testManualSorter.getCurrentIndexA(), "Test that getCurrentIndexA returns 3");
      assertEquals(4, testManualSorter.getCurrentIndexB(), "Test that getCurrentIndexB returns 4");
      assertEquals(0, testManualSorter.getPrimarySelectedArray_Key(),
          "Test that getPrimarySelectedArray_Key returns 3");
      assertTrue(testManualSorter.step(), "Test that the next step is executed successfully");
      assertArrayEquals(new int[] {1, 2, 3, 5, 4}, testManualSorter.getArray(),
          "Test that the original array has not been touched");
      assertArrayEquals(new int[] {20, 10, 30, 40},
          testManualSorter.getPrimarySelectedArray_Array(), "Test that the SWAP operation was "
              + "executed on the temporary array successfully in multi-array mode");
      assertEquals(0, testManualSorter.getCurrentIndexA(), "Test that getCurrentIndexA returns 0");
      assertEquals(1, testManualSorter.getCurrentIndexB(), "Test that getCurrentIndexB returns 1");
      assertEquals(1, testManualSorter.getPrimarySelectedArray_Key(),
          "Test that getPrimarySelectedArray_Key returns 1");
      assertTrue(testManualSorter.step(), "Test that the next step is executed successfully");
      assertTrue(
          Arrays.equals(new int[] {20, 2, 3, 5, 4},
              testManualSorter.getPrimarySelectedArray_Array()),
          "Test that the SWAP operation between two different arrays correctly modified the "
              + "original array");
      assertArrayEquals(new int[] {1, 10, 30, 40},
          testManualSorter.getSecondarySelectedArray_Array(), "Test that the SWAP operation between"
              + " two different arrays correctly modified the temporary array");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing a SWAP operation on an instance of "
          + "ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testMultiArrayOperation_Delete_Array() {
    String testName = "testMultiArrayOperation_Delete_Array";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3, 4, 5});
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 4, 1);
      for (int i = 0; i < 4; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, (i + 1) * 10, i,
            1);
      }
      for (int i = 0; i < 5; i++) {
        // All CREATE_ARRAY and MOVE_LITERAL operations are executed
        assertTrue(testManualSorter.step(), "Test that the step is executed successfully");
      }
      assertArrayEquals(new int[] {10, 20, 30, 40},
          testManualSorter.getPrimarySelectedArray_Array(), "Test that "
              + "getCurrentSelectedArray_Array() returns the populated array after creating it");
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.DELETE_ARRAY, 1, 0);
      assertTrue(testManualSorter.step(),
          "Test that the DELETE_ARRAY operation is executed successfully");
      assertEquals(null, testManualSorter.getPrimarySelectedArray_Array(),
          "Test that getCurrentSelectedArray_Array() returns null after "
              + "deleting the temporary array");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing a DELETE_ARRAY operation "
          + "on an instance of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testGetSecondarySelectedArray_Key() {
    String testName = "testGetSecondarySelectedArray_Key";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertEquals(-1, testManualSorter.getSecondarySelectedArray_Key(),
          "Test that getSecondarySelectedArray_Key() returns -1 in a newly "
              + "created ManualSorter instance");
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 15, 4);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 15, 6);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, 0, 1, 4, 6);
      assertTrue(testManualSorter.step(),
          "Test that testManualSorter steps and creates an array successfully");
      assertTrue(testManualSorter.step(),
          "Test that testManualSorter steps and creates an array successfully");
      assertTrue(testManualSorter.step(),
          "Test that testManualSorter steps and loads a compare operation successfully");
      assertEquals(6, testManualSorter.getSecondarySelectedArray_Key(), "Test that "
          + "getSecondarySelectedArray_Key() returns 6 after comparing elements in array 4");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getSecondarySelectedArray_Key() on an instance"
          + " of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testGetSecondarySelectedArray_Array() {
    String testName = "testGetSecondarySelectedArray_Array";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(new int[] {1, 2, 3});
      assertEquals(null, testManualSorter.getSecondarySelectedArray_Array(),
          "Test that getSecondarySelectedArray_Array() returns null in a newly created ManualSorter"
              + " instance");
      testManualSorter.setUsingTemporaryArraysStatus(true);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 10, 4);
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.CREATE_ARRAY, 10, 7);
      for (int i = 0; i < 10; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, i + 1, i, 4);
      }
      for (int i = 0; i < 10; i++) {
        testManualSorter.enqueueOperation(SortingAlgorithmOperation.MOVE_LITERAL, (i + 1) * 10, i,
            7);
      }
      testManualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, 0, 0, 4, 7);
      for (int i = 0; i < 23; i++) {
        assertTrue(testManualSorter.step(), "Test that the step was executed successfully");
      }
      assertTrue(
          Arrays.equals(new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100},
              testManualSorter.getSecondarySelectedArray_Array()),
          "Test that getSecondarySelectedArray_Array() returns the correct array after comparing "
              + "elements in array 4 and 7");
      assertArrayEquals(new int[] {1, 2, 3}, testManualSorter.getArray(),
          "Test that the original array in testManualSorter remains unmodified");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getSecondarySelectedArray_Array() on an "
          + "instance of ManualSorter; " + e.getMessage());
    }
  }

  @Test
  void testInitialiseWithNull() {
    String testName = "testInitialiseWithNull";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      ManualSorter testManualSorter = new ManualSorter(null);
      assertArrayEquals(new int[] {}, testManualSorter.getArray(),
          "Test that the array initialised in testManualSorter is an empty array and not null");
      testManualSorter = new ManualSorter(null, null, null);
      assertArrayEquals(new int[] {}, testManualSorter.getArray(),
          "Test that the array initialised in testManualSorter is an empty array and not null");
      testManualSorter = new ManualSorter(null, null, null, null);
      assertArrayEquals(new int[] {}, testManualSorter.getArray(),
          "Test that the array initialised in testManualSorter is an empty array and not null");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing initialising ManualSorter objects with a null "
          + "array; " + e.getMessage());
    }
  }
}
