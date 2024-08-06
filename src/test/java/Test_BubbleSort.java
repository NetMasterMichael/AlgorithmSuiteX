import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.BubbleSort;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.ManualSorter;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.SortingAlgorithmMetrics;

class Test_BubbleSort {

	int[] generateSortedArray(int size) {
		int[] sortedArray = new int[size];
		for (int i = 1; i <= size; i++) {
			sortedArray[i - 1] = i;
		}
		return sortedArray;
	}
	
	int[] generateUnsortedArray(int size) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		int[] unsortedArray = new int[size];
		Random rand = new Random();
		int randIndex;
		
		// Fill up a list and sortedArray with numbers 1 to n
		for (int i = 1; i <= size; i++) {
			numberList.add(i);
		}
		// Fill up unsortedArray with random numbers from numberList
		for (int i = 0; i < size; i++) {
			randIndex = rand.nextInt(numberList.size());
			unsortedArray[i] = numberList.get(randIndex);
			numberList.remove(randIndex);
		}
		return unsortedArray;
	}

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
			SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
			// Pre-checks
			assertFalse(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is unsorted before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getComparisons(),
					"Test that the comparisons field inside testBubbleSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getSwaps(),
					"Test that the swaps field inside testBubbleSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getPasses(),
					"Test that the passes field inside testBubbleSOrt is zero before calling sortWithMetrics()");
			// Call sortWithMetrics()
			testBubbleSort.sortWithMetrics();
			// Post-checks
			assertTrue(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is sorted after calling sortWithMetrics()");
			assertEquals(44, testMetrics.getComparisons(),
					"Test that the comparisons field inside testBubbleSort is 44 after calling sortWithMetrics()");
			assertEquals(23, testMetrics.getSwaps(),
					"Test that the swaps field inside testBubbleSort is 23 after calling sortWithMetrics()");
			assertEquals(8, testMetrics.getPasses(),
					"Test that the passes field inside testBubbleSort is 8 after calling sortWithMetrics()");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing bubble sort with metrics with a basic array; "
					+ e.getMessage());
		}
	}

	@Test
	void testBubbleSortWithManualSorter() {
		try {
			int[] unsortedArray = { 7, 5, 3, 6, 10, 1, 4, 9, 2, 8 };
			int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
			ManualSorter testManualMode = testBubbleSort.preComputeManualSort();
			while (true) {
				testManualMode.step();
				if (Arrays.equals(testManualMode.getArray(), sortedArray)) {
					assertTrue(true);
					break;
				}
			}
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing bubble sort with a manual sorter with a basic array; "
					+ e.getMessage());
		}
	}

	@Test
	void stressTestBubbleSort() {
		try {
			int arraySize = 50000;
			int[] sortedArray = generateSortedArray(arraySize);
			int[] unsortedArray = generateUnsortedArray(arraySize);
			
			BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
			assertFalse(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the random array inside testBubbleSort is unsorted before calling sort()");
			assertFalse(testBubbleSort.isSorted(), "Test that isSorted() returns false before calling sort()");
			testBubbleSort.sort();
			assertTrue(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the random array inside testBubbleSort is sorted after calling sort()");
			assertTrue(testBubbleSort.isSorted(), "Test that isSorted() returns true after calling sort()");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while stress testing bubble sort; " + e.getMessage());
		}
	}

	@Test
	void stressTestBubbleSortWithMetrics() {
		try {
			int arraySize = 50000;
			int[] sortedArray = generateSortedArray(arraySize);
			int[] unsortedArray = generateUnsortedArray(arraySize);
			
			BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
			SortingAlgorithmMetrics testMetrics = testBubbleSort.getMetrics();
			// Pre-checks
			assertFalse(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is unsorted before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getComparisons(),
					"Test that the comparisons field inside testBubbleSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getSwaps(),
					"Test that the swaps field inside testBubbleSort is zero before calling sortWithMetrics()");
			assertEquals(0, testMetrics.getPasses(),
					"Test that the passes field inside testBubbleSort is zero before calling sortWithMetrics()");
			// Call sortWithMetrics()
			testBubbleSort.sortWithMetrics();
			// Post-checks
			assertTrue(Arrays.equals(sortedArray, testBubbleSort.getInputArray()),
					"Test that the basic array inside testBubbleSort is sorted after calling sortWithMetrics()");
			assertNotEquals(0, testMetrics.getComparisons(),
					"Test that the comparisons field inside testBubbleSort is no longer zero after calling sortWithMetrics()");
			assertNotEquals(0, testMetrics.getSwaps(),
					"Test that the swaps field inside testBubbleSort is no longer zero after calling sortWithMetrics()");
			assertNotEquals(0, testMetrics.getPasses(),
					"Test that the passes field inside testBubbleSort is no longer zero after calling sortWithMetrics()");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while stress testing bubble sort with metrics; " + e.getMessage());
		}
	}

	@Test
	void stressTestBubbleSortWithManualSorter() {
		try {
			int arraySize = 2500;
			int[] sortedArray = generateSortedArray(arraySize);
			int[] unsortedArray = generateUnsortedArray(arraySize);
			
			BubbleSort testBubbleSort = new BubbleSort(unsortedArray);
			ManualSorter testManualMode = testBubbleSort.preComputeManualSort();
			while (true) {
				testManualMode.step();
				if (Arrays.equals(testManualMode.getArray(), sortedArray)) {
					assertTrue(true);
					break;
				}
			}
		} catch (Exception e) {
			fail("Exception " + e + " thrown while stress testing bubble sort; " + e.getMessage());
		}
	}
}
