package com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * BubbleSort is a class that implements the bubble sort algorithm for sorting
 * an array of integers. It implements the SortingAlgorithm interface and is
 * designed to primarily be used with a controller, but can be used
 * independently. The bubble sort algorithm is inefficient and generally
 * performs poorly compared to most other sorting algorithms, but is very simple
 * to understand and great for an introduction to algorithms.
 * <p>
 * Time Complexity Best Case: O(n)<br>
 * Conditions: Input array is already sorted, no swaps are made.
 * </p>
 * <p>
 * Time Complexity Average Case: O(n^2)
 * </p>
 * <p>
 * Time Complexity Worst Case: O(n^2)<br>
 * Conditions: Input array is in reverse order.
 * </p>
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class BubbleSort implements SortingAlgorithm {

	/** Array that is currently being worked on by the sorting algorithm */
	private int[] inputArray;

	private SortingAlgorithmMetrics metrics;

	private boolean interactiveModeEnabled;

	private Deque<SortingAlgorithmOperation> operationsDeque;

	private Deque<Integer> indicesDeque;

	/**
	 * Constructor for creating a BubbleSort object to sort an array of integers.
	 * 
	 * @param inputArray array to sort
	 */
	public BubbleSort(int[] inputArray) {
		this.inputArray = inputArray;
		reset();
	}

	private void reset() {
		this.metrics = new SortingAlgorithmMetrics();
		this.interactiveModeEnabled = false;
		this.operationsDeque = new LinkedList<SortingAlgorithmOperation>();
		this.indicesDeque = new LinkedList<Integer>();
	}

	/**
	 * Gets the array currently held inside the BubbleSort object.
	 *
	 * @return Array currently inside of BubbleSort instance
	 */
	@Override
	public int[] getInputArray() {
		return inputArray;
	}

	/**
	 * Sets the array inside the BubbleSort object to the provided array.
	 * 
	 * @param Array to set inside BubbleSort instance
	 */
	@Override
	public void setInputArray(int[] newInputArray) {
		this.inputArray = newInputArray;
		reset();
	}

	/**
	 * Gets the SortingAlgorithmMetrics object containing performance metrics from
	 * this BubbleSort object.
	 * 
	 * @return SortingAlgorithmMetrics object containing performance metrics
	 */
	@Override
	public SortingAlgorithmMetrics getMetrics() {
		return metrics;
	}

	/**
	 * Sorts the array inside inputArray using the bubble sort algorithm with
	 * optimisations. Use this method when assessing raw algorithm performance.
	 */
	@Override
	public void sort() {
		// Optimisation: If no swaps occur during a pass, end the algorithm early.
		boolean swapDuringPass;
		int buffer;
		// Optimisation: During each pass, the highest value bubbles to the end. We know
		// the highest value moved will be sorted, so there's no need to check that
		// again. Reduce number of checks each pass.
		int iterationsRemaining = inputArray.length;
		while (true) {
			swapDuringPass = false;
			// Check each pair in the array.
			for (int i = 0; i < (iterationsRemaining - 1); i++) {
				// If the left number is larger than the right number, swap them.
				if (inputArray[i] > inputArray[i + 1]) {
					buffer = inputArray[i];
					inputArray[i] = inputArray[i + 1];
					inputArray[i + 1] = buffer;
					swapDuringPass = true;
				}
			}
			// If no swaps have occurred, then the array is sorted, so break the method
			// early.
			if (!swapDuringPass) {
				break;
			}
			// Otherwise, reduce number of pairs to check and run another pass.
			iterationsRemaining--;
		}
	}

	/**
	 * Sorts the array inside inputArray using the bubble sort algorithm with
	 * optimisations, while keeping track of metrics. Use this method when assessing
	 * algorithm optimisation.
	 */
	@Override
	public void sortWithMetrics() {
		// Optimisation: If no swaps occur during a pass, end the algorithm early.
		boolean swapDuringPass;
		int buffer;
		// Optimisation: During each pass, the highest value bubbles to the end. We know
		// the highest value moved will be sorted, so there's no need to check that
		// again. Reduce number of checks each pass.
		int iterationsRemaining = inputArray.length;
		while (true) {
			swapDuringPass = false;
			metrics.incrementPasses();
			// Check each pair in the array.
			for (int i = 0; i < (iterationsRemaining - 1); i++) {
				// If the left number is larger than the right number, swap them.
				metrics.incrementComparisons();
				if (inputArray[i] > inputArray[i + 1]) {
					metrics.incrementSwaps();
					buffer = inputArray[i];
					inputArray[i] = inputArray[i + 1];
					inputArray[i + 1] = buffer;
					swapDuringPass = true;
				}
			}
			// If no swaps have occurred, then the array is sorted, so break the method
			// early.
			if (!swapDuringPass) {
				break;
			}
			// Otherwise, reduce number of pairs to check and run another pass.
			iterationsRemaining--;
		}
	}

	@Override
	public void toggleInteractiveMode() {
		if (!interactiveModeEnabled) {
			interactiveModeEnabled = true;
			preComputeSort();
		}
	}

	/**
	 * Sorts an isolated copy of inputArray using the bubble sort algorithm with
	 * optimisations, while inserting each operation into a deque. Actual inputArray
	 * field is not modified. Each operation can be stepped through using step().
	 */
	private void preComputeSort() {
		int[] inputArrayDuplicate = Arrays.copyOf(inputArray, inputArray.length);
		reset();
		boolean swapDuringPass;
		int buffer;
		int iterationsRemaining = inputArrayDuplicate.length;
		while (true) {
			swapDuringPass = false;
			// Check each pair in the array.
			for (int i = 0; i < (iterationsRemaining - 1); i++) {
				operationsDeque.addFirst(SortingAlgorithmOperation.COMPARE);
				indicesDeque.addFirst(i);
				indicesDeque.addFirst(i + 1);
				// If the left number is larger than the right number, swap them.
				if (inputArrayDuplicate[i] > inputArrayDuplicate[i + 1]) {
					operationsDeque.addFirst(SortingAlgorithmOperation.SWAP);
					indicesDeque.addFirst(i);
					indicesDeque.addFirst(i + 1);
					buffer = inputArrayDuplicate[i];
					inputArrayDuplicate[i] = inputArrayDuplicate[i + 1];
					inputArrayDuplicate[i + 1] = buffer;
					swapDuringPass = true;
				}
			}
			// If no swaps have occurred, then the array is sorted, so break the method
			// early.
			if (!swapDuringPass) {
				break;
			}
			// Otherwise, reduce number of pairs to check and run another pass.
			iterationsRemaining--;
		}
	}

	@Override
	public boolean isInteractiveModeEnabled() {
		return interactiveModeEnabled;
	}

	@Override
	public void step() {
		SortingAlgorithmOperation operation = operationsDeque.pollLast();
		switch (operation) {
		case COMPARE:
			indicesDeque.pollLast();
			indicesDeque.pollLast();
			// Return to this later; intended for displaying comparisons in a GUI
			break;
		case SWAP:
			int indexA = indicesDeque.pollLast();
			int indexB = indicesDeque.pollLast();
			int buffer = inputArray[indexA];
			inputArray[indexA] = inputArray[indexB];
			inputArray[indexB] = buffer;
			break;
		default:
			// Add exception here later
			break;
		}
	}

}
