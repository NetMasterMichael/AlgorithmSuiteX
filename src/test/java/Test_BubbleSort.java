import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms.BubbleSort;

class Test_BubbleSort {

	@Test
	void testCreateBubbleSortObject() {
		try {
			BubbleSort testBubbleSort = new BubbleSort();
			assertTrue(testBubbleSort instanceof BubbleSort, "Test");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing creating an instance of BubbleSort; " + e.getMessage());
		}
	}

}
