import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms.BubbleSort;
import com.github.netmastermichael.classic_algorithms_suite.SortingAlgorithms.SortingAlgorithmMetrics;

class Test_SortingAlgorithmMetrics {

	@Test
	void testCreateSortingAlgorithmMetricsObject() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertTrue(testSAM instanceof SortingAlgorithmMetrics,
					"Test that a new instance of SortingAlgorithmMetrics is created successfully");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing creating an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testGetComparisons() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object after initialization returns 0");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing getComparisons() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testGetSwaps() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getSwaps(),
					"Test that getSwaps() on a SortingAlgorithmMetrics object after initialization returns 0");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing getSwaps() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testGetPasses() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getPasses(),
					"Test that getPasses() on a SortingAlgorithmMetrics object after initialization returns 0");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing getPasses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testSetComparisons() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object before calling setComparisons() returns 0");
			testSAM.setComparisons(50);
			assertEquals(50, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object after calling setComparisons() returns 50");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing setComparisons() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testSetSwaps() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getSwaps(),
					"Test that getSwaps() on a SortingAlgorithmMetrics object before calling setSwaps() returns 0");
			testSAM.setSwaps(100);
			assertEquals(100, testSAM.getSwaps(),
					"Test that getSwaps() on a SortingAlgorithmMetrics object after calling setSwaps() returns 100");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing setSwaps() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testSetPasses() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getPasses(),
					"Test that getPasses() on a SortingAlgorithmMetrics object before calling setPasses() returns 0");
			testSAM.setPasses(150);
			assertEquals(150, testSAM.getPasses(),
					"Test that getPasses() on a SortingAlgorithmMetrics object after calling setPasses() returns 150");
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing setPasses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testIncrementComparisons() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i, testSAM.getComparisons(),
						"Test that the quantity of comparisons in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i));
				testSAM.incrementComparisons();
			}
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing incrementComparisons() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testIncrementSwaps() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i, testSAM.getSwaps(),
						"Test that the quantity of swaps in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i));
				testSAM.incrementSwaps();
			}
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing incrementSwaps() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testIncrementPasses() {
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i, testSAM.getPasses(),
						"Test that the quantity of passes in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i));
				testSAM.incrementPasses();
			}
		} catch (Exception e) {
			fail("Exception " + e + " thrown while testing incrementPasses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
}
