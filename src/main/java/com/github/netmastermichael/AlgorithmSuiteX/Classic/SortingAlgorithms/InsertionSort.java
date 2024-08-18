package com.github.netmastermichael.AlgorithmSuiteX.Classic.SortingAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * InsertionSort is a class that implements the insertion sort algorithm for
 * sorting an array of integers. It implements the SortingAlgorithm interface
 * and is designed to primarily be used with a controller, but can be used
 * independently.
 * <p>
 * Time Complexity Best Case: O(n)<br>
 * </p>
 * <p>
 * Time Complexity Average Case: O(n^2)
 * </p>
 * <p>
 * Time Complexity Worst Case: O(n^2)<br>
 * </p>
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class InsertionSort implements SortingAlgorithm {

	/** Array that is currently being worked on by the sorting algorithm */
	private int[] inputArray;

	/** SortingAlgorithmMetrics object for tracking metrics of the algorithm */
	private SortingAlgorithmMetrics metrics;

	/**
	 * Constructor for creating a InsertionSort object to sort an array of integers.
	 * 
	 * @param inputArray array to sort
	 */
	public InsertionSort(int[] inputArray) {
		this.inputArray = inputArray;
		this.metrics = new SortingAlgorithmMetrics();
	}

	/**
	 * Gets the array currently held inside the InsertionSort object.
	 *
	 * @return Array currently inside of InsertionSort instance
	 */
	@Override
	public int[] getInputArray() {
		return inputArray;
	}

	/**
	 * Sets the array inside the InsertionSort object to the provided array.
	 * 
	 * @param Array to set inside InsertionSort instance
	 */
	@Override
	public void setInputArray(int[] newInputArray) {
		this.inputArray = newInputArray;
	}

	/**
	 * Gets the SortingAlgorithmMetrics object containing performance metrics from
	 * this InsertionSort object.
	 * 
	 * @return SortingAlgorithmMetrics object containing performance metrics
	 */
	@Override
	public SortingAlgorithmMetrics getMetrics() {
		return metrics;
	}

	/**
	 * Sorts the array inside inputArray using the insertion sort algorithm with
	 * optimisations. Use this method when assessing raw algorithm performance.
	 */
	@Override
	public void sort() {
		int arrayLength = inputArray.length;
		for (int i = 1; i < arrayLength; i++) {
			int buffer = inputArray[i];
			int j = i - 1;

			// While value at j'th index is less than buffer, move each j'th index forward
			// by one
			while (j >= 0 && inputArray[j] > buffer) {
				inputArray[j + 1] = inputArray[j];
				j--;
			}
			inputArray[j + 1] = buffer;
		}
	}

	/**
	 * Sorts the array inside inputArray using the insertion sort algorithm with
	 * optimisations, while keeping track of metrics. Use this method when assessing
	 * algorithm optimisation.
	 */
	@Override
	public void sortWithMetrics() {
		int arrayLength = inputArray.length;
		// For loop has been converted into a while loop for more accurate comparisons
		// tracking
		int i = 1;
		while (true) {
			metrics.incrementComparisons();
			if (!(i < arrayLength)) {
				break;
			}

			int buffer = inputArray[i];
			metrics.increaseArrayAccesses(1);
			int j = i - 1;

			// While value at j'th index is less than buffer, move each j'th index forward
			// by one
			while (true) {
				metrics.increaseComparisons(2);
				metrics.increaseArrayAccesses(1);
				if (!(j >= 0 && inputArray[j] > buffer)) {
					break;
				}
				inputArray[j + 1] = inputArray[j];
				metrics.increaseArrayAccesses(2); // One access during condition, two accesses on line above
				metrics.incrementSwaps();
				j--;
			}

			inputArray[j + 1] = buffer;
			metrics.increaseArrayAccesses(1);
			metrics.incrementPasses();
			i++;
		}
	}

	/**
	 * Creates a separate instance of this algorithm as a ManualSorter object with
	 * an independent copy of inputArray, which will be able to sort the array by
	 * stepping through a queue of operations that correspond with the insertion
	 * sort algorithm.
	 * 
	 * @return ManualSorter object queued with operations of insertion sort
	 *         algorithm
	 */
	@Override
	public ManualSorter preComputeManualSort() {
		ManualSorter manualSorter = new ManualSorter(Arrays.copyOf(inputArray, inputArray.length),
				new LinkedList<SortingAlgorithmOperation>(), new LinkedList<Integer>());
		int[] inputArrayDuplicate = (Arrays.copyOf(inputArray, inputArray.length));

		int arrayLength = inputArrayDuplicate.length;
		for (int i = 1; i < arrayLength; i++) {
			int buffer = inputArrayDuplicate[i];
			int j = i - 1;

			// While value at j'th index is less than buffer, move each j'th index forward
			// by one
			while (j >= 0 && inputArrayDuplicate[j] > buffer) {
				manualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, j, i);
				manualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, j, j + 1);
				inputArrayDuplicate[j + 1] = inputArrayDuplicate[j];
				j--;
			}
			inputArrayDuplicate[j + 1] = buffer;
		}
		return manualSorter;
	}

}
