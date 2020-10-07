package yaksha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class BonusCalculator {
	public static TreeMap<Integer, Integer> calculateBonus(HashMap<Integer, String> hm, HashMap<Integer, Integer> hm1) {
		TreeMap<Integer, Integer> hm2 = new TreeMap<Integer, Integer>();
		Iterator<Integer> it = hm.keySet().iterator();

		while (it.hasNext()) {
			int y = it.next();
			String dob = hm.get(y);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.setLenient(false);
			String now = "01-09-2014";
			try {
				Calendar c = Calendar.getInstance();
				Date d1 = sdf.parse(now);
				Date d2 = sdf.parse(dob);
				c.setTime(d1);
				int y1 = c.get(Calendar.YEAR);
				int m1 = c.get(Calendar.MONTH);
				int day1 = c.get(Calendar.DATE);
				c.setTime(d2);
				int y2 = c.get(Calendar.YEAR);
				int m2 = c.get(Calendar.MONTH);
				int day2 = c.get(Calendar.DATE);

				int age = y1 - y2;
				if (m1 < m2)
					age--;
				else if (m1 == m2 && day1 < day2)
					age--;
				if (hm1.get(y) < 5000) {
					hm2.put(y, -200);
				} else if ((age < 25 || age > 60) && hm1.get(y) < 5000)
					hm2.put(y, -100);
				else if (age >= 25 && age <= 30) {
					float bonus = (float) 0.2 * hm1.get(y) + hm1.get(y);
					hm2.put(y, (int) bonus);
				} else if (age > 30 && age <= 60) {
					float bonus = (float) (0.3 * hm1.get(y)) + hm1.get(y);
					hm2.put(y, (int) bonus);
				} else if (age < 25 || age > 60)
					hm2.put(y, -200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hm2;
	}

}
