import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.MergeSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


class TestMergeSort {

  final String className = "TestMergeSort";

  @Test
  void testCreateMergeSortObject() {
    String testName = "testCreateMergeSortObject";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      MergeSort testMergeSort = new MergeSort(new int[] {1, 2, 3});
      assertTrue(testMergeSort instanceof MergeSort,
          "Test that a new instance of MergeSort is created successfully");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of MergeSort; "
          + e.getMessage());
    }
  }

  @Test
  void testGetInputArray() {
    String testName = "testGetInputArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      MergeSort testMergeSort = new MergeSort(new int[] {5, 10, 15});
      int[] expectedArray = {5, 10, 15};
      assertArrayEquals(expectedArray, testMergeSort.getInputArray(),
          "Test that getInputArray() returns the correct array");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getting the input array from an instance of "
          + "MergeSort; " + e.getMessage());
    }
  }

  @Test
  void testSetInputArray() {
    String testName = "testSetInputArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array1 = {1, 2, 3, 4, 5};
      int[] array2 = {5, 10, 15, 20, 25};
      MergeSort testMergeSort = new MergeSort(array1);
      assertFalse(Arrays.equals(array2, testMergeSort.getInputArray()),
          "Test that the array in testMergeSort is different to array2 "
              + "before using setInputArray()");
      testMergeSort.setInputArray(array2);
      assertArrayEquals(array2, testMergeSort.getInputArray(),
          "Test that the new array is returned correctly after using setInputArray()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing setting the input array of an instance of "
          + "MergeSort; " + e.getMessage());
    }
  }

  @Test
  void testMergeSort() {
    String testName = "testMergeSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {8, 6, 3, 7, 2, 5, 4, 1};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getInputArray()),
          "Test that the basic array inside testMergeSort is unsorted before calling sort()");
      assertFalse(testMergeSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testMergeSort.sort();
      assertArrayEquals(sortedArray, testMergeSort.getInputArray(),
          "Test that the basic array inside testMergeSort is sorted after calling sort()");
      assertTrue(testMergeSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithMetrics() {
    String testName = "testMergeSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {2, 10, 3, 4, 8, 9, 7, 1, 6, 5};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getInputArray()), "Test that the basic "
          + "array inside testMergeSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testMergeSort.getInputArray(), "Test that the basic array "
          + "inside testMergeSort is sorted after calling sortWithMetrics()");
      assertEquals(187, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is 187 after calling sortWithMetrics()");
      // Swaps not implemented
      assertEquals(68, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "68 after calling sortWithMetrics()");
      // Passes not implemented
      // assertEquals(9, testMetrics.getPasses(), "Test that the passes field inside testMergeSort
      // is 9 after calling sortWithMetrics()");
      assertEquals(182, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is 182 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with metrics with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithManualSorter() {
    String testName = "testMergeSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {7, 5, 3, 6, 10, 1, 4, 9, 2, 8};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      ManualSorter testManualSorter = testMergeSort.preComputeManualSort();
      while (true) {
        testManualSorter.step();
        if (Arrays.equals(testManualSorter.getArray(), sortedArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with a manual sorter with a basic "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void stressTestMergeSort() {
    String testName = "stressTestMergeSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      MergeSort testMergeSort = new MergeSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getInputArray()),
          "Test that the random array inside testMergeSort is unsorted before calling sort()");
      assertFalse(testMergeSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testMergeSort.sort();
      assertArrayEquals(sortedArray, testMergeSort.getInputArray(),
          "Test that the random array inside testMergeSort is sorted after calling sort()");
      assertTrue(testMergeSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing merge sort; " + e.getMessage());
    }
  }

  @Test
  void stressTestMergeSortWithMetrics() {
    String testName = "stressTestMergeSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      MergeSort testMergeSort = new MergeSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getInputArray()), "Test that the basic "
          + "array inside testMergeSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testMergeSort.getInputArray(), "Test that the basic array "
          + "inside testMergeSort is sorted after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is"
          + " no longer zero after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing merge sort with metrics; "
          + e.getMessage());
    }
  }

  @Test
  void stressTestMergeSortWithManualSorter() {
    String testName = "stressTestMergeSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      MergeSort testMergeSort = new MergeSort(unsortedArray);
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Pre-computing all the operations into a ManualSort object...");
      ManualSorter testManualSorter = testMergeSort.preComputeManualSort();

      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stepping through all queued operations until the array is sorted...");
      while (true) {
        testManualSorter.step();
        if (Arrays.equals(testManualSorter.getArray(), sortedArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing merge sort; " + e.getMessage());
    }
  }
}
