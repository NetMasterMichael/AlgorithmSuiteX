package com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms;

public class SortingAlgorithmMetrics {

	/** Quantity of comparisons that have been made during the lifetime of a sort */
	private int comparisons;

	/** Quantity of swaps that have been made during the lifetime of a sort */
	private int swaps;

	/** Quantity of passes that have been made during the lifetime of a sort */
	private int passes;

	public SortingAlgorithmMetrics() {
		this.comparisons = 0;
		this.swaps = 0;
		this.passes = 0;
	}

	/**
	 * Returns the number of comparisons currently recorded inside the
	 * SortingAlgorithmMetrics object.
	 *
	 * @return Number of comparisons in SortingAlgorithmMetrics instance
	 */
	public int getComparisons() {
		return comparisons;
	}

	/**
	 * Sets the number of comparisons currently recorded inside the
	 * SortingAlgorithmMetrics object.
	 * 
	 * @param newComparisons New number of comparisons in SortingAlgorithmMetrics
	 *                       instance
	 */
	public void setComparisons(int newComparisons) {
		this.comparisons = newComparisons;
	}

	/**
	 * Increment the number of comparisons currently recorded inside the
	 * SortingAlgorithmMetrics object by 1. 
	 */
	public void incrementComparisons() {
		comparisons++;
	}

	/**
	 * Returns the number of swaps currently recorded inside the
	 * SortingAlgorithmMetrics object.
	 *
	 * @return Number of swaps in SortingAlgorithmMetrics instance
	 */
	public int getSwaps() {
		return swaps;
	}

	/**
	 * Sets the number of swaps currently recorded inside the
	 * SortingAlgorithmMetrics object.
	 * 
	 * @param newSwaps New number of swaps in SortingAlgorithmMetrics instance
	 */
	public void setSwaps(int newSwaps) {
		this.swaps = newSwaps;
	}
	
	/**
	 * Increment the number of swaps currently recorded inside the
	 * SortingAlgorithmMetrics object by 1. 
	 */
	public void incrementSwaps() {
		swaps++;
	}

	/**
	 * Returns the number of passes currently recorded inside the
	 * SortingAlgorithmMetrics object.
	 * 
	 * @return Number of passes in SortingAlgorithmMetrics instance
	 */
	public int getPasses() {
		return passes;
	}

	/**
	 * Sets the number of passes currently recorded inside the
	 * SortingAlgorithmMetrics object.
	 * 
	 * @param newPasses New number of passes in SortingAlgorithmMetrics instance
	 */
	public void setPasses(int newPasses) {
		this.passes = newPasses;
	}
	
	/**
	 * Increment the number of passes currently recorded inside the
	 * SortingAlgorithmMetrics object by 1. 
	 */
	public void incrementPasses() {
		passes++;
	}
}
