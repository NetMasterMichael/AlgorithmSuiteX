package com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms;

public class BubbleSort implements SortingAlgorithm {

	private int[] inputArray;
	private int comparisons;
	private int moves;

	public BubbleSort(int[] inputArray) {
		this.inputArray = inputArray;
		this.comparisons = 0;
		this.moves = 0;
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
	public void sort() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sortWithMetrics() {
		// TODO Auto-generated method stub

	}

	@Override
	public void toggleInteractiveMode() {
		// TODO Auto-generated method stub

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
