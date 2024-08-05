package com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms;

/**
 * SortingAlgorithm is an interface that will be implemented by all sorting
 * algorithms. This allows a controller to universally call methods for all of
 * them.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public interface SortingAlgorithm {

	/**
	 * Gets the input array from the object. This may be unsorted, partially sorted,
	 * or fully sorted.
	 * 
	 * @return the input array
	 */
	int[] getInputArray();

	/**
	 * Sets a new input array to be sorted.
	 * 
	 * @param newInputArray the new input array
	 */
	void setInputArray(int[] newInputArray);

	/**
	 * Gets the SortingAlgorithmMetrics object containing performance metrics from
	 * the SortingAlgorithm object.
	 * 
	 * @return SortingAlgorithmMetrics object containing performance metrics
	 */
	SortingAlgorithmMetrics getMetrics();

	/**
	 * Sorts an input array using the specified sorting algorithm.
	 */
	void sort();

	/*
	 * Sorts an input array using the specified sorting algorithm while keeping
	 * track of metrics, such as the number of comparisons and swaps performed.
	 * Performance may be slightly impacted in this mode.
	 */
	void sortWithMetrics();

	/*
	 * Toggles manual mode, allowing a user to step through the algorithm.
	 */
	void toggleManualMode();

	/**
	 * Check if manual mode is currently enabled.
	 * 
	 * @return true if manual mode is currently enabled, otherwise false
	 */
	boolean isManualModeEnabled();

	/**
	 * Check if the input array is sorted.
	 * 
	 * @return true if array is sorted, otherwise false
	 */
	default boolean isSorted() {
		int[] array = this.getInputArray();
		// Check that for all pairs in an array, the left number is smaller than the
		// right number
		for (int i = 0; i < (array.length - 1); i++) {
			if (array[i] > array[i + 1]) {
				// If any pair is found where the left number is larger than the right number,
				// the array isn't currently sorted, so return false
				return false;
			}
		}
		// All pairs are ordered correctly, so array is sorted
		return true;
	}
}
