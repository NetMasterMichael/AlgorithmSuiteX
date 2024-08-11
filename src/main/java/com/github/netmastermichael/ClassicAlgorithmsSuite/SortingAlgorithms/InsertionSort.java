package com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertionSort implements SortingAlgorithm {

	private int[] inputArray;

	private SortingAlgorithmMetrics metrics;

	public InsertionSort(int[] inputArray) {
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
	}

	@Override
	public SortingAlgorithmMetrics getMetrics() {
		return metrics;
	}

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

	@Override
	public void sortWithMetrics() {
		int arrayLength = inputArray.length;
		for (int i = 1; i < arrayLength; i++) {
			int buffer = inputArray[i];
			int j = i - 1;

			// While value at j'th index is less than buffer, move each j'th index forward
			// by one
			while (j >= 0 && inputArray[j] > buffer) {
				metrics.incrementComparisons();
				inputArray[j + 1] = inputArray[j];
				metrics.incrementSwaps();
				j--;
			}

			// Count comparison after exiting the while loop
			metrics.incrementComparisons();

			inputArray[j + 1] = buffer;
			metrics.incrementPasses();
		}
	}

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
