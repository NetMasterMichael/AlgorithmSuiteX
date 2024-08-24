import java.util.ArrayList;
import java.util.Random;

/**
 * AuxiliaryTestMethods is a class containing static methods that are shared between several test
 * classes for sorting algorithms. These are primarily in relation to logging and generating arrays.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class AuxiliaryTestMethods {

  // ANSI escape codes for logging messages

  /*
   * ANSI escape code to reset all colour effects to their defaults in the console. Used at the
   * start and end of each logging message, and to return coloured text back to normal.
   */
  private static final String RESET = "\033[0m";

  /*
   * ANSI escape code to change the text to bright blue and bold. Used for highlighting the name of
   * the test class.
   */
  private static final String BRIGHT_BLUE_BOLD_TEXT = "\033[1;94m";

  /*
   * ANSI escape code to change the text to bright green and bold. Used for the word "PASSED" in
   * logPass().
   */
  private static final String BRIGHT_GREEN_BOLD_TEXT = "\033[0;1;92m";

  /*
   * ANSI escape code to change the text to bright white and bold. Used for the test name on the
   * start and pass methods.
   */
  private static final String BRIGHT_WHITE_BOLD_TEXT = "\033[1;97m";

  /**
   * ANSI escape code to change text to bright white and bold on a red background. Used for the
   * whole message in logFail().
   */
  private static final String RED_BACKGROUND_WHITE_BOLD_TEXT = "\033[1;97;41m";

  /**
   * Outputs a message to the console consistent with the format used by the other logging methods
   * in AuxiliaryTestMethods. The method is written for any generic message, making it useful for
   * messages other than starting a test (e.g. halfway through a stress test).
   * 
   * @param testClassName Name of test class
   * @param message Message to output
   */
  public static void logMessage(String testClassName, String message) {
    System.out.println(
        RESET + "[" + BRIGHT_BLUE_BOLD_TEXT + testClassName + RESET + "] => " + message + RESET);
  }


  /**
   * Outputs a message to the console consistent with the format used by other logging methods in
   * AuxiliaryTestMethods. Used for outputting a test started message.
   * 
   * @param testClassName Name of test class
   * @param testMethodName Name of test method
   */
  public static void logStartTest(String testClassName, String testMethodName) {
    System.out.println(RESET + "[" + BRIGHT_BLUE_BOLD_TEXT + testClassName + RESET + "] => "
        + BRIGHT_WHITE_BOLD_TEXT + testMethodName + RESET + " started");
  }

  /**
   * Outputs a message to the console consistent with the format used by other logging methods in
   * AuxiliaryTestMethods. Used for outputting a colourful pass message.
   * 
   * @param testClassName Name of test class
   * @param testMethodName Name of test method that has passed
   */
  public static void logPassTest(String testClassName, String testMethodName) {
    System.out.println(RESET + "[" + BRIGHT_BLUE_BOLD_TEXT + testClassName + RESET + "] => "
        + BRIGHT_WHITE_BOLD_TEXT + testMethodName + RESET + " has " + BRIGHT_GREEN_BOLD_TEXT
        + "PASSED" + RESET);
  }

  /**
   * Outputs a message to the console consistent with the format used by other logging methods in
   * AuxiliaryTestMethods. Used for outputting a colourful fail message.
   * 
   * @param testClassName Name of test class
   * @param testMethodName Name of test method that has failed
   */
  public static void logExceptionThrown(String testClassName, String testMethodName) {
    System.out.println(RESET + RED_BACKGROUND_WHITE_BOLD_TEXT + "[" + testClassName + "] => "
        + testMethodName + " has thrown an exception. See EXCEPTION below:" + RESET);
  }

  /**
   * Generates a sorted array of integers, where each n'th index holds the value of n + 1. (e.g. 0th
   * index is 1, 99th index is 100, etc)
   * 
   * @param size Size of sorted array
   * 
   * @return Sorted array of integers
   */
  public static int[] generateSortedArray(int size) {
    int[] sortedArray = new int[size];
    for (int i = 1; i <= size; i++) {
      sortedArray[i - 1] = i;
    }
    return sortedArray;
  }

  /**
   * Generates an unsorted array of unique integers. Useful when testing sorting algorithms. It
   * works by filling up a list of numbers up to the parameter size, then takes a random index from
   * the list and copies it into an array until there are no integers left in the list. This means
   * there are no repeating numbers.
   * 
   * @param size Size of unsorted array
   * 
   * @return Unsorted array of integers
   */
  public static int[] generateUnsortedArray(int size) {
    ArrayList<Integer> numberList = new ArrayList<Integer>();
    int[] unsortedArray = new int[size];
    Random rand = new Random();
    int randIndex;

    // Fill up a list and sortedArray with numbers 1 to n
    for (int i = 1; i <= size; i++) {
      numberList.add(i);
    }
    // Fill up unsortedArray with random numbers from numberList
    for (int i = 0; i < size; i++) {
      randIndex = rand.nextInt(numberList.size());
      unsortedArray[i] = numberList.get(randIndex);
      numberList.remove(randIndex);
    }
    return unsortedArray;
  }
}
