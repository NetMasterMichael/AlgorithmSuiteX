package com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class SelectionSort implements SortingAlgorithm {

	private int[] inputArray;

	private SortingAlgorithmMetrics metrics;

	public SelectionSort(int[] inputArray) {
		this.inputArray = inputArray;
		this.metrics = new SortingAlgorithmMetrics();
	}

	@Override
	public int[] getInputArray() {
		return inputArray;
	}

	@Override
	public void setInputArray(int[] newInputArray) {
		this.inputArray = newInputArray;
		this.metrics = new SortingAlgorithmMetrics();
	}

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
	
	@Override
	public SortingAlgorithmMetrics getMetrics() {
		return metrics;
	}
	
	@Override
	public void sortWithMetrics() {
		int buffer;
		int arraylen = inputArray.length; // Small optimisation to avoid recalculating the array length
		for (int i = 0; i < arraylen - 1; i++) { // Last element will naturally be in the last position
			// Find the index of the smallest element in the unsorted subset
			int lowestIndex = i;
			for (int j = i + 1; j < arraylen; j++) { // Start from i + 1 to avoid comparing an element with itself
				metrics.incrementComparisons();
				if (inputArray[j] < inputArray[lowestIndex]) {
					lowestIndex = j;
				}
			}
			// Optimisation: We don't want to swap an element with itself if it's already in
			// the correct position
			if (lowestIndex != i) {
				metrics.incrementSwaps();
				// Swap the elements at i and lowestIndex
				buffer = inputArray[lowestIndex];
				inputArray[lowestIndex] = inputArray[i];
				inputArray[i] = buffer;
			}
			metrics.incrementPasses();
		}
	}
	
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
