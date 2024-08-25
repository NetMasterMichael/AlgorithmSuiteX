package com.github.netmastermichael.algorithmsuitex.controller;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.BubbleSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.InsertionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.ManualSorter;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.MergeSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SelectionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithm;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmMetrics;
import java.util.Queue;

/**
 * Controller for storing and executing sorting algorithms.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class SortingController {

  private Queue<SortingAlgorithm> algorithmQueue;

  private SortingAlgorithm currentAlgorithm;

  public SortingController() {

  }

  /**
   * Adds a sorting algorithm to the queue.
   * 
   * @param algorithmType Type of algorithm to enqueue
   * @param data Unsorted array to load into sorting algorithm instance
   */
  public void enqueueAlgorithm(SortingAlgorithmType algorithmType, int[] data) {
    switch (algorithmType) {
      case BUBBLE_SORT:
        algorithmQueue.add(new BubbleSort(data));
        break;
      case INSERTION_SORT:
        algorithmQueue.add(new InsertionSort(data));
        break;
      case SELECTION_SORT:
        algorithmQueue.add(new SelectionSort(data));
        break;
      case MERGE_SORT:
        algorithmQueue.add(new MergeSort(data));
        break;
      default:
        // Will implement this case later
        break;
    }
  }

  /**
   * Removes the algorithm at the front of the queue and saves it into the currentAlgorithm field,
   * so that the interface can call subsequent methods to sort the algorithm in the desired way.
   * 
   * @return True if the next algorithm was loaded successfully, false if the algorithm queue is
   *         empty
   */
  public boolean loadNextAlgorithm() {
    if (algorithmQueue.isEmpty()) {
      return false;
    }
    currentAlgorithm = algorithmQueue.remove();
    return true;
  }

  /**
   * Returns the SortingAlgorithmMetrics object from the currently loaded algorithm. Use this method
   * to store the reference to the algorithm's SortingAlgorithmMetrics object somewhere before
   * calling executeSortWithMetrics().
   * 
   * @return SortingAlgorithmMetrics object from the currently loaded algorithm
   */
  public SortingAlgorithmMetrics getAlgorithmMetrics() {
    return currentAlgorithm.getMetrics();
  }

  /**
   * Executes sort() on the algorithm currently loaded. This sorts the unsorted array as fast as
   * possible with the specified algorithm and no additional overhead, but provides no additional
   * features (e.g. metrics tracking). Use this method when measuring the execution time of an
   * algorithm.
   * 
   * @return Sorted array
   */
  public int[] executeAlgorithm() {
    currentAlgorithm.sort();
    return currentAlgorithm.getMainArray();
  }

  /**
   * Executes sortWithMetrics() on the algorithm currently loaded. This sorts the unsorted array
   * using the specified algorithm while tracking metrics, such as array accesses and comparisons.
   * Use this method when measuring the metrics of an algorithm.
   * 
   * @return Sorted array
   */
  public int[] executeAlgorithmWithMetrics() {
    currentAlgorithm.sortWithMetrics();
    return currentAlgorithm.getMainArray();
  }

  /**
   * Executes preComputeManualSort() on the algorithm currently loaded. This simulates the algorithm
   * being sorted and loads all of the operations into a queue that can replay the sort
   * step-by-step. Use this when visualising the sorting algorithm.
   * 
   * @return ManualSorter object loaded with the operations of the loaded sorting algorithm
   */
  public ManualSorter generateManualSorter() {
    return currentAlgorithm.preComputeManualSort();
  }
}
