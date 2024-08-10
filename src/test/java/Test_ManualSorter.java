import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.BubbleSort;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.ManualSorter;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.SelectionSort;
import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.SortingAlgorithmOperation;

class Test_ManualSorter {

	final String className = "Test_ManualSorter";

	@Test
	void testCreateManualSorter() {
		String testName = "testCreateManualSorter";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			ManualSorter testManualSorter = new ManualSorter(new int[] { 1, 2, 3 },
					new LinkedList<SortingAlgorithmOperation>(), new LinkedList<Integer>());
			assertTrue(testManualSorter instanceof ManualSorter,
					"Test that a new instance of ManualSorter is created successfully");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing creating an instance of ManualSorter; " + e.getMessage());
		}
	}

	@Test
	void testGetArray() {
		String testName = "testGetArray";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			ManualSorter testManualSorter = new ManualSorter(new int[] { 1, 2, 3 },
					new LinkedList<SortingAlgorithmOperation>(), new LinkedList<Integer>());
			assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, testManualSorter.getArray()),
					"Test that getArray() returns the correct array from a ManualSorter instance");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing getArray() on an instance of ManualSorter; "
					+ e.getMessage());
		}
	}

	@Test
	void testEnqueueOperation() {
		String testName = "testEnqueueOperation";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			ManualSorter testManualSorter = new ManualSorter(new int[] { 1, 2, 3 },
					new LinkedList<SortingAlgorithmOperation>(), new LinkedList<Integer>());
			testManualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, 0, 1);
			testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 1);
			assertTrue(true,
					"Test that enqueueOperation() executes successfully with no exceptions on a ManualSorter instance");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing enqueueOperation() on an instance of ManualSorter; "
					+ e.getMessage());
		}
	}

	@Test
	void testSwapOperation() {
		String testName = "testSwapOperation";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			ManualSorter testManualSorter = new ManualSorter(new int[] { 1, 2 },
					new LinkedList<SortingAlgorithmOperation>(), new LinkedList<Integer>());
			assertTrue(Arrays.equals(new int[] { 1, 2 }, testManualSorter.getArray()),
					"Test that array in ManualSorter is the original array before the swap operation");
			testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 1);
			testManualSorter.step();
			assertTrue(Arrays.equals(new int[] { 2, 1 }, testManualSorter.getArray()),
					"Test that array in ManualSorter is modified after the swap operation");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing a swap operation with an instance of ManualSorter; "
					+ e.getMessage());
		}
	}

	@Test
	void testIsSorted() {
		String testName = "testIsSorted";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			ManualSorter testManualSorter = new ManualSorter(new int[] { 1, 2, 3, 5, 4, 6, 7 },
					new LinkedList<SortingAlgorithmOperation>(), new LinkedList<Integer>());
			testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 3, 4);
			assertFalse(testManualSorter.isSorted(), "Test that isSorted returns false when array is not sorted");
			testManualSorter.step();
			assertTrue(testManualSorter.isSorted(), "Test that isSorted returns true when array is sorted");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing the isSorted() method on a ManualSorter instance; "
					+ e.getMessage());
		}
	}

	@Test
	void testIsSortable() {
		String testName = "testIsSortable";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			int[] array = new int[] { 12, 23, 15, 22, 17, 6, 19, 8, 1, 3, 16, 24, 10, 7, 5, 25, 18, 13, 14, 9, 4, 20, 2,
					11, 21 };
			BubbleSort bubbleSorter = new BubbleSort(array);
			SelectionSort selectionSorter = new SelectionSort(array);

			ManualSorter testManualSorter = bubbleSorter.preComputeManualSort();
			assertEquals(454, testManualSorter.isSortable(-1),
					"Test that ManualSorter.isSortable() can verify if an array is sortable using operations generated by a BubbleSort object");
			assertEquals(-1, testManualSorter.isSortable(10),
					"Test that ManualSorter.isSortable() will return -1 when the operations limit provided is too small");
			testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 6);
			assertEquals(454, testManualSorter.isSortable(-1),
					"Test that ManualSorter.isSortable() returns the correct number of operations required to sort an array, excluding unnecessary operations");

			testManualSorter = selectionSorter.preComputeManualSort();
			assertEquals(318, testManualSorter.isSortable(-1),
					"Test that ManualSorter.isSortable() can verify if an array is sortable using operations generated by a BubbleSort object");
			assertEquals(-1, testManualSorter.isSortable(10),
					"Test that ManualSorter.isSortable() will return -1 when the operations limit provided is too small");
			testManualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, 0, 6);
			assertEquals(318, testManualSorter.isSortable(-1),
					"Test that ManualSorter.isSortable() returns the correct number of operations required to sort an array, excluding unnecessary operations");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing isSortable() on a ManualSorter instance; "
					+ e.getMessage());
		}
	}
}
