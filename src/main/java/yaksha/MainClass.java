package yaksha;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class MainClass {
	public static void main(String args[]) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> hm2 = new TreeMap<Integer, Integer>();
		Scanner sc = new Scanner(System.in);
		int s = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < s; i++) {
			int id = Integer.parseInt(sc.nextLine());
			String ss = sc.nextLine();
			int salary = Integer.parseInt(sc.nextLine());
			hm.put(id, ss);

			hm1.put(id, salary);
		}
		hm2 = BonusCalculator.calculateBonus(hm, hm1);
		Iterator<Integer> it = hm2.keySet().iterator();
		for (int i = 0; i < s; i++) {
			int id = it.next();
			int bonus = hm2.get(id);
			System.out.println(id);
			System.out.println(bonus);
		}
		sc.close();
	}
}
