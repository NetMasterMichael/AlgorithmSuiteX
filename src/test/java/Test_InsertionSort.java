import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.BubbleSort;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.InsertionSort;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.ManualSorter;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.SortingAlgorithmMetrics;

class Test_InsertionSort {

	final String className = "Test_InsertionSort";

	@Test
	void testCreateInsertionSortInstance() {
		String testName = "testCreateInsertionSortInstance";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			InsertionSort testInsertionSort = new InsertionSort(new int[] { 1, 2, 3 });
			assertTrue(testInsertionSort instanceof InsertionSort,
					"Test that a new instance of InsertionSort is created successfully");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing creating an instance of InsertionSort; " + e.getMessage());
		}
	}

	@Test
	void testGetInputArray() {
		String testName = "testGetInputArray";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			InsertionSort testInsertionSort = new InsertionSort(new int[] { 5, 10, 15 });
			int[] expectedArray = { 5, 10, 15 };
			assertTrue(Arrays.equals(expectedArray, testInsertionSort.getInputArray()),
					"Test that getInputArray() returns the correct array");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing getting the input array from an instance of InsertionSort; "
					+ e.getMessage());
		}
	}

	@Test
	void testSetInputArray() {
		String testName = "testSetInputArray";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			int[] array1 = { 1, 2, 3, 4, 5 };
			int[] array2 = { 5, 10, 15, 20, 25 };
			InsertionSort testInsertionSort = new InsertionSort(array1);
			assertFalse(Arrays.equals(array2, testInsertionSort.getInputArray()),
					"Test that the array in testInsertionSort is different to array2 before using setInputArray()");
			testInsertionSort.setInputArray(array2);
			assertTrue(Arrays.equals(array2, testInsertionSort.getInputArray()),
					"Test that the new array is returned correctly after using setInputArray()");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing setting the input array of an instance of InsertionSort; "
					+ e.getMessage());
		}
	}

	@Test
	void testInsertionSort() {
		String testName = "testInsertionSort";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			int[] unsortedArray = { 8, 6, 3, 7, 2, 5, 4, 1 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
			InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
			assertFalse(Arrays.equals(sortedArray, testInsertionSort.getInputArray()),
					"Test that the basic array inside testInsertionSort is unsorted before calling sort()");
			assertFalse(testInsertionSort.isSorted(), "Test that isSorted() returns false before calling sort()");
			testInsertionSort.sort();
			assertTrue(Arrays.equals(sortedArray, testInsertionSort.getInputArray()),
					"Test that the basic array inside testInsertionSort is sorted after calling sort()");
			assertTrue(testInsertionSort.isSorted(), "Test that isSorted() returns true after calling sort()");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing insertion sort with a basic array; " + e.getMessage());
		}
	}
	
	@Test
	void testInsertionSortWithMetrics() {
		String testName = "testInsertionSortWithMetrics";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			int[] unsortedArray = { 2, 10, 3, 4, 8, 9, 7, 1, 6, 5 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
			SortingAlgorithmMetrics testMetrics = testInsertionSort.getMetrics();
			// Pre-checks
			assertFalse(Arrays.equals(sortedArray, testInsertionSort.getInputArray()),
					"Test that the basic array inside testInsertionSort is unsorted before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getComparisons(),
					"Test that the comparisons field inside testInsertionSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getSwaps(),
					"Test that the swaps field inside testInsertionSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getPasses(),
					"Test that the passes field inside testInsertionSort is zero before calling sortWithMetrics()");
			// Call sortWithMetrics()
			testInsertionSort.sortWithMetrics();
			// Post-checks
			assertTrue(Arrays.equals(sortedArray, testInsertionSort.getInputArray()),
					"Test that the basic array inside testInsertionSort is sorted after calling sortWithMetrics()");
			assertEquals(32, testMetrics.getComparisons(),
					"Test that the comparisons field inside testInsertionSort is 45 after calling sortWithMetrics()");
			assertEquals(23, testMetrics.getSwaps(),
					"Test that the swaps field inside testInsertionSort is 7 after calling sortWithMetrics()");
			assertEquals(9, testMetrics.getPasses(),
					"Test that the passes field inside testInsertionSort is 9 after calling sortWithMetrics()");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing insertion sort with metrics with a basic array; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testInsertionSortWithManualSorter() {
		String testName = "testInsertionSortWithManualSorter";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			int[] unsortedArray = { 7, 5, 3, 6, 10, 1, 4, 9, 2, 8 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			InsertionSort testInsertionSort = new InsertionSort(unsortedArray);
			ManualSorter testManualMode = testInsertionSort.preComputeManualSort();
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
			fail("Exception " + e + " thrown while testing insertion sort with a manual sorter with a basic array; "
					+ e.getMessage());
		}
	}
}
