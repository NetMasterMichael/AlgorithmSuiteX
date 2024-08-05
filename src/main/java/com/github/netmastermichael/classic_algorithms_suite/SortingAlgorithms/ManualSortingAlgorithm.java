package com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms;

import java.util.Deque;

public class ManualSortingAlgorithm {

	private int[] array;

	private Deque<SortingAlgorithmOperation> operationsDeque;

	private Deque<Integer> indicesDeque;

	public ManualSortingAlgorithm(int[] array, Deque<SortingAlgorithmOperation> operationsDeque, Deque<Integer> indicesDeque) {
		this.array = array;
		this.operationsDeque = operationsDeque;
		this.indicesDeque = indicesDeque;
	}
	
	public int[] getArray() {
		return this.array;
	}
	
	public void enqueueOperation(SortingAlgorithmOperation operation, int indexA, int indexB) {
		operationsDeque.addFirst(operation);
		indicesDeque.addFirst(indexA);
		indicesDeque.addFirst(indexB);
	}
	
	public boolean validateSort(int operationsLimit) {
		return false;
	}
	
	public void step() {
		SortingAlgorithmOperation operation = operationsDeque.pollLast();
		switch (operation) {
		case COMPARE:
			indicesDeque.pollLast();
			indicesDeque.pollLast();
			// Return to this later; intended for displaying comparisons in a GUI
			break;
		case SWAP:
			int indexA = indicesDeque.pollLast();
			int indexB = indicesDeque.pollLast();
			int buffer = array[indexA];
			array[indexA] = array[indexB];
			array[indexB] = buffer;
			break;
		default:
			// Add exception here later
			break;
		}
	}
}
