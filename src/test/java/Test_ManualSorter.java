import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.ManualSorter;
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
}
