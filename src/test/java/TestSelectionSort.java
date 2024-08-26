import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SelectionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmType;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TestSelectionSort {

  final String className = "TestSelectionSort";

  // The numbering of tests is not indicative of their order of execution. These comments are purely
  // for improving readability and navigability of this source file.
  
  @Test
  void testCreateSelectionSortInstance() { // Test 01
    String testName = "testCreateSelectionSortInstance";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SelectionSort testSelectionSort = new SelectionSort(new int[] {1, 2, 3});
      assertTrue(testSelectionSort instanceof SelectionSort,
          "Test that a new instance of SelectionSort is created successfully");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of SelectionSort; "
          + e.getMessage());
    }
  }

  @Test
  void testGetMainArray() { // Test 02
    String testName = "testGetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SelectionSort testSelectionSort = new SelectionSort(new int[] {5, 10, 15});
      int[] expectedArray = {5, 10, 15};
      assertArrayEquals(expectedArray, testSelectionSort.getMainArray(),
          "Test that getMainArray() returns the correct array");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getting the main array from an instance of "
          + "SelectionSort; " + e.getMessage());
    }
  }

  @Test
  void testSetMainArray() { // Test 03
    String testName = "testSetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array1 = {1, 2, 3, 4, 5};
      int[] array2 = {5, 10, 15, 20, 25};
      SelectionSort testSelectionSort = new SelectionSort(array1);
      assertFalse(Arrays.equals(array2, testSelectionSort.getMainArray()), "Test that the array "
          + "in testSelectionSort is different to array2 before using setMainArray()");
      testSelectionSort.setMainArray(array2);
      assertArrayEquals(array2, testSelectionSort.getMainArray(),
          "Test that the new array is returned correctly after using setMainArray()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing setting the main array of an instance of "
          + "SelectionSort; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSort() { // Test 04
    String testName = "testSelectionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {5, 1, 7, 3, 4, 8, 2, 6};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getMainArray()), "Test that the "
          + "basic array inside testSelectionSort is unsorted before calling sort()");
      assertFalse(testSelectionSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testSelectionSort.sort();
      assertArrayEquals(sortedArray, testSelectionSort.getMainArray(),
          "Test that the basic array inside testSelectionSort is sorted after calling sort()");
      assertTrue(testSelectionSort.isSorted(),
          "Test that isSorted() returns true after calling " + "sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with a basic array; "
          + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithMetrics() { // Test 05
    String testName = "testSelectionSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {3, 9, 1, 7, 8, 2, 5, 4, 10, 6};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getMainArray()), "Test that the "
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
      assertArrayEquals(sortedArray, testSelectionSort.getMainArray(), "Test that the "
          + "basic array inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertEquals(118, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is 118 after calling sortWithMetrics()");
      assertEquals(7, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is 7 after calling sortWithMetrics()");
      assertEquals(9, testMetrics.getPasses(), "Test that the passes field inside "
          + "testSelectionSort is 9 after calling sortWithMetrics()");
      assertEquals(118, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is 118 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with metrics with a basic "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithManualSorter() { // Test 06
    String testName = "testSelectionSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
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
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with a manual sorter with a "
          + "basic array; " + e.getMessage());
    }
  }

  @Test
  void stressTestSelectionSort() { // Test 07
    String testName = "stressTestSelectionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getMainArray()), "Test that the "
          + "random array inside testSelectionSort is unsorted before calling sort()");
      assertFalse(testSelectionSort.isSorted(),
          "Test that isSorted() returns false before calling " + "sort()");
      testSelectionSort.sort();
      assertArrayEquals(sortedArray, testSelectionSort.getMainArray(), "Test that the random array"
          + " inside testSelectionSort is sorted after calling sort()");
      assertTrue(testSelectionSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing selection sort; " + e.getMessage());
    }
  }

  @Test
  void stressTestSelectionSortWithMetrics() { // Test 08
    String testName = "stressTestSelectionSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getMainArray()), "Test that the "
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
      assertArrayEquals(sortedArray, testSelectionSort.getMainArray(), "Test that the basic array "
          + "inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside "
          + "testSelectionSort is no longer zero after calling sortWithMetrics()");
      assertNotEquals(0, testMetrics.getPasses(), "Test that the passes field inside "
          + "testSelectionSort is no longer zero after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing selection sort with metrics; "
          + e.getMessage());
    }
  }

  @Test
  void stressTestSelectionSortWithManualSorter() { // Test 09
    String testName = "stressTestSelectionSortWithManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
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
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while stress testing selection sort with a manual sorter; "
          + e.getMessage());
    }
  }
  
  // IMPORTANT NOTE
  // In theory, this algorithm can and will handle arrays with different variations of numbers.
  // However, these edge cases should still be tested individually, especially considering each
  // method contains a separate copy of the sorting algorithm. This will help with catching any
  // logic errors and ensure the robustness of the implementation of the algorithm.

  @Test
  void testSelectionSortWithNegativeNumbers() { // Test 10
    String testName = "testSelectionSortWithNegativeNumbers";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {-31, -14, 30, -4, 0, 81, -56, -75, 27, 14, 85, -63, 70, -11, 14,
          80, -10, -82, -75, 50};
      int[] sortedTestArray = new int[] {-82, -75, -75, -63, -56, -31, -14, -11, -10, -4, 0, 14, 14,
          27, 30, 50, 70, 80, 81, 85};

      SelectionSort testSelectionSort = new SelectionSort(testArray);
      assertFalse(Arrays.equals(sortedTestArray, testSelectionSort.getMainArray()),
          "Test that the array with negative numbers inside testSelectionSort starts as unsorted");
      assertFalse(testSelectionSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testSelectionSort.sort();
      assertArrayEquals(sortedTestArray, testSelectionSort.getMainArray(),
          "Test that testSelectionSort successfully sorts an array containing negative numbers");
      assertTrue(testSelectionSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort on an array containing "
          + "negative numbers; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithNegativeNumbersAndMetrics() { // Test 11
    String testName = "testSelectionSortWithNegativeNumbersAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-2, -17, -38, 88, -86, -82, -14, 88, -17, -55, 63, 42, 32,
          98, -38, 32, -96, 34, 85, 62};
      int[] sortedArray = new int[] {-96, -86, -82, -55, -38, -38, -17, -17, -14, -2, 32, 32, 34,
          42, 62, 63, 85, 88, 88, 98};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getMainArray()), 
          "Test that the array with negative numbers in testSelectionSort is unsorted before "
          + "calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testSelectionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testSelectionSort.getMainArray(), "Test that the basic array "
          + "inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertEquals(438, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is 438 after calling sortWithMetrics()");
      assertEquals(18, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is 18 after calling sortWithMetrics()");
      assertEquals(452, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is 452 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with metrics on an array "
          + "containing negative numbers; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithNegativeNumbersAndManualSorter() { // Test 12
    String testName = "testSelectionSortWithNegativeNumbersAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-95, 4, -42, 21, -97, -50, 50, -18, -59, 82, -91, -11, 22,
          -24, 77, -63, 92, -59, 53, 85};
      int[] sortedArray = new int[] {-97, -95, -91, -63, -59, -59, -50, -42, -24, -18, -11, 4, 21,
          22, 50, 53, 77, 82, 85, 92};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      ManualSorter testManualMode = testSelectionSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing selection sort with a manual sorter on an "
          + "array containing negative numbers; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithDuplicateNumbers() { // Test 13
    String testName = "testSelectionSortWithDuplicateNumbers";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {95, -66, 26, 94, 67, 11, 68, 90, 14, 90, 26, 32, 9, 89, 95, 67,
          -8, -32, -10, -46, 46, 89, 67, 49, -58, -52, -46, -61, -79, 99, -50, -40, 94, -76, -33,
          -58, -19, 92, 6, -43, -94, 17, 15, -33, -38, 99, 11, 46, 17, 15};
      int[] sortedTestArray = new int[] {-94, -79, -76, -66, -61, -58, -58, -52, -50, -46, -46, -43,
          -40, -38, -33, -33, -32, -19, -10, -8, 6, 9, 11, 11, 14, 15, 15, 17, 17, 26, 26, 32, 46,
          46, 49, 67, 67, 67, 68, 89, 89, 90, 90, 92, 94, 94, 95, 95, 99, 99};

      SelectionSort testSelectionSort = new SelectionSort(testArray);
      assertFalse(Arrays.equals(sortedTestArray, testSelectionSort.getMainArray()),
          "Test that the array with duplicate numbers inside testSelectionSort starts as unsorted");
      assertFalse(testSelectionSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testSelectionSort.sort();
      assertArrayEquals(sortedTestArray, testSelectionSort.getMainArray(),
          "Test that testSelectionSort successfully sorts an array containing duplicate numbers");
      assertTrue(testSelectionSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort on an array containing "
          + "duplicate numbers; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithDuplicateNumbersAndMetrics() { // Test 14
    String testName = "testSelectionSortWithDuplicateNumbersAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-3, 79, 55, -68, 42, 12, 42, -54, -14, 98, 13, -77, 2, -17,
          10, -78, -95, 55, 10, -59, -70, -68, -95, 92, 34, 12, 7, 8, -50, -14, -17, 7, -97, 0, -3,
          -85, 60, -3, -22, -10, -84, 39, 13, -59, -68, 11, -3, 39, -95, 90};
      int[] sortedArray = new int[] {-97, -95, -95, -95, -85, -84, -78, -77, -70, -68, -68, -68,
          -59, -59, -54, -50, -22, -17, -17, -14, -14, -10, -3, -3, -3, -3, 0, 2, 7, 7, 8, 10, 10,
          11, 12, 12, 13, 13, 34, 39, 39, 42, 42, 55, 55, 60, 79, 90, 92, 98};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testSelectionSort.getMainArray()), "Test that the "
          + "array with duplicate numbers in testSelectionSort is unsorted before using "
          + "sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside testSelectionSort"
          + " is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testSelectionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testSelectionSort.getMainArray(),
          "Test that the array with duplicate numbers "
              + "inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertEquals(2598, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is 2598 after calling sortWithMetrics()");
      assertEquals(49, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is 49 after calling sortWithMetrics()");
      assertEquals(2646, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is 2646 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with metrics on an array "
          + "containing duplicate numbers; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithDuplicateNumbersAndManualSorter() { // Test 15
    String testName = "testSelectionSortWithDuplicateNumbersAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-82, -25, -63, 84, -64, -55, -48, 7, 8, -46, -80, -25, 49,
          -80, 79, -60, 84, -29, 98, -14, -29, -81, -82, -55, -81, 38, 44, -70, 3, -60, -14, -48,
          -2, -27, 76, 38, -94, 38, 71, -21, -29, 49, 4, -61, -15, -88, -95, 34, -61, -63};
      int[] sortedArray = new int[] {-95, -94, -88, -82, -82, -81, -81, -80, -80, -70, -64, -63,
          -63, -61, -61, -60, -60, -55, -55, -48, -48, -46, -29, -29, -29, -27, -25, -25, -21, -15,
          -14, -14, -2, 3, 4, 7, 8, 34, 38, 38, 38, 44, 49, 49, 71, 76, 79, 84, 84, 98};
      SelectionSort testSelectionSort = new SelectionSort(unsortedArray);
      ManualSorter testManualMode = testSelectionSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing selection sort with a manual sorter on an "
          + "array containing duplicate numbers; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithOneElement() { // Test 16
    String testName = "testSelectionSortWithOneElement";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      SelectionSort testSelectionSort = new SelectionSort(testArray);
      testSelectionSort.sort();
      assertArrayEquals(testArray, testSelectionSort.getMainArray(), 
          "Test that testSelectionSort.sort() with one element didn't exert any exceptions or "
          + "unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort on an array containing one "
          + "single element; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithOneElementAndMetrics() { // Test 17
    String testName = "testSelectionSortWithOneElementAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      SelectionSort testSelectionSort = new SelectionSort(testArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testSelectionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(testArray, testSelectionSort.getMainArray(),
          "Test that the array with one element "
              + "inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is 2484 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is 665 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is 5098 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with metrics on an array "
          + "containing one element; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithOneElementAndManualSorter() { // Test 18
    String testName = "testSelectionSortWithOneElementAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      SelectionSort testSelectionSort = new SelectionSort(testArray);
      ManualSorter testManualMode = testSelectionSort.preComputeManualSort();
      while (true) {
        testManualMode.step();
        if (Arrays.equals(testManualMode.getArray(), testArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with a manual sorter on an "
          + "array containing one element; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithEmptyArray() { // Test 19
    String testName = "testSelectionSortWithEmptyArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      SelectionSort testSelectionSort = new SelectionSort(testArray);
      testSelectionSort.sort();
      assertArrayEquals(testArray, testSelectionSort.getMainArray(), 
          "Test that testSelectionSort.sort() with one element didn't exert any exceptions or "
              + "unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort on an empty array; "
          + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithEmptyArrayAndMetrics() { // Test 20
    String testName = "testSelectionSortWithEmptyArrayAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      SelectionSort testSelectionSort = new SelectionSort(testArray);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testSelectionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(testArray, testSelectionSort.getMainArray(),
          "Test that the array with duplicate numbers "
              + "inside testSelectionSort is sorted after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is 0 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is 0 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with metrics on an empty "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithEmptyArrayAndManualSorter() { // Test 21
    String testName = "testSelectionSortWithEmptyArrayAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      SelectionSort testSelectionSort = new SelectionSort(testArray);
      ManualSorter testManualMode = testSelectionSort.preComputeManualSort();
      while (true) {
        testManualMode.step();
        if (Arrays.equals(testManualMode.getArray(), testArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with a manual sorter on an "
          + "empty array; " + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithNullArray() { // Test 22
    String testName = "testSelectionSortWithNullArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      SelectionSort testSelectionSort = new SelectionSort(null);
      testSelectionSort.sort();
      assertArrayEquals(expectedArray, testSelectionSort.getMainArray(),
          "Test that testSelectionSort.sort() "
              + "with one element didn't exert any exceptions or unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort on a null array; "
          + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithNullArrayAndMetrics() { // Test 23
    String testName = "testSelectionSortWithNullArrayAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      SelectionSort testSelectionSort = new SelectionSort(null);
      SortingAlgorithmMetrics testMetrics = testSelectionSort.getMetrics();
      // Pre-checks
      assertArrayEquals(expectedArray, testSelectionSort.getMainArray(),
          "Test that mainArray initialised with an empty array instead of null");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testSelectionSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(expectedArray, testSelectionSort.getMainArray(),
          "Test that mainArray is still an empty array, instead of null");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testSelectionSort is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testSelectionSort "
          + "is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testSelectionSort is 1 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with metrics on a null array; "
          + e.getMessage());
    }
  }

  @Test
  void testSelectionSortWithNullArrayAndManualSorter() { // Test 24
    String testName = "testSelectionSortWithNullArrayAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      SelectionSort testSelectionSort = new SelectionSort(null);
      ManualSorter testManualMode = testSelectionSort.preComputeManualSort();
      while (true) {
        testManualMode.step();
        if (Arrays.equals(testManualMode.getArray(), expectedArray)) {
          assertTrue(true);
          break;
        }
      }
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing selection sort with a manual sorter on a null "
          + "array; " + e.getMessage());
    }
  }
  
  @Test
  void testGetAlgorithmType() { // Test 25
    String testName = "testGetAlgorithmType";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SelectionSort testSelectionSort = new SelectionSort(null);
      assertEquals(SortingAlgorithmType.SELECTION_SORT, testSelectionSort.getAlgorithmType(),
          "Test that getAlgorithmType() on a SelectionSort instance returns "
              + "SortingAlgorithmType.SELECTION_SORT");
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getAlgorithmType() on an SelectionSort "
          + "instance; " + e.getMessage());
    }
  }
}
