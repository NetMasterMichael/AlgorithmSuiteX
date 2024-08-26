package com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting;

import java.util.Arrays;

/**
 * BubbleSort is a class that implements the bubble sort algorithm for sorting an array of integers.
 * It implements the SortingAlgorithm interface and is designed to primarily be used with a
 * controller, but can be used independently. The bubble sort algorithm is inefficient and generally
 * performs poorly compared to most other sorting algorithms, but is very simple to understand and
 * great for an introduction to algorithms.
 * <p>
 * Time Complexity Best Case: O(n)<br>
 * Conditions: Input array is already sorted, no swaps are made.
 * </p>
 * <p>
 * Time Complexity Average Case: O(n^2)
 * </p>
 * <p>
 * Time Complexity Worst Case: O(n^2)<br>
 * Conditions: Input array is in reverse order.
 * </p>
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class BubbleSort implements SortingAlgorithm {
  
  /** The type of sorting algorithm implemented in this class. */
  public final SortingAlgorithmType algorithmType = SortingAlgorithmType.BUBBLE_SORT;

  /** Array that is currently being worked on by the sorting algorithm. */
  private int[] mainArray;

  /**
   * SortingAlgorithmMetrics object for tracking performance metrics of the algorithm.
   */
  private SortingAlgorithmMetrics metrics;

  /**
   * Constructor for creating a BubbleSort object to sort an array of integers.
   * 
   * @param inputArray Array to initialise into mainArray for sorting
   */
  public BubbleSort(int[] inputArray) {
    setMainArray(inputArray);
  }

  /**
   * Gets the array currently held inside the BubbleSort object.
   *
   * @return Array currently inside of BubbleSort instance
   */
  @Override
  public int[] getMainArray() {
    return mainArray;
  }

  /**
   * Sets the array inside the BubbleSort object to the provided array.
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
   * Gets the SortingAlgorithmMetrics object containing performance metrics from this BubbleSort
   * object.
   * 
   * @return SortingAlgorithmMetrics object containing performance metrics
   */
  @Override
  public SortingAlgorithmMetrics getMetrics() {
    return metrics;
  }

  /**
   * Sorts the array inside mainArray using the bubble sort algorithm with optimisations. Use this
   * method when assessing raw algorithm performance.
   */
  @Override
  public void sort() {
    // Optimisation: If no swaps occur during a pass, end the algorithm early.
    boolean swapDuringPass;
    int buffer;
    // Optimisation: During each pass, the highest value bubbles to the end. We know
    // the highest value moved will be sorted, so there's no need to check that
    // again. Reduce number of checks each pass.
    int indicesRemaining = mainArray.length;
    while (true) {
      swapDuringPass = false;
      // Check each pair in the array.
      for (int i = 0; i < (indicesRemaining - 1); i++) {
        // If the left number is larger than the right number, swap them.
        if (mainArray[i] > mainArray[i + 1]) {
          buffer = mainArray[i];
          mainArray[i] = mainArray[i + 1];
          mainArray[i + 1] = buffer;
          swapDuringPass = true;
        }
      }
      // If no swaps have occurred, then the array is sorted, so break the method
      // early.
      if (!swapDuringPass) {
        break;
      }
      // Otherwise, reduce number of pairs to check and run another pass.
      indicesRemaining--;
    }
  }

  /**
   * Sorts the array inside mainArray using the bubble sort algorithm with optimisations, while
   * keeping track of metrics. Use this method when assessing algorithm optimisation.
   */
  @Override
  public void sortWithMetrics() {
    // Optimisation: If no swaps occur during a pass, end the algorithm early.
    boolean swapDuringPass;
    int buffer;
    // Optimisation: During each pass, the highest value bubbles to the end. We know
    // the highest value moved will be sorted, so there's no need to check that
    // again. Reduce number of checks each pass.
    int indicesRemaining = mainArray.length;
    while (true) {
      swapDuringPass = false;
      metrics.incrementPasses();
      // Check each pair in the array.
      // For loop is converted to a while loop for more precise comparisons tracking
      int i = 0;
      while (true) {
        metrics.incrementComparisons();
        if (!(i < (indicesRemaining - 1))) {
          break;
        }
        // If the left number is larger than the right number, swap them.
        metrics.incrementComparisons();
        metrics.increaseArrayAccesses(2); // Two accesses during the if statement
        if (mainArray[i] > mainArray[i + 1]) {
          metrics.incrementSwaps();
          metrics.increaseArrayAccesses(4); // Four accesses for swapping two indices
          buffer = mainArray[i];
          mainArray[i] = mainArray[i + 1];
          mainArray[i + 1] = buffer;
          swapDuringPass = true;
        }
        i++;
      }
      // If no swaps have occurred, then the array is sorted, so break the method
      // early.
      if (!swapDuringPass) {
        break;
      }
      // Otherwise, reduce number of pairs to check and run another pass.
      indicesRemaining--;
    }
  }

  /**
   * Creates a separate instance of this algorithm as a ManualSorter object with an independent copy
   * of mainArray, which will be able to sort the array by stepping through a queue of operations
   * that correspond with the bubble sort algorithm.
   * 
   * @return ManualSorter object queued with operations of bubble sort algorithm
   */
  @Override
  public ManualSorter preComputeManualSort() {
    // Create new ManualSorter object, which will be an independent copy of the
    // algorithm
    ManualSorter manualSorter = new ManualSorter(Arrays.copyOf(mainArray, mainArray.length));
    // Make independent copy of mainArray to sort without modifying original
    // mainArray
    int[] mainArrayDuplicate = Arrays.copyOf(mainArray, mainArray.length);
    // Optimisation: If no swaps occur during a pass, end the algorithm early.
    boolean swapDuringPass;
    // Optimisation: During each pass, the highest value bubbles to the end. We know
    // the highest value moved will be sorted, so there's no need to check that
    // again. Reduce number of checks each pass.
    int indicesRemaining = mainArrayDuplicate.length;
    int buffer; // Buffer used for temporarily holding a value while swapping two indices

    // Sort the inputArrayDuplicate array while queueing each operation into
    // manualSorter
    while (true) {
      swapDuringPass = false;
      // Check each pair in the array.
      for (int i = 0; i < (indicesRemaining - 1); i++) {
        manualSorter.enqueueOperation(SortingAlgorithmOperation.COMPARE, i, i + 1);
        // If the left number is larger than the right number, swap them.
        if (mainArrayDuplicate[i] > mainArrayDuplicate[i + 1]) {
          manualSorter.enqueueOperation(SortingAlgorithmOperation.SWAP, i, i + 1);
          buffer = mainArrayDuplicate[i];
          mainArrayDuplicate[i] = mainArrayDuplicate[i + 1];
          mainArrayDuplicate[i + 1] = buffer;
          swapDuringPass = true;
        }
      }

      // If no swaps have occurred, then the array is sorted, so break the method
      // early.
      if (!swapDuringPass) {
        break;
      }
      // Otherwise, reduce number of pairs to check and run another pass.
      indicesRemaining--;
    }

    // inputArrayDuplicate is sorted, so no more operations to add to manualSorter
    return manualSorter;
  }
}
