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

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
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
