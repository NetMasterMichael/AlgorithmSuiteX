import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SelectionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TestSelectionSort {

  final String className = "TestSelectionSort";

  @Test
  void testCreateSelectionSortInstance() {
    String testName = "testCreateSelectionSortInstance";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SelectionSort testSelectionSort = new SelectionSort(new int[] {1, 2, 3});
      assertTrue(testSelectionSort instanceof SelectionSort,
          "Test that a new instance of SelectionSort is created successfully");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of SelectionSort; "
          + e.getMessage());
    }
  }

  @Test
  void testGetInputArray() {
    String testName = "testGetInputArray";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      SelectionSort testSelectionSort = new SelectionSort(new int[] {5, 10, 15});
      int[] expectedArray = {5, 10, 15};
      assertArrayEquals(expectedArray, testSelectionSort.getInputArray(),
          "Test that getInputArray() returns the correct array");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing getting the input array from an instance of "
          + "SelectionSort; " + e.getMessage());
    }
  }

  @Test
  void testSetInputArray() {
    String testName = "testSetInputArray";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      int[] array1 = {1, 2, 3, 4, 5};
      int[] array2 = {5, 10, 15, 20, 25};
      SelectionSort testSelectionSort = new SelectionSort(array1);
      assertFalse(Arrays.equals(array2, testSelectionSort.getInputArray()), "Test that the array "
          + "in testSelectionSort is different to array2 before using setInputArray()");
      testSelectionSort.setInputArray(array2);
      assertArrayEquals(array2, testSelectionSort.getInputArray(),
          "Test that the new array is returned correctly after using setInputArray()");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing setting the input array of an instance of "
          + "SelectionSort; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSort() {
    String testName = "testSelectionSort";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      int[] unsortedArray = {5, 1, 7, 3, 4, 8, 2, 6};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getInputArray()), "Test that the "
          + "basic array inside testSelectionSort is unsorted before calling sort()");
      assertFalse(testSelectionSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testSelectionSort.sort();
      assertArrayEquals(sortedArray, testSelectionSort.getInputArray(),
          "Test that the basic array inside testSelectionSort is sorted after calling sort()");
      assertTrue(testSelectionSort.isSorted(),
          "Test that isSorted() returns true after calling " + "sort()");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithMetrics() {
    String testName = "testSelectionSortWithMetrics";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      int[] unsortedArray = {3, 9, 1, 7, 8, 2, 5, 4, 10, 6};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getInputArray()), "Test that the "
          + "basic array inside testSelectionSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testSelectionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testSelectionSort.getInputArray(), "Test that the "
          + "basic array inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertEquals(118, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is 118 after calling sortWithMetrics()");
      assertEquals(7, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is 7 after calling sortWithMetrics()");
      assertEquals(9, testMetrics.getPasses(), "Test that the passes field inside "
          + "testSelectionSort is 9 after calling sortWithMetrics()");
      assertEquals(118, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is 118 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with metrics with a basic "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithManualSorter() {
    String testName = "testSelectionSortWithManualSorter";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      int[] unsortedArray = {7, 5, 3, 6, 10, 1, 4, 9, 2, 8};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      ManualSorter testManualMode = testSelectionSort.preComputeManualSort();
      while (true) {
        testManualMode.step();
        if (Arrays.equals(testManualMode.getArray(), sortedArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with a manual sorter with a "
          + "basic array; " + e.getMessage());
    }
  }

  @Test
  void stressTestSelectionSort() {
    String testName = "stressTestSelectionSort";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getInputArray()), "Test that the "
          + "random array inside testSelectionSort is unsorted before calling sort()");
      assertFalse(testSelectionSort.isSorted(),
          "Test that isSorted() returns false before calling " + "sort()");
      testSelectionSort.sort();
      assertArrayEquals(sortedArray, testSelectionSort.getInputArray(), "Test that the random array"
          + " inside testSelectionSort is sorted after calling sort()");
      assertTrue(testSelectionSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while stress testing selection sort; " + e.getMessage());
    }
  }

  @Test
  void stressTestSelectionSortWithMetrics() {
    String testName = "stressTestSelectionSortWithMetrics";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getInputArray()), "Test that the "
          + "basic array inside testSelectionSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testSelectionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testSelectionSort.getInputArray(), "Test that the basic array "
          + "inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside "
          + "testSelectionSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getPasses(), "Test that the passes field inside "
          + "testSelectionSort is no longer zero after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while stress testing selection sort with metrics; "
          + e.getMessage());
    }
  }

  @Test
  void stressTestSelectionSortWithManualSorter() {
    String testName = "stressTestSelectionSortWithManualSorter";
    AuxiliaryTestMethods.logMessage(className, testName + " started");
    try {
      int arraySize = 2500;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Pre-computing all the operations into a ManualSort object...");
      ManualSorter testManualMode = testSelectionSort.preComputeManualSort();

      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stepping through all queued operations until the array is sorted...");
      while (true) {
        testManualMode.step();
        if (Arrays.equals(testManualMode.getArray(), sortedArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPass(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logFail(className, testName);
      fail("Exception " + e + " thrown while stress testing selection sort with a manual sorter; "
          + e.getMessage());
    }
  }
}
