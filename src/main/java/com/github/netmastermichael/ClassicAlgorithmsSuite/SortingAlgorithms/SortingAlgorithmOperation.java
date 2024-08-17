package com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms;

/**
 * SortingAlgorithmOperation is an enum that represents the possible types of
 * operations that a sorting algorithm may perform. Intended for use in
 * ManualSorter.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public enum SortingAlgorithmOperation {

	/**
	 * SWAP Operation
	 * 
	 * Action: Swaps positions of values at two indices in an array
	 * 
	 * Parameters:
	 * <ul>
	 * <li>currentIndexA : Left index</li>
	 * <li>currentIndexB : Right index</li>
	 * <li>(Multi-Array Mode) currentlySelectedArrayKey : Array to perform operation
	 * on. 0 means default array</li>
	 * </ul>
	 */
	SWAP,

	/**
	 * COMPARE Operation
	 * 
	 * Action: Load values into fields of ManualSorter object. No modification is
	 * made to any arrays, this operation is purely to help the interface visualise
	 * what indices are being compared.
	 * 
	 * Parameters:
	 * <ul>
	 * <li>currentIndexA : Left index being compared to right index</li>
	 * <li>currentIndexB : Right index being compared to left index</li>
	 * <li>(Multi-Array Mode) currentlySelectedArrayKey : Array which comparison is
	 * being performed</li>
	 * </ul>
	 */
	COMPARE,

	/**
	 * MOVE_LITERAL Operation
	 * 
	 * Action: Write a value at an index of an array.
	 * 
	 * Parameters:
	 * <ul>
	 * <li>currentIndexA : Value to write at index of array</li>
	 * <li>currentIndexB : Index of array where to write currentIndexA</li>
	 * <li>(Multi-Array Mode) currentlySelectedArrayKey : Array to write
	 * currentIndexA to</li>
	 * </ul>
	 */
	MOVE_LITERAL,

	/**
	 * CREATE_ARRAY Operation
	 * 
	 * Action: Create a new empty array inside the temporaryArrays HashMap.
	 * 
	 * Parameters:
	 * <ul>
	 * <li>currentIndexA : Size of new array</li>
	 * <li>currentIndexB : Index of new array</li>
	 * <li>(Multi-Array Mode) currentlySelectedArrayKey : Unused, no entry removal
	 * from arrayIndexDeque</li>
	 * </ul>
	 */
	CREATE_ARRAY,

	/**
	 * DELETE_ARRAY Operation
	 * 
	 * Action: Delete an existing array from the temporaryArrays HashMap.
	 * 
	 * Parameters:
	 * <ul>
	 * <li>currentIndexA : Index of array to delete</li>
	 * <li>currentIndexB : Unused, set to any value. Entry is still removed from
	 * indicesDeque</li>
	 * <li>(Multi-Array Mode) currentlySelectedArrayKey : Unused, no entry removal
	 * from arrayIndexDeque</li>
	 * </ul>
	 */
	DELETE_ARRAY;
}
