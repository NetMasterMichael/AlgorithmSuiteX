package com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting;

import java.util.Arrays;

/**
 * InsertionSort is a class that implements the insertion sort algorithm for sorting an array of
 * integers. It implements the SortingAlgorithm interface and is designed to primarily be used with
 * a controller, but can be used independently.
 * <p>
 * Time Complexity Best Case: O(n)<br>
 * </p>
 * <p>
 * Time Complexity Average Case: O(n^2)
 * </p>
 * <p>
 * Time Complexity Worst Case: O(n^2)<br>
 * </p>
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class InsertionSort implements SortingAlgorithm {

  /** Array that is currently being worked on by the sorting algorithm. */
  private int[] mainArray;

  /** SortingAlgorithmMetrics object for tracking metrics of the algorithm. */
  private SortingAlgorithmMetrics metrics;

  /**
   * Constructor for creating a InsertionSort object to sort an array of integers.
   * 
   * @param inputArray Array to initialise into mainArray for sorting
   */
  public InsertionSort(int[] inputArray) {
    setMainArray(inputArray);
  }

  /**
   * Gets the array currently held inside the InsertionSort object.
   *
   * @return Array currently inside of InsertionSort instance
   */
  @Override
  public int[] getMainArray() {
    return mainArray;
  }

  /**
   * Sets the array inside the InsertionSort object to the provided array.
   * 
   * @param inputArray New array to initialise into mainArray for sorting
   */
  @Override
  public void setMainArray(int[] inputArray) {
    if (inputArray == null) {
      this.mainArray = new int[] {};
    } else {
      this.mainArray = inputArray;
    }
    this.metrics = new SortingAlgorithmMetrics();
  }

  /**
   * Gets the SortingAlgorithmMetrics object containing performance metrics from this InsertionSort
   * object.
   * 
   * @return SortingAlgorithmMetrics object containing performance metrics
   */
  @Override
  public SortingAlgorithmMetrics getMetrics() {
    return metrics;
  }

  /**
   * Sorts the array inside mainArray using the insertion sort algorithm with optimisations. Use
   * this method when assessing raw algorithm performance.
   */
  @Override
  public void sort() {
    int arrayLength = mainArray.length;
    for (int i = 1; i < arrayLength; i++) {
      int buffer = mainArray[i];
      int j = i - 1;

      // While value at j'th index is less than buffer, move each j'th index forward
      // by one
      while (j >= 0 && mainArray[j] > buffer) {
        mainArray[j + 1] = mainArray[j];
        j--;
      }
      mainArray[j + 1] = buffer;
    }
  }

  /**
   * Sorts the array inside mainArray using the insertion sort algorithm with optimisations, while
   * keeping track of metrics. Use this method when assessing algorithm optimisation.
   */
  @Override
  public void sortWithMetrics() {
    int arrayLength = mainArray.length;
    // For loop has been converted into a while loop for more accurate comparisons
    // tracking
    int i = 1;
    while (true) {
      metrics.incrementComparisons();
      if (!(i < arrayLength)) {
        break;
      }

      int buffer = mainArray[i];
      metrics.increaseArrayAccesses(1);
      int j = i - 1;

      // While value at j'th index is less than buffer, move each j'th index forward
      // by one
      while (true) {
        metrics.increaseComparisons(2);
        metrics.increaseArrayAccesses(1);
        if (!(j >= 0 && mainArray[j] > buffer)) {
          break;
        }
        mainArray[j + 1] = mainArray[j];
        metrics.increaseArrayAccesses(2); // One access during condition, two accesses on line above
        metrics.incrementSwaps();
        j--;
      }

      mainArray[j + 1] = buffer;
      metrics.increaseArrayAccesses(1);
      metrics.incrementPasses();
      i++;
    }
  }

  /**
   * Creates a separate instance of this algorithm as a ManualSorter object with an independent copy
   * of mainArray, which will be able to sort the array by stepping through a queue of operations
   * that correspond with the insertion sort algorithm.
   * 
   * @return ManualSorter object queued with operations of insertion sort algorithm
   */
  @Override
  public ManualSorter preComputeManualSort() {
    ManualSorter manualSorter = new ManualSorter(Arrays.copyOf(mainArray, mainArray.length));
    int[] mainArrayDuplicate = (Arrays.copyOf(mainArray, mainArray.length));

    int arrayLength = mainArrayDuplicate.length;
    for (int i = 1; i < arrayLength; i++) {
      int buffer = mainArrayDuplicate[i];
      int j = i - 1;

      // While value at j'th index is less than buffer, move each j'th index forward
      // by one
      while (j >= 0 && mainArrayDuplicate[j] > buffer) {
        manualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, j, i);
        manualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, j, j + 1);
        mainArrayDuplicate[j + 1] = mainArrayDuplicate[j];
        j--;
      }
      mainArrayDuplicate[j + 1] = buffer;
    }
    return manualSorter;
  }

}
