import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.MergeSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmType;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestMergeSort {

  final String className = "TestMergeSort";

  // The numbering of tests is not indicative of their order of execution. These comments are purely
  // for improving readability and navigability of this source file.
  
  @AfterEach
  void cleanupMemory() {
    System.gc();
  }

  @Test
  void testCreateMergeSortObject() { // Test 01
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
  void testGetMainArray() { // Test 02
    String testName = "testGetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      MergeSort testMergeSort = new MergeSort(new int[] {5, 10, 15});
      int[] expectedArray = {5, 10, 15};
      assertArrayEquals(expectedArray, testMergeSort.getMainArray(),
          "Test that getMainArray() returns the correct array");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getting the main array from an instance of "
          + "MergeSort; " + e.getMessage());
    }
  }

  @Test
  void testSetMainArray() { // Test 03
    String testName = "testSetMainArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] array1 = {1, 2, 3, 4, 5};
      int[] array2 = {5, 10, 15, 20, 25};
      MergeSort testMergeSort = new MergeSort(array1);
      assertFalse(Arrays.equals(array2, testMergeSort.getMainArray()),
          "Test that the array in testMergeSort is different to array2 "
              + "before using setMainArray()");
      testMergeSort.setMainArray(array2);
      assertArrayEquals(array2, testMergeSort.getMainArray(),
          "Test that the new array is returned correctly after using setMainArray()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing setting the main array of an instance of "
          + "MergeSort; " + e.getMessage());
    }
  }

  @Test
  void testMergeSort() { // Test 04
    String testName = "testMergeSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {8, 6, 3, 7, 2, 5, 4, 1};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getMainArray()),
          "Test that the basic array inside testMergeSort is unsorted before calling sort()");
      assertFalse(testMergeSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testMergeSort.sort();
      assertArrayEquals(sortedArray, testMergeSort.getMainArray(),
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
  void testMergeSortWithMetrics() { // Test 05
    String testName = "testMergeSortWithMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = {2, 10, 3, 4, 8, 9, 7, 1, 6, 5};
      int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getMainArray()), "Test that the basic "
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
      assertArrayEquals(sortedArray, testMergeSort.getMainArray(), "Test that the basic array "
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
  void testMergeSortWithManualSorter() { // Test 06
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
  void stressTestMergeSort() { // Test 07
    String testName = "stressTestMergeSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int arraySize = 50000;
      AuxiliaryTestMethods.logMessage(className,
          testName + " : Stress test array size: " + Integer.toString(arraySize));

      int[] sortedArray = AuxiliaryTestMethods.generateSortedArray(arraySize);
      int[] unsortedArray = AuxiliaryTestMethods.generateUnsortedArray(arraySize);

      MergeSort testMergeSort = new MergeSort(unsortedArray);
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getMainArray()),
          "Test that the random array inside testMergeSort is unsorted before calling sort()");
      assertFalse(testMergeSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testMergeSort.sort();
      assertArrayEquals(sortedArray, testMergeSort.getMainArray(),
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
  void stressTestMergeSortWithMetrics() { // Test 08
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
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getMainArray()), "Test that the basic "
          + "array inside testMergeSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testMergeSort.getMainArray(), "Test that the basic array "
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
  void stressTestMergeSortWithManualSorter() { // Test 09
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

  // IMPORTANT NOTE
  // In theory, this algorithm can and will handle arrays with different variations of numbers.
  // However, these edge cases should still be tested individually, especially considering each
  // method contains a separate copy of the sorting algorithm. This will help with catching any
  // logic errors and ensure the robustness of the implementation of the algorithm.

  @Test
  void testMergeSortWithNegativeNumbers() { // Test 10
    String testName = "testMergeSortWithNegativeNumbers";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {-31, -14, 30, -4, 0, 81, -56, -75, 27, 14, 85, -63, 70, -11, 14,
          80, -10, -82, -75, 50};
      int[] sortedTestArray = new int[] {-82, -75, -75, -63, -56, -31, -14, -11, -10, -4, 0, 14, 14,
          27, 30, 50, 70, 80, 81, 85};

      MergeSort testMergeSort = new MergeSort(testArray);
      assertFalse(Arrays.equals(sortedTestArray, testMergeSort.getMainArray()),
          "Test that the array with negative numbers inside testMergeSort starts as unsorted");
      assertFalse(testMergeSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testMergeSort.sort();
      assertArrayEquals(sortedTestArray, testMergeSort.getMainArray(),
          "Test that testMergeSort successfully sorts an array containing negative numbers");
      assertTrue(testMergeSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort on an array containing negative "
          + "numbers; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithNegativeNumbersAndMetrics() { // Test 11
    String testName = "testMergeSortWithNegativeNumbersAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-2, -17, -38, 88, -86, -82, -14, 88, -17, -55, 63, 42, 32,
          98, -38, 32, -96, 34, 85, 62};
      int[] sortedArray = new int[] {-96, -86, -82, -55, -38, -38, -17, -17, -14, -2, 32, 32, 34,
          42, 62, 63, 85, 88, 88, 98};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getMainArray()), "Test that the array "
          + "with negative numbers in testMergeSort is unsorted before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testMergeSort.getMainArray(), "Test that the basic array "
          + "inside testMergeSort is sorted after calling sortWithMetrics()");
      assertEquals(459, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is 459 after calling sortWithMetrics()");
      assertEquals(176, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "176 after calling sortWithMetrics()");
      assertEquals(482, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is 482 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with metrics on an array "
          + "containing negative numbers; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithNegativeNumbersAndManualSorter() { // Test 12
    String testName = "testMergeSortWithNegativeNumbersAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-95, 4, -42, 21, -97, -50, 50, -18, -59, 82, -91, -11, 22,
          -24, 77, -63, 92, -59, 53, 85};
      int[] sortedArray = new int[] {-97, -95, -91, -63, -59, -59, -50, -42, -24, -18, -11, 4, 21,
          22, 50, 53, 77, 82, 85, 92};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      ManualSorter testManualMode = testMergeSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing merge sort with a manual sorter on an array "
          + "containing negative numbers; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithDuplicateNumbers() { // Test 13
    String testName = "testMergeSortWithDuplicateNumbers";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {95, -66, 26, 94, 67, 11, 68, 90, 14, 90, 26, 32, 9, 89, 95, 67,
          -8, -32, -10, -46, 46, 89, 67, 49, -58, -52, -46, -61, -79, 99, -50, -40, 94, -76, -33,
          -58, -19, 92, 6, -43, -94, 17, 15, -33, -38, 99, 11, 46, 17, 15};
      int[] sortedTestArray = new int[] {-94, -79, -76, -66, -61, -58, -58, -52, -50, -46, -46, -43,
          -40, -38, -33, -33, -32, -19, -10, -8, 6, 9, 11, 11, 14, 15, 15, 17, 17, 26, 26, 32, 46,
          46, 49, 67, 67, 67, 68, 89, 89, 90, 90, 92, 94, 94, 95, 95, 99, 99};

      MergeSort testMergeSort = new MergeSort(testArray);
      assertFalse(Arrays.equals(sortedTestArray, testMergeSort.getMainArray()),
          "Test that the array with duplicate numbers inside testMergeSort starts as unsorted");
      assertFalse(testMergeSort.isSorted(),
          "Test that isSorted() returns false before calling sort()");
      testMergeSort.sort();
      assertArrayEquals(sortedTestArray, testMergeSort.getMainArray(),
          "Test that testMergeSort successfully sorts an array containing duplicate numbers");
      assertTrue(testMergeSort.isSorted(),
          "Test that isSorted() returns true after calling sort()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort on an array containing duplicate "
          + "numbers; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithDuplicateNumbersAndMetrics() { // Test 14
    String testName = "testMergeSortWithDuplicateNumbersAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-3, 79, 55, -68, 42, 12, 42, -54, -14, 98, 13, -77, 2, -17,
          10, -78, -95, 55, 10, -59, -70, -68, -95, 92, 34, 12, 7, 8, -50, -14, -17, 7, -97, 0, -3,
          -85, 60, -3, -22, -10, -84, 39, 13, -59, -68, 11, -3, 39, -95, 90};
      int[] sortedArray = new int[] {-97, -95, -95, -95, -85, -84, -78, -77, -70, -68, -68, -68,
          -59, -59, -54, -50, -22, -17, -17, -14, -14, -10, -3, -3, -3, -3, 0, 2, 7, 7, 8, 10, 10,
          11, 12, 12, 13, 13, 34, 39, 39, 42, 42, 55, 55, 60, 79, 90, 92, 98};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertFalse(Arrays.equals(sortedArray, testMergeSort.getMainArray()), "Test that the array "
          + "with duplicate numbers in testMergeSort is unsorted before using sortWithMetrics()");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getPasses(), "Test that the passes field inside testMergeSort "
          + "is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(sortedArray, testMergeSort.getMainArray(),
          "Test that the array with duplicate numbers "
              + "inside testMergeSort is sorted after calling sortWithMetrics()");
      assertEquals(1417, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is 1417 after calling sortWithMetrics()");
      assertEquals(572, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is"
          + " 572 after calling sortWithMetrics()");
      assertEquals(1596, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is 1596 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with metrics on an array "
          + "containing duplicate numbers; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithDuplicateNumbersAndManualSorter() { // Test 15
    String testName = "testMergeSortWithDuplicateNumbersAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] unsortedArray = new int[] {-82, -25, -63, 84, -64, -55, -48, 7, 8, -46, -80, -25, 49,
          -80, 79, -60, 84, -29, 98, -14, -29, -81, -82, -55, -81, 38, 44, -70, 3, -60, -14, -48,
          -2, -27, 76, 38, -94, 38, 71, -21, -29, 49, 4, -61, -15, -88, -95, 34, -61, -63};
      int[] sortedArray = new int[] {-95, -94, -88, -82, -82, -81, -81, -80, -80, -70, -64, -63,
          -63, -61, -61, -60, -60, -55, -55, -48, -48, -46, -29, -29, -29, -27, -25, -25, -21, -15,
          -14, -14, -2, 3, 4, 7, 8, 34, 38, 38, 38, 44, 49, 49, 71, 76, 79, 84, 84, 98};
      MergeSort testMergeSort = new MergeSort(unsortedArray);
      ManualSorter testManualMode = testMergeSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing merge sort with a manual sorter on an array "
          + "containing duplicate numbers; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithOneElement() { // Test 16
    String testName = "testMergeSortWithOneElement";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      MergeSort testMergeSort = new MergeSort(testArray);
      testMergeSort.sort();
      assertArrayEquals(testArray, testMergeSort.getMainArray(), "Test that testMergeSort.sort() "
          + "with one element didn't exert any exceptions or unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort on an array containing one single "
          + "element; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithOneElementAndMetrics() { // Test 17
    String testName = "testMergeSortWithOneElementAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      MergeSort testMergeSort = new MergeSort(testArray);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(testArray, testMergeSort.getMainArray(),
          "Test that the array with one element "
              + "inside testMergeSort is sorted after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is 2484 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is"
          + " 665 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is 5098 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with metrics on an array "
          + "containing one element; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithOneElementAndManualSorter() { // Test 18
    String testName = "testMergeSortWithOneElementAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {1};
      MergeSort testMergeSort = new MergeSort(testArray);
      ManualSorter testManualMode = testMergeSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing merge sort with a manual sorter on an array "
          + "containing one element; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithEmptyArray() { // Test 19
    String testName = "testMergeSortWithEmptyArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      MergeSort testMergeSort = new MergeSort(testArray);
      testMergeSort.sort();
      assertArrayEquals(testArray, testMergeSort.getMainArray(), "Test that testMergeSort.sort() "
          + "with one element didn't exert any exceptions or unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort on an empty array; "
          + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithEmptyArrayAndMetrics() { // Test 20
    String testName = "testMergeSortWithEmptyArrayAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      MergeSort testMergeSort = new MergeSort(testArray);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(testArray, testMergeSort.getMainArray(),
          "Test that the array with duplicate numbers "
              + "inside testMergeSort is sorted after calling sortWithMetrics()");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is"
          + " 0 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is 0 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with metrics on an empty array; "
          + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithEmptyArrayAndManualSorter() { // Test 21
    String testName = "testMergeSortWithEmptyArrayAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] testArray = new int[] {};
      MergeSort testMergeSort = new MergeSort(testArray);
      ManualSorter testManualMode = testMergeSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing merge sort with a manual sorter on an empty "
          + "array; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithNullArray() { // Test 22
    String testName = "testMergeSortWithNullArray";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      MergeSort testMergeSort = new MergeSort(null);
      testMergeSort.sort();
      assertArrayEquals(expectedArray, testMergeSort.getMainArray(),
          "Test that testMergeSort.sort() "
              + "with one element didn't exert any exceptions or unpredictable behaviour");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail(
          "Exception " + e + " thrown while testing merge sort on a null array; " + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithNullArrayAndMetrics() { // Test 23
    String testName = "testMergeSortWithNullArrayAndMetrics";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      MergeSort testMergeSort = new MergeSort(null);
      SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
      // Pre-checks
      assertArrayEquals(expectedArray, testMergeSort.getMainArray(),
          "Test that mainArray initialised with an empty array instead of null");
      assertEquals(0, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is "
          + "zero before calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is zero before calling sortWithMetrics()");
      // Call sortWithMetrics()
      testMergeSort.sortWithMetrics();
      // Post-checks
      assertArrayEquals(expectedArray, testMergeSort.getMainArray(),
          "Test that mainArray is still an empty array, instead of null");
      assertEquals(1, testMetrics.getComparisons(), "Test that the comparisons field inside "
          + "testMergeSort is 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is"
          + " 1 after calling sortWithMetrics()");
      assertEquals(0, testMetrics.getArrayAccesses(), "Test that the arrayAccesses field inside "
          + "testMergeSort is 1 after calling sortWithMetrics()");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing merge sort with metrics on a null array; "
          + e.getMessage());
    }
  }

  @Test
  void testMergeSortWithNullArrayAndManualSorter() { // Test 24
    String testName = "testMergeSortWithNullArrayAndManualSorter";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      int[] expectedArray = new int[] {};
      MergeSort testMergeSort = new MergeSort(null);
      ManualSorter testManualMode = testMergeSort.preComputeManualSort();
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
      fail("Exception " + e + " thrown while testing merge sort with a manual sorter on a null "
          + "array; " + e.getMessage());
    }
  }
  
  @Test
  void testGetAlgorithmType() { // Test 25
    String testName = "testGetAlgorithmType";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      MergeSort testMergeSort = new MergeSort(null);
      assertEquals(SortingAlgorithmType.MERGE_SORT, testMergeSort.getAlgorithmType(),
          "Test that getAlgorithmType() on a MergeSort instance returns "
              + "SortingAlgorithmType.MERGE_SORT");
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing getAlgorithmType() on an MergeSort "
          + "instance; " + e.getMessage());
    }
  }
}
