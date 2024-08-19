import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.InsertionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TestInsertionSort {

  final String className = "TestInsertionSort";

  @Test
  void testCreateInsertionSortInstance() {
    String testName = "testCreateInsertionSortInstance";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      InsertionSort testInsertionSort = new InsertionSort(new int[] {1, 2, 3});
      assertTrue(testInsertionSort instanceof InsertionSort,
          "Test that a new instance of InsertionSort is created successfully");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of InsertionSort; "
          + e.getMessage());
    }
  }

  @Test
  void testGetMainArray() {
    String testName = "testGetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      InsertionSort testInsertionSort = new InsertionSort(new int[] {5, 10, 15});
      int[] expectedArray = {5, 10, 15};
      assertArrayEquals(expectedArray, testInsertionSort.getMainArray(),
          "Test that getMainArray() returns the correct array");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getting the main array from an instance of "
          + "InsertionSort; " + e.getMessage());
    }
  }

  @Test
  void testSetMainArray() {
    String testName = "testSetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array1 = {1, 2, 3, 4, 5};
      int[] array2 = {5, 10, 15, 20, 25};
      InsertionSort testInsertionSort = new InsertionSort(array1);
      assertFalse(Arrays.equals(array2, testInsertionSort.getMainArray()), "Test that the array "
          + "in testInsertionSort is different to array2 before using setMainArray()");
      testInsertionSort.setMainArray(array2);
      assertArrayEquals(array2, testInsertionSort.getMainArray(),
          "Test that the new array is returned correctly after using setMainArray()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing setting the main array of an instance of "
          + "InsertionSort; " + e.getMessage());
    }
  }

  @Test
  void testInsertionSort() {
    String testName = "testInsertionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {8, 6, 3, 7, 2, 5, 4, 1};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
      InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testInsertionSort.getMainArray()), "Test that the "
          + "basic array inside testInsertionSort is unsorted before calling sort()");
      assertFalse(testInsertionSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testInsertionSort.sort();
      assertArrayEquals(sortedArray, testInsertionSort.getMainArray(),
          "Test that the basic array inside testInsertionSort is sorted after calling sort()");
      assertTrue(testInsertionSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing insertion sort with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void testInsertionSortWithMetrics() {
    String testName = "testInsertionSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {2, 10, 3, 4, 8, 9, 7, 1, 6, 5};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testInsertionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testInsertionSort.getMainArray()), "Test that the "
          + "basic array inside testInsertionSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testInsertionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testInsertionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside "
          + "testInsertionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testInsertionSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testInsertionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testInsertionSort.getMainArray(), "Test that the basic array "
          + "inside testInsertionSort is sorted after calling sortWithMetrics()");
      assertEquals(74, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testInsertionSort is 74 after calling sortWithMetrics()");
      assertEquals(23, testMetrics.getSwaps(), "Test that the swaps field inside testInsertionSort "
          + "is 23 after calling sortWithMetrics()");
      assertEquals(9, testMetrics.getPasses(), "Test that the passes field inside "
          + "testInsertionSort is 9 after calling sortWithMetrics()");
      assertEquals(96, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testInsertionSort is 96 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing insertion sort with metrics with a basic "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void testInsertionSortWithManualSorter() {
    String testName = "testInsertionSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {7, 5, 3, 6, 10, 1, 4, 9, 2, 8};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
      ManualSorter testManualMode = testInsertionSort.preComputeManualSort();
      while (true) {
        testManualMode.step();
        if (Arrays.equals(testManualMode.getArray(), sortedArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing insertion sort with a manual sorter with a "
          + "basic array; " + e.getMessage());
    }
  }

  @Test
  void stressTestInsertionSort() {
    String testName = "stressTestInsertionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testInsertionSort.getMainArray()), "Test that the "
          + "random array inside testInsertionSort is unsorted before calling sort()");
      assertFalse(testInsertionSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testInsertionSort.sort();
      assertArrayEquals(sortedArray, testInsertionSort.getMainArray(), "Test that the random "
          + "array inside testInsertionSort is sorted after calling sort()");
      assertTrue(testInsertionSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing insertion sort; " + e.getMessage());
    }
  }

  @Test
  void stressTestInsertionSortWithMetrics() {
    String testName = "stressTestInsertionSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testInsertionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testInsertionSort.getMainArray()), "Test that the "
          + "basic array inside testInsertionSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testInsertionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testInsertionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside testInsertionSort"
          + " is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testInsertionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testInsertionSort.getMainArray(), "Test that the basic array "
          + "inside testInsertionSort is sorted after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testInsertionSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside "
          + "testInsertionSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getPasses(), "Test that the passes field inside "
          + "testInsertionSort is no longer zero after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing insertion sort with metrics; "
          + e.getMessage());
    }
  }

  @Test
  void stressTestInsertionSortWithManualSorter() {
    String testName = "stressTestInsertionSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 2500;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Pre-computing all the operations into a ManualSort object...");
      ManualSorter testManualMode = testInsertionSort.preComputeManualSort();

      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stepping through all queued operations until the array is sorted...");
      while (true) {
        testManualMode.step();
        if (Arrays.equals(testManualMode.getArray(), sortedArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing insertion sort; " + e.getMessage());
    }
  }
}
