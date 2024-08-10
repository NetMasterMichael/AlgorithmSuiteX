import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.InsertionSort;

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

}
