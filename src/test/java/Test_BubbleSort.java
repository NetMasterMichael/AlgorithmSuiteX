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
			testBubbleSort.sort();
			assertTrue(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is sorted after calling sort()");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing bubble sort with a basic array; " + e.getMessage());
		}
	}

}
