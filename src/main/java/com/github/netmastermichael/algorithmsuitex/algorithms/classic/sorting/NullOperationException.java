package com.github.netmastermichael.algorithmsuitex.algorithms.classic.sorting;

/**
 * NullOperationException is an exception thrown by ManualSorter when a null operation is attempted
 * to be executed.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class NullOperationException extends Exception {

  /** Auto-generated serialVersionUID field. */
  private static final long serialVersionUID = -9156591742795436701L;

  /**
   * Constructor to create a NullOperationException.
   * 
   * @param errorMessage Detailed message containing the reason the exception was thrown
   */
  public NullOperationException(String errorMessage) {
    super(errorMessage);
  }

}
