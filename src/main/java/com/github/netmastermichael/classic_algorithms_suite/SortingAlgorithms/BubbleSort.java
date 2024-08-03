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
	public int getComparisons() {
		return comparisons;
	}

	@Override
	public int getMoves() {
		return moves;
	}

	@Override
	public void sort() {
		boolean swapDuringPass;
		int buffer;
		int iterationsRemaining = inputArray.length;
		while (true) {
			swapDuringPass = false;
			for (int i = 0; i < (iterationsRemaining - 1); i++) {
				if (inputArray[i] > inputArray[i + 1]) {
					buffer = inputArray[i];
					inputArray[i] = inputArray[i + 1];
					inputArray[i + 1] = buffer;
					swapDuringPass = true;
				}
			}
			if (!swapDuringPass) {
				break;
			}
			iterationsRemaining--;
		}
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
