package com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ManualSorter is an object used for manually and interactively sorting an
 * array with a given sorting algorithm. ManualSorter is designed to be generic,
 * meaning any sorting algorithm can populate a ManualSorter object with its own
 * operations, and ManualSorter will follow the operations in the order given to
 * reproduce the original sorting algorithm. Each operation can be queued using
 * enqueueOperation() and each operation can be executed using step().
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class ManualSorter {

	/** Array that is currently being worked on by the manual sorter */
	private int[] array;

	/** Deque for holding the operations provided by a sorting algorithm */
	private Deque<SortingAlgorithmOperation> operationsDeque;

	/** Deque for holding the indices corresponding to operations */
	private Deque<Integer> indicesDeque;

	/**
	 * Constructor for creating a ManualSorter object for executing operations on an
	 * array of integers.
	 * 
	 * @param array           Array of integers to be sorted
	 * @param operationsDeque Deque of operations to perform on array. Can be
	 *                        provided as pre-populated, or provided as empty and
	 *                        then populated afterwards using enqueueOperation()
	 * @param indicesDeque    Deque of indices in the array to be operated on. Can
	 *                        be provided as pre-populated, or provided as empty and
	 *                        then populated afterwards using enqueueOperation()
	 */
	public ManualSorter(int[] array, Deque<SortingAlgorithmOperation> operationsDeque, Deque<Integer> indicesDeque) {
		this.array = array;
		if (operationsDeque != null) {
			this.operationsDeque = operationsDeque;
		} else {
			this.operationsDeque = new LinkedList<SortingAlgorithmOperation>();
		}
		if (indicesDeque != null) {
			this.indicesDeque = indicesDeque;
		} else {
			this.indicesDeque = new LinkedList<Integer>();
		}
	}

	/**
	 * Gets the array currently held inside the ManualSorter object.
	 * 
	 * @return Array currently held inside ManualSorter
	 */
	public int[] getArray() {
		return this.array;
	}

	/**
	 * Enqueue an operation and its corresponding indices on the array into the
	 * operationsDeque and indicesDeque for later execution by step().
	 * 
	 * @param operation Operation to perform from the SortingAlgorithmOperation enum
	 * @param indexA    First index of array
	 * @param indexB    Second index of array
	 */
	public void enqueueOperation(SortingAlgorithmOperation operation, int indexA, int indexB) {
		operationsDeque.addFirst(operation);
		indicesDeque.addFirst(indexA);
		indicesDeque.addFirst(indexB);
	}

	/**
	 * Validate that the current array can be sorted within a given quantity of
	 * operations, solely by following the operations that have been queued. Does
	 * not modify the original array or deques.
	 * 
	 * @param operationsLimit Maximum number of operations before returning false.
	 *                        To validate until the deques are fully depleted, pass
	 *                        -1 into this parameter.
	 * @return Number of operations executed until the array is sorted. If the array
	 *         cannot be sorted, -1 is returned.
	 */
	public int isSortable(int operationsLimit) {
		// Make clones of all the parameters
		int[] arrayCopy = Arrays.copyOf(array, array.length);
		Deque<SortingAlgorithmOperation> operationsDequeCopy = new LinkedList<>(operationsDeque);
		Deque<Integer> indicesDequeCopy = new LinkedList<>(indicesDeque);
		ManualSorter validator = new ManualSorter(arrayCopy, operationsDequeCopy, indicesDequeCopy);

		int operationsCount = 0;
		while (!operationsDequeCopy.isEmpty() && (operationsLimit == -1 || operationsCount < operationsLimit)) {
			validator.step();
			if (validator.isSorted()) {
				return operationsCount;
			}
			operationsCount++;
		}
		return -1;
	}

	/**
	 * Check if the array is sorted.
	 * 
	 * @return true if array is sorted, otherwise false
	 */
	public boolean isSorted() {
		for (int i = 0; i < (array.length - 1); i++) {
			if (array[i] > array[i + 1]) {
				// If any pair is found where the left number is larger than the right number,
				// the array isn't currently sorted, so return false
				return false;
			}
		}
		// No pairs are out of order, so array is sorted
		return true;
	}

	/**
	 * Executes the operation at the bottom of operationsDeque on the array.
	 * 
	 * @return True if operation was executed successfully, false if the step was
	 */
	public boolean step() {
		SortingAlgorithmOperation operation = operationsDeque.pollLast();
		switch (operation) {
		case COMPARE:
			// Return to this later; intended for displaying comparisons in a GUI
			indicesDeque.pollLast();
			indicesDeque.pollLast();
			return true;
		case SWAP:
			int indexA = indicesDeque.pollLast();
			int indexB = indicesDeque.pollLast();
			int buffer = array[indexA];
			array[indexA] = array[indexB];
			array[indexB] = buffer;
			return true;
		default:
			// Add exception here later
			return false;
		}
	}
}
