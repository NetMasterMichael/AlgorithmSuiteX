import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.MergeSort;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.SortingAlgorithmMetrics;

class Test_MergeSort {

	final String className = "Test_MergeSort";

	@Test
	void testCreateMergeSortObject() {
		String testName = "testCreateMergeSortObject";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			MergeSort testMergeSort = new MergeSort(new int[] { 1, 2, 3 });
			assertTrue(testMergeSort instanceof MergeSort,
					"Test that a new instance of MergeSort is created successfully");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing creating an instance of MergeSort; " + e.getMessage());
		}
	}

	@Test
	void testGetInputArray() {
		String testName = "testGetInputArray";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			MergeSort testMergeSort = new MergeSort(new int[] { 5, 10, 15 });
			int[] expectedArray = { 5, 10, 15 };
			assertTrue(Arrays.equals(expectedArray, testMergeSort.getInputArray()),
					"Test that getInputArray() returns the correct array");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing getting the input array from an instance of MergeSort; "
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
			MergeSort testMergeSort = new MergeSort(array1);
			assertFalse(Arrays.equals(array2, testMergeSort.getInputArray()),
					"Test that the array in testMergeSort is different to array2 before using setInputArray()");
			testMergeSort.setInputArray(array2);
			assertTrue(Arrays.equals(array2, testMergeSort.getInputArray()),
					"Test that the new array is returned correctly after using setInputArray()");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing setting the input array of an instance of MergeSort; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testMergeSort() {
		String testName = "testMergeSort";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			int[] unsortedArray = { 8, 6, 3, 7, 2, 5, 4, 1 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
			MergeSort testMergeSort = new MergeSort(unsortedArray);
			assertFalse(Arrays.equals(sortedArray, testMergeSort.getInputArray()),
					"Test that the basic array inside testMergeSort is unsorted before calling sort()");
			assertFalse(testMergeSort.isSorted(), "Test that isSorted() returns false before calling sort()");
			testMergeSort.sort();
			assertTrue(Arrays.equals(sortedArray, testMergeSort.getInputArray()),
					"Test that the basic array inside testMergeSort is sorted after calling sort()");
			assertTrue(testMergeSort.isSorted(), "Test that isSorted() returns true after calling sort()");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing merge sort with a basic array; " + e.getMessage());
		}
	}
	
	@Test
	void testMergeSortWithMetrics() {
		String testName = "testMergeSortWithMetrics";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			int[] unsortedArray = { 2, 10, 3, 4, 8, 9, 7, 1, 6, 5 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			MergeSort testMergeSort = new MergeSort(unsortedArray);
			SortingAlgorithmMetrics testMetrics = testMergeSort.getMetrics();
			// Pre-checks
			assertFalse(Arrays.equals(sortedArray, testMergeSort.getInputArray()),
					"Test that the basic array inside testMergeSort is unsorted before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getComparisons(),
					"Test that the comparisons field inside testMergeSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getSwaps(),
					"Test that the swaps field inside testMergeSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getPasses(),
					"Test that the passes field inside testMergeSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getArrayAccesses(),
					"Test that the arrayAccesses field inside testMergeSort is zero before calling sortWithMetrics()");
			// Call sortWithMetrics()
			testMergeSort.sortWithMetrics();
			// Post-checks
			assertTrue(Arrays.equals(sortedArray, testMergeSort.getInputArray()),
					"Test that the basic array inside testMergeSort is sorted after calling sortWithMetrics()");
			assertEquals(187, testMetrics.getComparisons(),
					"Test that the comparisons field inside testMergeSort is 187 after calling sortWithMetrics()");
			// Swaps not implemented
			// assertEquals(0, testMetrics.getSwaps(), "Test that the swaps field inside testMergeSort is 7 after calling sortWithMetrics()");
			// Passes not implemented
			// assertEquals(9, testMetrics.getPasses(), "Test that the passes field inside testMergeSort is 9 after calling sortWithMetrics()");
			assertEquals(182, testMetrics.getArrayAccesses(),
					"Test that the arrayAccesses field inside testMergeSort is 182 after calling sortWithMetrics()");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing merge sort with metrics with a basic array; "
					+ e.getMessage());
		}
	}
}
