import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.BubbleSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


class TestBubbleSort {

  final String className = "TestBubbleSort";

  @Test
  void testCreateBubbleSortObject() {
    String testName = "testCreateBubbleSortObject";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      BubbleSort testBubbleSort = new BubbleSort(new int[] {1, 2, 3});
      assertTrue(testBubbleSort instanceof BubbleSort,
          "Test that a new instance of BubbleSort is created successfully");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of BubbleSort; "
          + e.getMessage());
    }
  }

  @Test
  void testGetMainArray() {
    String testName = "testGetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      BubbleSort testBubbleSort = new BubbleSort(new int[] {5, 10, 15});
      int[] expectedArray = {5, 10, 15};
      assertArrayEquals(expectedArray, testBubbleSort.getMainArray(),
          "Test that getMainArray() " + "returns the correct array");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getting the main array from an instance of "
          + "BubbleSort; " + e.getMessage());
    }
  }

  @Test
  void testSetMainArray() {
    String testName = "testSetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array1 = {1, 2, 3, 4, 5};
      int[] array2 = {5, 10, 15, 20, 25};
      BubbleSort testBubbleSort = new BubbleSort(array1);
      assertFalse(Arrays.equals(array2, testBubbleSort.getMainArray()), "Test that the array in "
          + "testBubbleSort is different to array2 before using setMainArray()");
      testBubbleSort.setMainArray(array2);
      assertArrayEquals(array2, testBubbleSort.getMainArray(),
          "Test that the new array is returned correctly after using setMainArray()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing setting the main array of an instance of "
          + "BubbleSort; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSort() {
    String testName = "testBubbleSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {8, 6, 3, 7, 2, 5, 4, 1};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testBubbleSort.getMainArray()),
          "Test that the basic array inside testBubbleSort is unsorted before calling sort()");
      assertFalse(testBubbleSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testBubbleSort.sort();
      assertArrayEquals(sortedArray, testBubbleSort.getMainArray(),
          "Test that the basic array inside testBubbleSort is sorted after calling sort()");
      assertTrue(testBubbleSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithMetrics() {
    String testName = "testBubbleSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {7, 5, 3, 6, 10, 1, 4, 9, 2, 8};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testBubbleSort.getMainArray()), "Test that the basic "
          + "array inside testBubbleSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testBubbleSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testBubbleSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testBubbleSort.getMainArray(), "Test that the basic array "
          + "inside testBubbleSort is sorted after calling sortWithMetrics()");
      assertEquals(96, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is 44 after calling sortWithMetrics()");
      assertEquals(23, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is "
          + "23 after calling sortWithMetrics()");
      assertEquals(8, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is 8 after calling sortWithMetrics()");
      assertEquals(180, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testBubbleSort is 180 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort with metrics with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithManualSorter() {
    String testName = "testBubbleSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {7, 5, 3, 6, 10, 1, 4, 9, 2, 8};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      ManualSorter testManualMode = testBubbleSort.preComputeManualSort();
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
      fail("Exception " + e
          + " thrown while testing bubble sort with a manual sorter with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void stressTestBubbleSort() {
    String testName = "stressTestBubbleSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testBubbleSort.getMainArray()), "Test that the "
          + "random array inside testBubbleSort is unsorted before calling sort()");
      assertFalse(testBubbleSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testBubbleSort.sort();
      assertArrayEquals(sortedArray, testBubbleSort.getMainArray(),
          "Test that the random array inside testBubbleSort is sorted after calling sort()");
      assertTrue(testBubbleSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing bubble sort; " + e.getMessage());
    }
  }

  @Test
  void stressTestBubbleSortWithMetrics() {
    String testName = "stressTestBubbleSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testBubbleSort.getMainArray()), "Test that the basic "
          + "array inside testBubbleSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testBubbleSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testBubbleSort.getMainArray(), "Test that the basic array "
          + "inside testBubbleSort is sorted after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort "
          + "is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getPasses(), "Test that the passes field inside "
          + "testBubbleSort is no longer zero after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing bubble sort with metrics; "
          + e.getMessage());
    }
  }

  @Test
  void stressTestBubbleSortWithManualSorter() {
    String testName = "stressTestBubbleSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 2500;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Pre-computing all the operations into a ManualSort object...");
      ManualSorter testManualMode = testBubbleSort.preComputeManualSort();

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
      fail("Exception " + e + " thrown while stress testing bubble sort; " + e.getMessage());
    }
  }
}
