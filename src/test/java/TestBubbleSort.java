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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestBubbleSort {

  final String className = "TestBubbleSort";

  @AfterEach
  void cleanupMemory() {
    System.gc();
  }

  // The numbering of tests is not indicative of their order of execution. These comments are purely
  // for improving readability and navigability of this source file.

  @Test
  void testCreateBubbleSortObject() { // Test 01
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
  void testGetMainArray() { // Test 02
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
  void testSetMainArray() { // Test 03
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
  void testBubbleSort() { // Test 04
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
  void testBubbleSortWithMetrics() { // Test 05
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
  void testBubbleSortWithManualSorter() { // Test 06
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
      fail("Exception " + e + " thrown while testing bubble sort with a manual sorter with a basic "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void stressTestBubbleSort() { // Test 07
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
  void stressTestBubbleSortWithMetrics() { // Test 08
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
  void stressTestBubbleSortWithManualSorter() { // Test 09
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

  // IMPORTANT NOTE
  // In theory, this algorithm can and will handle arrays with different variations of numbers.
  // However, these edge cases should still be tested individually, especially considering each
  // method contains a separate copy of the sorting algorithm. This will help with catching any
  // logic errors and ensure the robustness of the implementation of the algorithm.

  @Test
  void testBubbleSortWithNegativeNumbers() { // Test 10
    String testName = "testBubbleSortWithNegativeNumbers";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {-31, -14, 30, -4, 0, 81, -56, -75, 27, 14, 85, -63, 70, -11, 14,
          80, -10, -82, -75, 50};
      int[] sortedTestArray = new int[] {-82, -75, -75, -63, -56, -31, -14, -11, -10, -4, 0, 14, 14,
          27, 30, 50, 70, 80, 81, 85};

      BubbleSort testBubbleSort = new BubbleSort(testArray);
      assertFalse(Arrays.equals(sortedTestArray, testBubbleSort.getMainArray()),
          "Test that the array with negative numbers inside testBubbleSort starts as unsorted");
      assertFalse(testBubbleSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testBubbleSort.sort();
      assertArrayEquals(sortedTestArray, testBubbleSort.getMainArray(),
          "Test that testBubbleSort successfully sorts an array containing negative numbers");
      assertTrue(testBubbleSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort on an array containing negative "
          + "numbers; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithNegativeNumbersAndMetrics() { // Test 11
    String testName = "testBubbleSortWithNegativeNumbersAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-2, -17, -38, 88, -86, -82, -14, 88, -17, -55, 63, 42, 32,
          98, -38, 32, -96, 34, 85, 62};
      int[] sortedArray = new int[] {-96, -86, -82, -55, -38, -38, -17, -17, -14, -2, 32, 32, 34,
          42, 62, 63, 85, 88, 88, 98};
      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testBubbleSort.getMainArray()), "Test that the array "
          + "with negative numbers in testBubbleSort is unsorted before calling sortWithMetrics()");
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
      assertEquals(391, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is 391 after calling sortWithMetrics()");
      assertEquals(77, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is "
          + "77 after calling sortWithMetrics()");
      assertEquals(17, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is 17 after calling sortWithMetrics()");
      assertEquals(682, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testBubbleSort is 682 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort with metrics on an array "
          + "containing negative numbers; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithNegativeNumbersAndManualSorter() { // Test 12
    String testName = "testBubbleSortWithNegativeNumbersAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-95, 4, -42, 21, -97, -50, 50, -18, -59, 82, -91, -11, 22,
          -24, 77, -63, 92, -59, 53, 85};
      int[] sortedArray = new int[] {-97, -95, -91, -63, -59, -59, -50, -42, -24, -18, -11, 4, 21,
          22, 50, 53, 77, 82, 85, 92};
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
      fail("Exception " + e + " thrown while testing bubble sort with a manual sorter on an array "
          + "containing negative numbers; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithDuplicateNumbers() { // Test 13
    String testName = "testBubbleSortWithDuplicateNumbers";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {95, -66, 26, 94, 67, 11, 68, 90, 14, 90, 26, 32, 9, 89, 95, 67,
          -8, -32, -10, -46, 46, 89, 67, 49, -58, -52, -46, -61, -79, 99, -50, -40, 94, -76, -33,
          -58, -19, 92, 6, -43, -94, 17, 15, -33, -38, 99, 11, 46, 17, 15};
      int[] sortedTestArray = new int[] {-94, -79, -76, -66, -61, -58, -58, -52, -50, -46, -46, -43,
          -40, -38, -33, -33, -32, -19, -10, -8, 6, 9, 11, 11, 14, 15, 15, 17, 17, 26, 26, 32, 46,
          46, 49, 67, 67, 67, 68, 89, 89, 90, 90, 92, 94, 94, 95, 95, 99, 99};

      BubbleSort testBubbleSort = new BubbleSort(testArray);
      assertFalse(Arrays.equals(sortedTestArray, testBubbleSort.getMainArray()),
          "Test that the array with duplicate numbers inside testBubbleSort starts as unsorted");
      assertFalse(testBubbleSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testBubbleSort.sort();
      assertArrayEquals(sortedTestArray, testBubbleSort.getMainArray(),
          "Test that testBubbleSort successfully sorts an array containing duplicate numbers");
      assertTrue(testBubbleSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort on an array containing duplicate "
          + "numbers; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithDuplicateNumbersAndMetrics() { // Test 14
    String testName = "testBubbleSortWithDuplicateNumbersAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-3, 79, 55, -68, 42, 12, 42, -54, -14, 98, 13, -77, 2, -17,
          10, -78, -95, 55, 10, -59, -70, -68, -95, 92, 34, 12, 7, 8, -50, -14, -17, 7, -97, 0, -3,
          -85, 60, -3, -22, -10, -84, 39, 13, -59, -68, 11, -3, 39, -95, 90};
      int[] sortedArray = new int[] {-97, -95, -95, -95, -85, -84, -78, -77, -70, -68, -68, -68,
          -59, -59, -54, -50, -22, -17, -17, -14, -14, -10, -3, -3, -3, -3, 0, 2, 7, 7, 8, 10, 10,
          11, 12, 12, 13, 13, 34, 39, 39, 42, 42, 55, 55, 60, 79, 90, 92, 98};
      BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testBubbleSort.getMainArray()), "Test that the array "
          + "with duplicate numbers in testBubbleSort is unsorted before using sortWithMetrics()");
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
      assertArrayEquals(sortedArray, testBubbleSort.getMainArray(),
          "Test that the array with duplicate numbers "
              + "inside testBubbleSort is sorted after calling sortWithMetrics()");
      assertEquals(2484, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is 2484 after calling sortWithMetrics()");
      assertEquals(665, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is"
          + " 665 after calling sortWithMetrics()");
      assertEquals(46, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is 46 after calling sortWithMetrics()");
      assertEquals(5098, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testBubbleSort is 5098 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort with metrics on an array "
          + "containing duplicate numbers; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithDuplicateNumbersAndManualSorter() { // Test 15
    String testName = "testBubbleSortWithDuplicateNumbersAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-82, -25, -63, 84, -64, -55, -48, 7, 8, -46, -80, -25, 49,
          -80, 79, -60, 84, -29, 98, -14, -29, -81, -82, -55, -81, 38, 44, -70, 3, -60, -14, -48,
          -2, -27, 76, 38, -94, 38, 71, -21, -29, 49, 4, -61, -15, -88, -95, 34, -61, -63};
      int[] sortedArray = new int[] {-95, -94, -88, -82, -82, -81, -81, -80, -80, -70, -64, -63,
          -63, -61, -61, -60, -60, -55, -55, -48, -48, -46, -29, -29, -29, -27, -25, -25, -21, -15,
          -14, -14, -2, 3, 4, 7, 8, 34, 38, 38, 38, 44, 49, 49, 71, 76, 79, 84, 84, 98};
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
      fail("Exception " + e + " thrown while testing bubble sort with a manual sorter on an array "
          + "containing duplicate numbers; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithOneElement() { // Test 16
    String testName = "testBubbleSortWithOneElement";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      BubbleSort testBubbleSort = new BubbleSort(testArray);
      testBubbleSort.sort();
      assertArrayEquals(testArray, testBubbleSort.getMainArray(), "Test that testBubbleSort.sort() "
          + "with one element didn't exert any exceptions or unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort on an array containing one single "
          + "element; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithOneElementAndMetrics() { // Test 17
    String testName = "testBubbleSortWithOneElementAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      BubbleSort testBubbleSort = new BubbleSort(testArray);
      SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
      // Pre-checks
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
      assertArrayEquals(testArray, testBubbleSort.getMainArray(),
          "Test that the array with one element "
              + "inside testBubbleSort is sorted after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is 2484 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is"
          + " 665 after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is 46 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testBubbleSort is 5098 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort with metrics on an array "
          + "containing one element; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithOneElementAndManualSorter() { // Test 18
    String testName = "testBubbleSortWithOneElementAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      BubbleSort testBubbleSort = new BubbleSort(testArray);
      ManualSorter testManualMode = testBubbleSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing bubble sort with a manual sorter on an array "
          + "containing one element; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithEmptyArray() { // Test 19
    String testName = "testBubbleSortWithEmptyArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      BubbleSort testBubbleSort = new BubbleSort(testArray);
      testBubbleSort.sort();
      assertArrayEquals(testArray, testBubbleSort.getMainArray(), "Test that testBubbleSort.sort() "
          + "with one element didn't exert any exceptions or unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort on an empty array; "
          + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithEmptyArrayAndMetrics() { // Test 20
    String testName = "testBubbleSortWithEmptyArrayAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      BubbleSort testBubbleSort = new BubbleSort(testArray);
      SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
      // Pre-checks
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
      assertArrayEquals(testArray, testBubbleSort.getMainArray(),
          "Test that the array with duplicate numbers "
              + "inside testBubbleSort is sorted after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is"
          + " 0 after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testBubbleSort is 0 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort with metrics on an empty array; "
          + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithEmptyArrayAndManualSorter() { // Test 21
    String testName = "testBubbleSortWithEmptyArrayAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      BubbleSort testBubbleSort = new BubbleSort(testArray);
      ManualSorter testManualMode = testBubbleSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing bubble sort with a manual sorter on an empty "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithNullArray() { // Test 22
    String testName = "testBubbleSortWithNullArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      BubbleSort testBubbleSort = new BubbleSort(null);
      testBubbleSort.sort();
      assertArrayEquals(expectedArray, testBubbleSort.getMainArray(),
          "Test that testBubbleSort.sort() "
              + "with one element didn't exert any exceptions or unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort on a null array; "
          + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithNullArrayAndMetrics() { // Test 23
    String testName = "testBubbleSortWithNullArrayAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      BubbleSort testBubbleSort = new BubbleSort(null);
      SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
      // Pre-checks
      assertArrayEquals(expectedArray, testBubbleSort.getMainArray(),
          "Test that mainArray initialised with an empty array instead of null");
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
      assertArrayEquals(expectedArray, testBubbleSort.getMainArray(),
          "Test that mainArray is still an empty array, instead of null");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testBubbleSort is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testBubbleSort is"
          + " 1 after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getPasses(), "Test that the passes field inside testBubbleSort "
          + "is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testBubbleSort is 1 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing bubble sort with metrics on a null array; "
          + e.getMessage());
    }
  }

  @Test
  void testBubbleSortWithNullArrayAndManualSorter() { // Test 24
    String testName = "testBubbleSortWithNullArrayAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      BubbleSort testBubbleSort = new BubbleSort(null);
      ManualSorter testManualMode = testBubbleSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing bubble sort with a manual sorter on a null "
          + "array; " + e.getMessage());
    }
  }
}
