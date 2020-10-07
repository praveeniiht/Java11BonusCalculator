package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testCalculateBonus() throws Exception {
		// Test will pass
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> hm2 = new TreeMap<Integer, Integer>();
		List<String> resulList2 = new ArrayList<String>();
		List<String> resulList1 = new ArrayList<String>();
		hm.put(1010, "20-12-1987");
		hm1.put(1010, 10000);
		hm.put(2020, "01-01-1985");
		hm1.put(2020, 14400);
		hm2.put(1010, 12000);
		hm2.put(2020, 17280);
		resulList2.add("1010=12000");
		resulList2.add("2020=17280");
		Map<Integer, Integer> tm = BonusCalculator.calculateBonus(hm, hm1);
		for (Map.Entry<Integer, Integer> tm2 : tm.entrySet()) {
			resulList1.add(tm2.getKey() + "=" + tm2.getValue());
		}
		yakshaAssert(currentTest(), (resulList1.containsAll(resulList2) ? "true" : "false"), businessTestFile);
	}
}
