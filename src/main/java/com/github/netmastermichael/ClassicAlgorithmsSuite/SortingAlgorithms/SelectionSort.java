package com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * SelectionSort is a class that implements the selection sort algorithm for
 * sorting an array of integers. It implements the SortingAlgorithm interface
 * and is designed to primarily be used with a controller, but can be used
 * independently. The selection sort algorithm is slightly more efficient on
 * average than bubble sort since it makes far fewer swaps, but it is still
 * generally considered inefficient all-around for its quadratic time complexity
 * and poor performance in comparison to most other sorting algorithms. However,
 * like bubble sort, it is also very simple to understand and great for an
 * introduction to algorithms. Its best case time complexity is also still
 * O(n^2), due to the way it makes comparisons, even if the input array is
 * already sorted.
 * <p>
 * Time Complexity Best Case: O(n^2)
 * </p>
 * <p>
 * Time Complexity Average Case: O(n^2)
 * </p>
 * <p>
 * Time Complexity Worst Case: O(n^2)
 * </p>
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class SelectionSort implements SortingAlgorithm {

	/** Array that is currently being worked on by the sorting algorithm */
	private int[] inputArray;

	/**
	 * SortingAlgorithmMetrics object for tracking performance metrics of the
	 * algorithm
	 */
	private SortingAlgorithmMetrics metrics;

	/**
	 * Constructor for creating a SelectionSort object to sort an array of integers.
	 * 
	 * @param inputArray array to sort
	 */
	public SelectionSort(int[] inputArray) {
		this.inputArray = inputArray;
		this.metrics = new SortingAlgorithmMetrics();
	}

	/**
	 * Gets the array currently held inside the SelectionSort object.
	 *
	 * @return Array currently inside of SelectionSort instance
	 */
	@Override
	public int[] getInputArray() {
		return inputArray;
	}

	/**
	 * Sets the array inside the SelectionSort object to the provided array.
	 * 
	 * @param Array to set inside SelectionSort instance
	 */
	@Override
	public void setInputArray(int[] newInputArray) {
		this.inputArray = newInputArray;
		this.metrics = new SortingAlgorithmMetrics();
	}

	/**
	 * Sorts the array inside inputArray using the selection sort algorithm with
	 * optimisations. Use this method when assessing raw algorithm performance.
	 */
	@Override
	public void sort() {
		int buffer;
		int arraylen = inputArray.length; // Small optimisation to avoid recalculating the array length
		for (int i = 0; i < arraylen - 1; i++) { // Last element will naturally be in the last position
			// Find the index of the smallest element in the unsorted subset
			int lowestIndex = i;
			for (int j = i + 1; j < arraylen; j++) { // Start from i + 1 to avoid comparing an element with itself
				if (inputArray[j] < inputArray[lowestIndex]) {
					lowestIndex = j;
				}
			}
			// Optimisation: We don't want to swap an element with itself if it's already in
			// the correct position
			if (lowestIndex != i) {
				// Swap the elements at i and lowestIndex
				buffer = inputArray[lowestIndex];
				inputArray[lowestIndex] = inputArray[i];
				inputArray[i] = buffer;
			}
		}
	}

	/**
	 * Gets the SortingAlgorithmMetrics object containing performance metrics from
	 * this SelectionSort object.
	 * 
	 * @return SortingAlgorithmMetrics object containing performance metrics
	 */
	@Override
	public SortingAlgorithmMetrics getMetrics() {
		return metrics;
	}

	/**
	 * Sorts the array inside inputArray using the selection sort algorithm, while
	 * keeping track of metrics. Use this method when assessing algorithm
	 * optimisation.
	 */
	@Override
	public void sortWithMetrics() {
		int buffer;
		int arraylen = inputArray.length; // Small optimisation to avoid recalculating the array length
		for (int i = 0; i < arraylen - 1; i++) { // Last element will naturally be in the last position
			// Find the index of the smallest element in the unsorted subset
			int lowestIndex = i;
			for (int j = i + 1; j < arraylen; j++) { // Start from i + 1 to avoid comparing an element with itself
				metrics.incrementComparisons();
				metrics.increaseArrayAccesses(2);
				if (inputArray[j] < inputArray[lowestIndex]) {
					lowestIndex = j;
				}
			}
			// Optimisation: We don't want to swap an element with itself if it's already in
			// the correct position
			if (lowestIndex != i) {
				metrics.incrementSwaps();
				metrics.increaseArrayAccesses(4);
				// Swap the elements at i and lowestIndex
				buffer = inputArray[lowestIndex];
				inputArray[lowestIndex] = inputArray[i];
				inputArray[i] = buffer;
			}
			metrics.incrementPasses();
		}
	}

	/**
	 * Creates a separate instance of this algorithm as a ManualSorter object with
	 * an independent copy of inputArray, which will be able to sort the array by
	 * stepping through a queue of operations that correspond with the selection
	 * sort algorithm.
	 * 
	 * @return ManualSorter object queued with operations of selection sort
	 *         algorithm
	 */
	@Override
	public ManualSorter preComputeManualSort() {
		ManualSorter manualSorter = new ManualSorter(Arrays.copyOf(inputArray, inputArray.length),
				new LinkedList<SortingAlgorithmOperation>(), new LinkedList<Integer>());
		int[] inputArrayDuplicate = Arrays.copyOf(inputArray, inputArray.length);
		int buffer;
		int arraylen = inputArrayDuplicate.length; // Small optimisation to avoid recalculating the array length
		for (int i = 0; i < arraylen - 1; i++) { // Last element will naturally be in the last position
			// Find the index of the smallest element in the unsorted subset
			int lowestIndex = i;
			for (int j = i + 1; j < arraylen; j++) { // Start from i + 1 to avoid comparing an element with itself
				manualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, j, lowestIndex);
				if (inputArrayDuplicate[j] < inputArrayDuplicate[lowestIndex]) {
					lowestIndex = j;
				}
			}
			// Optimisation: We don't want to swap an element with itself if it's already in
			// the correct position
			if (lowestIndex != i) {
				// Swap the elements at i and lowestIndex
				manualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, i, lowestIndex);
				buffer = inputArrayDuplicate[lowestIndex];
				inputArrayDuplicate[lowestIndex] = inputArrayDuplicate[i];
				inputArrayDuplicate[i] = buffer;
			}
		}
		return manualSorter;
	}
}
