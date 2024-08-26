import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.BubbleSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.InsertionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.MergeSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SelectionSort;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithm;
import com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting.SortingAlgorithmType;
import com.github.netmastermichael.algorithmsuitex.controller.SortingAlgorithmController;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class TestSortingAlgorithmController {

  final String className = "TestSortingAlgorithmController";

  @Test
  void testCreateSortingControllerObject() { // Test 01
    String testName = "testCreateSortingControllerObject";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      SortingAlgorithmController testSortController = new SortingAlgorithmController();
      assertTrue(testSortController instanceof SortingAlgorithmController,
          "Test that a new instance of SortingAlgorithmController is created successfully");
      AuxiliaryTestMethods.logPassTest(className, testName);
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing creating an instance of "
          + "SortingAlgorithmController; " + e.getMessage());
    }
  }

  @Test
  void testEnqueueBubbleSort() { // Test 02
    String testName = "testEnqueueBubbleSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      // Enqueue algorithm into a controller
      SortingAlgorithmController testSortController = new SortingAlgorithmController();
      testSortController.enqueueAlgorithm(SortingAlgorithmType.BUBBLE_SORT, new int[] {1, 3, 2});

      // Retrieve algorithm from the controller and validate the correct algorithm is returned
      Queue<SortingAlgorithm> tscAlgorithmQueue = testSortController.getAlgorithmQueue();
      SortingAlgorithm algorithm = tscAlgorithmQueue.remove();
      assertTrue(algorithm instanceof BubbleSort, "Test that the SortingAlgorithmController class "
          + "correctly enqueues a BubbleSort algorithm");
      assertEquals(SortingAlgorithmType.BUBBLE_SORT, algorithm.getAlgorithmType(),
          "Test that the algorithm returns the correct algorithm type");
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing enqueueing a bubble sort algorithm into an "
          + "instance of SortingAlgorithmController; " + e.getMessage());
    }
  }
  
  @Test
  void testEnqueueSelectionSort() { // Test 03
    String testName = "testEnqueueSelectionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      // Enqueue algorithm into a controller
      SortingAlgorithmController testSortController = new SortingAlgorithmController();
      testSortController.enqueueAlgorithm(SortingAlgorithmType.SELECTION_SORT, new int[] {1, 3, 2});

      // Retrieve algorithm from the controller and validate the correct algorithm is returned
      Queue<SortingAlgorithm> tscAlgorithmQueue = testSortController.getAlgorithmQueue();
      SortingAlgorithm algorithm = tscAlgorithmQueue.remove();
      assertTrue(algorithm instanceof SelectionSort, "Test that the SortingAlgorithmController "
          + "class correctly enqueues a SelectionSort algorithm");
      assertEquals(SortingAlgorithmType.SELECTION_SORT, algorithm.getAlgorithmType(),
          "Test that the algorithm returns the correct algorithm type");
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing enqueueing a selection sort algorithm into an "
          + "instance of SortingAlgorithmController; " + e.getMessage());
    }
  }

  @Test
  void testEnqueueInsertionSort() { // Test 04
    String testName = "testEnqueueInsertionSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      // Enqueue algorithm into a controller
      SortingAlgorithmController testSortController = new SortingAlgorithmController();
      testSortController.enqueueAlgorithm(SortingAlgorithmType.INSERTION_SORT, new int[] {1, 3, 2});

      // Retrieve algorithm from the controller and validate the correct algorithm is returned
      Queue<SortingAlgorithm> tscAlgorithmQueue = testSortController.getAlgorithmQueue();
      SortingAlgorithm algorithm = tscAlgorithmQueue.remove();
      assertTrue(algorithm instanceof InsertionSort, "Test that the SortingAlgorithmController "
          + "class correctly enqueues a InsertionSort algorithm");
      assertEquals(SortingAlgorithmType.INSERTION_SORT, algorithm.getAlgorithmType(),
          "Test that the algorithm returns the correct algorithm type");
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing enqueueing an insertion sort algorithm into "
          + "an instance of SortingAlgorithmController; " + e.getMessage());
    }
  }
  
  @Test
  void testEnqueueMergeSort() { // Test 05
    String testName = "testEnqueueMergeSort";
    AuxiliaryTestMethods.logStartTest(className, testName);
    try {
      // Enqueue algorithm into a controller
      SortingAlgorithmController testSortController = new SortingAlgorithmController();
      testSortController.enqueueAlgorithm(SortingAlgorithmType.MERGE_SORT, new int[] {1, 3, 2});

      // Retrieve algorithm from the controller and validate the correct algorithm is returned
      Queue<SortingAlgorithm> tscAlgorithmQueue = testSortController.getAlgorithmQueue();
      SortingAlgorithm algorithm = tscAlgorithmQueue.remove();
      assertTrue(algorithm instanceof MergeSort, "Test that the SortingAlgorithmController "
          + "class correctly enqueues a MergeSort algorithm");
      assertEquals(SortingAlgorithmType.MERGE_SORT, algorithm.getAlgorithmType(),
          "Test that the algorithm returns the correct algorithm type");
    } catch (Exception e) {
      AuxiliaryTestMethods.logExceptionThrown(className, testName);
      fail("Exception " + e + " thrown while testing enqueueing a merge sort algorithm into "
          + "an instance of SortingAlgorithmController; " + e.getMessage());
    }
  }
}
