import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.netmastermichael.ClassicAlgorithmsSuite.SortingAlgorithms.SortingAlgorithmMetrics;

class Test_SortingAlgorithmMetrics {

	final String className = "Test_SortingAlgorithmMetrics";

	@Test
	void testCreateSortingAlgorithmMetricsObject() {
		String testName = "testCreateSortingAlgorithmMetricsObject";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertTrue(testSAM instanceof SortingAlgorithmMetrics,
					"Test that a new instance of SortingAlgorithmMetrics is created successfully");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing creating an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testGetComparisons() {
		String testName = "testGetComparisons";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object after initialization returns 0");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing getComparisons() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testGetSwaps() {
		String testName = "testGetSwaps";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getSwaps(),
					"Test that getSwaps() on a SortingAlgorithmMetrics object after initialization returns 0");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing getSwaps() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testGetPasses() {
		String testName = "testGetPasses";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getPasses(),
					"Test that getPasses() on a SortingAlgorithmMetrics object after initialization returns 0");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing getPasses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testSetComparisons() {
		String testName = "testSetComparisons";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object before calling setComparisons() returns 0");
			testSAM.setComparisons(50);
			assertEquals(50, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object after calling setComparisons() returns 50");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing setComparisons() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testSetSwaps() {
		String testName = "testGetSwaps";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getSwaps(),
					"Test that getSwaps() on a SortingAlgorithmMetrics object before calling setSwaps() returns 0");
			testSAM.setSwaps(100);
			assertEquals(100, testSAM.getSwaps(),
					"Test that getSwaps() on a SortingAlgorithmMetrics object after calling setSwaps() returns 100");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing setSwaps() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testSetPasses() {
		String testName = "testSetPasses";
		AuxiliaryTestMethods.logMessage(className, testName + "started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getPasses(),
					"Test that getPasses() on a SortingAlgorithmMetrics object before calling setPasses() returns 0");
			testSAM.setPasses(150);
			assertEquals(150, testSAM.getPasses(),
					"Test that getPasses() on a SortingAlgorithmMetrics object after calling setPasses() returns 150");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing setPasses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testIncrementComparisons() {
		String testName = "testIncrementComparisons";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i, testSAM.getComparisons(),
						"Test that the quantity of comparisons in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i));
				testSAM.incrementComparisons();
			}
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e
					+ " thrown while testing incrementComparisons() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testIncrementSwaps() {
		String testName = "testIncrementSwaps";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i, testSAM.getSwaps(),
						"Test that the quantity of swaps in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i));
				testSAM.incrementSwaps();
			}
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e + " thrown while testing incrementSwaps() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testIncrementPasses() {
		String testName = "testIncrementPasses";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i, testSAM.getPasses(),
						"Test that the quantity of passes in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i));
				testSAM.incrementPasses();
			}
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e
					+ " thrown while testing incrementPasses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testGetArrayAccesses() {
		String testName = "testGetArrayAccesses";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getArrayAccesses(),
					"Test that getArrayAccesses() on a SortingAlgorithmMetrics object after initialization returns 0");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e
					+ " thrown while testing getArrayAccesses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testSetArrayAccesses() {
		String testName = "testSetArrayAccesses";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getArrayAccesses(),
					"Test that getArrayAccesses() on a SortingAlgorithmMetrics object before calling setArrayAccesses() returns 0");
			testSAM.setArrayAccesses(1550);
			assertEquals(1550, testSAM.getArrayAccesses(),
					"Test that getArrayAccesses() on a SortingAlgorithmMetrics object after calling setArrayAccesses() returns 50");
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e
					+ " thrown while testing setArrayAccesses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}

	@Test
	void testIncreaseArrayAccesses() {
		String testName = "testIncreaseArrayAccesses";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getArrayAccesses(),
					"Test that getArrayAccesses() on a SortingAlgorithmMetrics object before calling increaseArrayAccesses() returns 0");
			testSAM.increaseArrayAccesses(128);
			assertEquals(128, testSAM.getArrayAccesses(),
					"Test that getArrayAccesses() on a SortingAlgorithmMetrics object after calling increaseArrayAccesses() returns 128");
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i * 4 + 128, testSAM.getArrayAccesses(),
						"Test that the quantity of array accesses in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i * 4 + 128));
				testSAM.increaseArrayAccesses(4);
			}
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e
					+ " thrown while testing testIncreaseArrayAccesses() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
	
	@Test
	void testIncreaseComparisonss() {
		String testName = "testIncreaseComparisonss";
		AuxiliaryTestMethods.logMessage(className, testName + " started");
		try {
			SortingAlgorithmMetrics testSAM = new SortingAlgorithmMetrics();
			assertEquals(0, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object before calling increaseComparisons() returns 0");
			testSAM.increaseComparisons(128);
			assertEquals(128, testSAM.getComparisons(),
					"Test that getComparisons() on a SortingAlgorithmMetrics object after calling increaseComparisons() returns 128");
			for (int i = 0; i <= 1000; i++) {
				assertEquals(i * 4 + 128, testSAM.getComparisons(),
						"Test that the quantity of comparisons in a SortingAlgorithmMetrics instance equals "
								+ Integer.toString(i * 4 + 128));
				testSAM.increaseComparisons(4);
			}
			AuxiliaryTestMethods.logPass(className, testName);
		} catch (Exception e) {
			AuxiliaryTestMethods.logFail(className, testName);
			fail("Exception " + e
					+ " thrown while testing testIncreaseComparisons() on an instance of SortingAlgorithmMetrics; "
					+ e.getMessage());
		}
	}
}
