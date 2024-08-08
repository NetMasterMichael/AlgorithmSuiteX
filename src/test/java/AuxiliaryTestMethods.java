import java.util.ArrayList;
import java.util.Random;

/**
 * AuxiliaryTestMethods is a class containing static methods that are shared
 * between several test classes for sorting algorithms. These are primary in
 * relation to generating arrays.
 * 
 * @author Michael Goodwin (NetMasterMichael)
 */
public class AuxiliaryTestMethods {

	/**
	 * Generates a sorted array of integers, where each n'th index holds the value
	 * of n + 1. (e.g. 0th index is 1, 99th index is 100, etc)
	 * 
	 * @param size Size of sorted array
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
	 * Generates an unsorted array of unique integers. Useful when testing sorting
	 * algorithms. It works by filling up a list of numbers up to the parameter
	 * size, then takes a random index from the list and copies it into an array
	 * until there are no integers left in the list. This means there are no
	 * repeating numbers.
	 * 
	 * @param size Size of unsorted array
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
