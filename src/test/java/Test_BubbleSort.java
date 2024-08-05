import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms.BubbleSort;

class Test_BubbleSort {

	@Test
	void testCreateBubbleSortObject() {
		try {
			BubbleSort testBubbleSort = new BubbleSort(new int[] { 1, 2, 3 });
			assertTrue(testBubbleSort instanceof BubbleSort,
					"Test that a new instance of BubbleSort is created successfully");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing creating an instance of BubbleSort; " + e.getMessage());
		}
	}

	@Test
	void testGetInputArray() {
		try {
			BubbleSort testBubbleSort = new BubbleSort(new int[] { 5, 10, 15 });
			int[] expectedArray = { 5, 10, 15 };
			assertTrue(Arrays.equals(expectedArray, testBubbleSort.getInputArray()),
					"Test that getInputArray() returns the correct array");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing getting the input array from an instance of BubbleSort; "
					+ e.getMessage());
		}
	}

	@Test
	void testSetInputArray() {
		try {
			int[] array1 = { 1, 2, 3, 4, 5 };
			int[] array2 = { 5, 10, 15, 20, 25 };
			BubbleSort testBubbleSort = new BubbleSort(array1);
			assertFalse(Arrays.equals(array2, testBubbleSort.getInputArray()),
					"Test that the array in testBubbleSort is different to array2 before using setInputArray()");
			testBubbleSort.setInputArray(array2);
			assertTrue(Arrays.equals(array2, testBubbleSort.getInputArray()),
					"Test that the new array is returned correctly after using setInputArray()");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing setting the input array of an instance of BubbleSort; "
					+ e.getMessage());
		}
	}

	@Test
	void testBubbleSort() {
		try {
			int[] unsortedArray = { 8, 6, 3, 7, 2, 5, 4, 1 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
			BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
			assertFalse(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is unsorted before calling sort()");
			assertFalse(testBubbleSort.isSorted(), "Test that isSorted() returns false before calling sort()");
			testBubbleSort.sort();
			assertTrue(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is sorted after calling sort()");
			assertTrue(testBubbleSort.isSorted(), "Test that isSorted() returns true after calling sort()");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing bubble sort with a basic array; " + e.getMessage());
		}
	}

	@Test
	void testBubbleSortWithMetrics() {
		try {
			int[] unsortedArray = { 7, 5, 3, 6, 10, 1, 4, 9, 2, 8 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
			// Pre-checks
			assertFalse(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is unsorted before calling sortWithMetrics()");
			assertEquals(0, testBubbleSort.getComparisons(),
					"Test that the comparisons field inside testBubbleSort is zero before calling sortWithMetrics()");
			assertEquals(0, testBubbleSort.getSwaps(),
					"Test that the swaps field inside testBubbleSort is zero before calling sortWithMetrics()");
			assertEquals(0, testBubbleSort.getPasses(),
					"Test that the passes field inside testBubbleSOrt is zero before calling sortWithMetrics()");
			// Call sortWithMetrics()
			testBubbleSort.sortWithMetrics();
			// Post-checks
			assertTrue(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is sorted after calling sortWithMetrics()");
			assertEquals(44, testBubbleSort.getComparisons(),
					"Test that the comparisons field inside testBubbleSort is 44 after calling sortWithMetrics()");
			assertEquals(23, testBubbleSort.getSwaps(),
					"Test that the swaps field inside testBubbleSort is 23 after calling sortWithMetrics()");
			assertEquals(8, testBubbleSort.getPasses(),
					"Test that the passes field inside testBubbleSOrt is zero before calling sortWithMetrics()");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing bubble sort with metrics with a basic array; "
					+ e.getMessage());
		}
	}
}
