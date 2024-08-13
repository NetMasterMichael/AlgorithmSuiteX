package com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms;

public class MergeSort implements SortingAlgorithm {

	private int[] inputArray;

	private SortingAlgorithmMetrics metrics;

	public MergeSort(int[] inputArray) {
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

	// Wrapper method for mergeSort()
	@Override
	public void sort() {
		mergeSort(0, inputArray.length - 1);
	}

	private void mergeSort(int left, int right) {
		if (left < right) {
			// Find the midpoint in the array
			int midpoint = (left + right) / 2;

			// Call mergeSort() on the first and second halves
			mergeSort(left, midpoint);
			mergeSort(midpoint + 1, right);

			// Merge the sorted halves
			merge(left, midpoint, right);
		}
	}

	private void merge(int left, int midpoint, int right) {
		// Find size of two subarrays to be merged
		int leftArraySize = midpoint - left + 1;
		int rightArraySize = right - midpoint;

		// Create temporary arrays
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		// Copy corresponding values from inputArray to temporary arrays
		for (int i = 0; i < leftArraySize; i++) {
			leftArray[i] = inputArray[left + i];
		}
		for (int i = 0; i < rightArraySize; i++) {
			rightArray[i] = inputArray[midpoint + i + 1];
		}

		// Merge the arrays into one and sort at the same time
		int leftIndex = 0;
		int rightIndex = 0;
		int targetIndex = left;

		while (leftIndex < leftArraySize && rightIndex < rightArraySize) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				inputArray[targetIndex] = leftArray[leftIndex];
				leftIndex++;
			} else {
				inputArray[targetIndex] = rightArray[rightIndex];
				rightIndex++;
			}
			targetIndex++;
		}

		// Arrays are now merged but there may be leftover values in the temporary
		// arrays, so copy them to inputArray
		while (leftIndex < leftArraySize) {
			inputArray[targetIndex] = leftArray[leftIndex];
			leftIndex++;
			targetIndex++;
		}
		while (rightIndex < rightArraySize) {
			inputArray[targetIndex] = rightArray[rightIndex];
			rightIndex++;
			targetIndex++;
		}
	}

	@Override
	public void sortWithMetrics() {
		// TODO Auto-generated method stub

	}

	@Override
	public ManualSorter preComputeManualSort() {
		// TODO Auto-generated method stub
		return null;
	}

}
