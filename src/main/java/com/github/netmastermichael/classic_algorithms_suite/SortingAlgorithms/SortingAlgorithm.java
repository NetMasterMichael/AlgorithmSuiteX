package com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms;

/**
 * SortingAlgorithm is an interface that will be implemented by all sorting algorithms.
 * This allows a controller to universally call methods for all of them.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public interface SortingAlgorithm {
	
	
	/**
	 * Gets the input array from the object. This may be unsorted, partially sorted, or fully sorted.
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
	 * Gets the number of comparisons from the object. This will only increase if sortWithMetrics() or interactive mode is used.
	 * If sort() is called, comparisons will stay at zero.
	 * 
	 * @return number of comparisons
	 */
	int getComparisons();
	
	
	/**
	 * Gets the number of moves from the object. This will only increase if sortWithMetrics() or interactive mode is used.
	 * If sort() is called, moves will stay at zero.
	 * 
	 * @return number of moves
	 */
	int getMoves();
	
	/**
	 * Sorts an input array using the specified sorting algorithm.
	 */
	void sort();
	
	/*
	 * Sorts an input array using the specified sorting algorithm while keeping track of metrics, such as the number of comparisons and moves performed.
	 * Performance may be slightly impacted in this mode.
	 */
	void sortWithMetrics();
	
	/*
	 * Toggles interactive mode, allowing a user to step through the algorithm.
	 */
	void toggleInteractiveMode();
	
	/**
	 * Check if interactive mode is currently enabled.
	 * 
	 * @return true if interactive mode is currently enabled, otherwise false
	 */
	boolean isInteractiveModeEnabled();

	/*
	 * Make one step through the sorting algorithm.
	 */
	void step();
	
	/**
	 * Check if a given array is sorted.
	 * 
	 * @param array array to check is sorted
	 * @return true if array is sorted, otherwise false
	 */
	default boolean isSorted() {
		int[] array = this.getInputArray();
		for (int i = 0; i < (array.length - 1); i++) {
			if (array[i] > array[i + 1]) 
				return false;
		}
		return true;
	}
}
