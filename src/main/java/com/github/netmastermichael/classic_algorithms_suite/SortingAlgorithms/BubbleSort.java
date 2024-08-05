package com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms;

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
/**
 * 
 */
/**
 * 
 */
public class BubbleSort implements SortingAlgorithm {

	/** Array that is currently being worked on by the sorting algorithm */
	private int[] inputArray;

	/** Quantity of comparisons that have been made during the lifetime of a sort */
	private int comparisons;

	/** Quantity of swaps that have been made during the lifetime of a sort */
	private int swaps;
	
	/** Quantity of passes that have been made during the lifetime of a sort */
	private int passes;

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
		this.comparisons = 0;
		this.swaps = 0;
		this.passes = 0;
		this.operationsDeque = new LinkedList<SortingAlgorithmOperation>();
		this.indicesDeque = new LinkedList<Integer>();
	}

	/**
	 * Returns the array currently held inside the BubbleSort object.
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
	 * Returns the number of comparisons currently recorded inside the BubbleSort
	 * object.
	 *
	 * @return Number of comparisons in BubbleSort instance
	 */
	@Override
	public int getComparisons() {
		return comparisons;
	}

	/**
	 * Returns the number of swaps currently recorded inside the BubbleSort object.
	 *
	 * @return Number of swaps in BubbleSort instance
	 */
	@Override
	public int getSwaps() {
		return swaps;
	}
	
	/**
	 * Returns the number of passes currently recorded inside the BubbleSort object.
	 * 
	 * @return Number of passes in BubbleSort instance
	 */
	@Override
	public int getPasses() {
		return passes;
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
			passes++;
			// Check each pair in the array.
			for (int i = 0; i < (iterationsRemaining - 1); i++) {
				// If the left number is larger than the right number, swap them.
				comparisons++;
				if (inputArray[i] > inputArray[i + 1]) {
					swaps++;
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

	}

	/**
	 * Sorts an isolated copy of inputArray using the bubble sort algorithm with
	 * optimisations, while inserting each operation into a deque. Actual inputArray
	 * field is not modified. Each operation can be stepped through using step().
	 */
	private void preComputeSort() {
		int[] inputArrayDuplicate = inputArray;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

}
