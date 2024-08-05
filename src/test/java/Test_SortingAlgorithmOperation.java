import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms.SortingAlgorithmOperation;

class Test_SortingAlgorithmOperation {

	@Test
	void testInitialiseSortingAlgorithmOperation_SWAP() {
		try {
			SortingAlgorithmOperation testSAO = SortingAlgorithmOperation.SWAP;
			assertTrue(testSAO == SortingAlgorithmOperation.SWAP,
					"Test that a new SortingAlgorithmObject correctly initialises with operation SWAP");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing creating a SortingAlgorithmOperation object of type SWAP; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testInitialiseSortingAlgorithmOperation_COMPARE() {
		try {
			SortingAlgorithmOperation testSAO = SortingAlgorithmOperation.COMPARE;
			assertTrue(testSAO == SortingAlgorithmOperation.COMPARE,
					"Test that a new SortingAlgorithmObject correctly initialises with operation COMPARE");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing creating a SortingAlgorithmOperation object of type COMPARE; "
					+ e.getMessage());
		}
	}

}
