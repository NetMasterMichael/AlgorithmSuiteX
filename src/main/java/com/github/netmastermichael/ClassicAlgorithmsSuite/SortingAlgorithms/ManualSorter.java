package com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * ManualSorter is an object used for manually and interactively sorting an
 * array with a given sorting algorithm. ManualSorter is designed to be generic,
 * meaning any sorting algorithm can populate a ManualSorter object with its own
 * operations, and ManualSorter will follow the operations in the order given to
 * reproduce the original sorting algorithm. Each operation can be queued using
 * enqueueOperation() and each operation can be executed using step().
 * 
 * ManualSorter supports working on multiple temporary arrays. If you are using
 * temporary arrays, you must first set usingTemporaryArrays to true by calling
 * sorter.setUsingTemporaryArraysStatus(true), then call the enqueueOperation()
 * method with 4 arguments instead of 3. The 4th argument will be the array
 * number to perform the operation on. If the 4th argument is 0, the operation
 * will be performed on the default array.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class ManualSorter {

	/** Array that is currently being worked on by the manual sorter */
	private int[] array;

	/** Left index of most recent operation executed by the manual sorter */
	private int currentIndexA;

	/** Right index of most recent operation executed by the manual sorter */
	private int currentIndexB;

	/** Type of most recent operation executed by the manual sorter */
	private SortingAlgorithmOperation currentOperationType;

	/** Deque for holding the operations provided by a sorting algorithm */
	private Deque<SortingAlgorithmOperation> operationsDeque;

	/** Deque for holding the indices corresponding to operations */
	private Deque<Integer> indicesDeque;

	/** Flag for whether temporary arrays are in use or not */
	private boolean usingTemporaryArrays;

	/** Hash map for holding temporary arrays */
	private HashMap<Integer, int[]> temporaryArrays;

	/**
	 * Deque for holding the index of the temporary array to perform the operation
	 * on
	 */
	private Deque<Integer> arrayIndexDeque;

	/**
	 * Constructor for creating a ManualSorter object for executing operations on an
	 * array of integers.
	 * 
	 * @param array Array of integers to be sorted
	 */
	public ManualSorter(int[] array) {
		this.array = array;
		this.operationsDeque = new LinkedList<SortingAlgorithmOperation>();
		this.indicesDeque = new LinkedList<Integer>();
		this.currentIndexA = -1;
		this.currentIndexB = -1;
		this.currentOperationType = null;

		this.usingTemporaryArrays = false;
		this.temporaryArrays = new HashMap<Integer, int[]>();
		this.arrayIndexDeque = new LinkedList<Integer>();
	}

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
		this.currentIndexA = -1;
		this.currentIndexB = -1;
		this.currentOperationType = null;

		this.usingTemporaryArrays = false;
		this.temporaryArrays = new HashMap<Integer, int[]>();
		this.arrayIndexDeque = new LinkedList<Integer>();
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
	 * Gets the value currently held inside the currentIndexA field of the
	 * ManualSorter object. Intended for use in a user interface.
	 * 
	 * @return Left index value of most recent performed operation
	 */
	public int getCurrentIndexA() {
		return currentIndexA;
	}

	/**
	 * Gets the value currently held inside the currentIndexB field of the
	 * ManualSorter object. Intended for use in a user interface.
	 * 
	 * @return Right index value of most recent performed operation
	 */
	public int getCurrentIndexB() {
		return currentIndexB;
	}

	/**
	 * Gets the type of SortingAlgorithmOperation of the most recent operation
	 * performed in the ManualSorter object. Intended for use in a user interface.
	 * 
	 * @return Type of most recent performed operation
	 */
	public SortingAlgorithmOperation getCurrentOperationType() {
		return currentOperationType;
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
	 * Enqueue an operation and its corresponding indices on the array into the
	 * operationsDeque, indicesDeque and arrayIndexDeque for later execution by
	 * step().
	 * 
	 * @param operation     Operation to perform from the SortingAlgorithmOperation
	 *                      enum
	 * @param indexA        First index of array
	 * @param indexB        Second index of array
	 * @param selectedArray Array to perform operation on
	 */
	public void enqueueOperation(SortingAlgorithmOperation operation, int indexA, int indexB, int selectedArray) {
		operationsDeque.addFirst(operation);
		indicesDeque.addFirst(indexA);
		indicesDeque.addFirst(indexB);
		arrayIndexDeque.addFirst(selectedArray);
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
			// Step through the next operation
			// If false is returned by step() then an error has occurred, so return -1
			// immediately
			if (!validator.step()) {
				return -1;
			}
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
	 *         not
	 */
	public boolean step() {
		try {
			currentOperationType = operationsDeque.removeLast();
			// If temporary arrays are not in use, just operate on the main array
			if (!usingTemporaryArrays) {
				switch (currentOperationType) {
				case COMPARE:
					currentIndexA = indicesDeque.removeLast();
					currentIndexB = indicesDeque.removeLast();
					return true;
				case SWAP:
					currentIndexA = indicesDeque.removeLast();
					currentIndexB = indicesDeque.removeLast();
					int buffer = array[currentIndexA];
					array[currentIndexA] = array[currentIndexB];
					array[currentIndexB] = buffer;
					return true;
				default:
					return false;
				}
			} else { // Otherwise, support temporary array options
				int selectedArray = arrayIndexDeque.removeLast();
				switch (currentOperationType) {
				case COMPARE:
					currentIndexA = indicesDeque.removeLast();
					currentIndexB = indicesDeque.removeLast();
					return true;
				case SWAP:
					currentIndexA = indicesDeque.removeLast();
					currentIndexB = indicesDeque.removeLast();
					if (selectedArray == 0) {
						int buffer = array[currentIndexA];
						array[currentIndexA] = array[currentIndexB];
						array[currentIndexB] = buffer;
					} else {
						int[] tempArray = temporaryArrays.get(selectedArray);
						int buffer = tempArray[currentIndexA];
						tempArray[currentIndexA] = tempArray[currentIndexB];
						tempArray[currentIndexB] = buffer;
						temporaryArrays.put(selectedArray, tempArray);
					}
					return true;
				default:
					return false;
				}
			}
		} catch (NoSuchElementException nsee) {
			return false;
		}
	}

	/**
	 * Gets the status of usingTemporaryArrays currently held inside this object.
	 * 
	 * @return True if temporary arrays are enabled, otherwise false
	 */
	public boolean getUsingTemporaryArraysStatus() {
		return usingTemporaryArrays;
	}

	/**
	 * Sets the status of usingTemporaryArrays currently held inside this object.
	 * 
	 * @param newUsingTemporaryArrays True to enable temporary arrays, false to
	 *                                disable temporary arrays
	 */
	public void setUsingTemporaryArraysStatus(boolean newUsingTemporaryArrays) {
		this.usingTemporaryArrays = newUsingTemporaryArrays;
	}
}
