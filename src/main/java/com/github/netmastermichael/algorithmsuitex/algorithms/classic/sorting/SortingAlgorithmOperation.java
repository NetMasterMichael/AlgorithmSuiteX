package com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting;

/**
 * SortingAlgorithmOperation is an enum that represents the possible types of operations that a
 * sorting algorithm may perform. Intended for use in ManualSorter.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public enum SortingAlgorithmOperation {

  /**
   * The SWAP operation swaps positions of values at two indices in an array.
   * <p>
   * Parameters:
   * </p>
   * <ul>
   * <li>currentIndexA : Left index</li>
   * <li>currentIndexB : Right index</li>
   * <li>(Multi-Array Mode) currentlySelectedArrayKey : Array to perform operation on. 0 means
   * default array</li>
   * </ul>
   */
  SWAP,

  /**
   * The COMPARE Operation loads values into their corresponding fields of ManualSorter object. No
   * modification is made to any arrays, this operation is purely to help the interface visualise
   * what indices are being compared.
   * <p>
   * Parameters:
   * </p>
   * <ul>
   * <li>currentIndexA : Left index being compared to right index</li>
   * <li>currentIndexB : Right index being compared to left index</li>
   * <li>(Multi-Array Mode) currentlySelectedArrayKey : Array which comparison is being
   * performed</li>
   * </ul>
   */
  COMPARE,

  /**
   * The MOVE_LITERAL operation writes a value at an index of an array.
   * <p>
   * Parameters:
   * </p>
   * <ul>
   * <li>currentIndexA : Value to write at index of array</li>
   * <li>currentIndexB : Index of array where to write currentIndexA</li>
   * <li>(Multi-Array Mode) currentlySelectedArrayKey : Array to write currentIndexA to</li>
   * </ul>
   */
  MOVE_LITERAL,

  /**
   * The CREATE_ARRAY operation creates a new empty array inside the temporaryArrays HashMap.
   * <p>
   * Parameters:
   * </p>
   * <ul>
   * <li>currentIndexA : Size of new array</li>
   * <li>currentIndexB : Index of new array</li>
   * <li>(Multi-Array Mode) currentlySelectedArrayKey : Unused, no entry removal from
   * arrayIndexDeque</li>
   * </ul>
   */
  CREATE_ARRAY,

  /**
   * The DELETE_ARRAY operation deletes an existing array from the temporaryArrays HashMap.
   * <p>
   * Parameters:
   * </p>
   * <ul>
   * <li>currentIndexA : Index of array to delete</li>
   * <li>currentIndexB : Unused, set to any value. Entry is still removed from indicesDeque</li>
   * <li>(Multi-Array Mode) currentlySelectedArrayKey : Unused, no entry removal from
   * arrayIndexDeque</li>
   * </ul>
   */
  DELETE_ARRAY;
}
