package co.tushar.HashmapAndHeap;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfEmployeesUnderEveryManager {

	/*
	 * 1. You are given number N and 2*N number of strings that contains mapping of
	 * the employee and his manager. 2. An employee directly reports to only one
	 * manager. 3. All managers are employees but the reverse is not true. 4. An
	 * employee reporting to himself is the CEO of the company. 5. You have to find
	 * the number of employees under each manager in the hierarchy not just their
	 * direct reports.
	 */

	public static void main(String[] args) {

		int n = 6;
		HashMap<String, String> map = new HashMap<>();

		map.put("A", "C");
		map.put("B", "C");
		map.put("C", "F");
		map.put("D", "E");
		map.put("E", "F");
		map.put("F", "F");

		findCount(map);

	}

	public static void findCount(HashMap<String, String> map) {

		HashMap<String, HashSet<String>> tree = new HashMap<>();
		String ceo = "";

		for (String emp : map.keySet()) {

			String man = map.get(emp);
			if (man.equals(emp)) {
				ceo = man;
			} else {

				if (tree.containsKey(man)) {
					HashSet<String> emps = tree.get(man);
					emps.add(emp);
				} else {
					HashSet<String> emps = new HashSet<>();
					emps.add(emp);
					tree.put(man, emps);
				}

			}

		}

		HashMap<String, Integer> rs = new HashMap<>();
		getSize(tree, ceo, rs);

		for (String emp : rs.keySet()) {
			System.out.println(emp + " " + rs.get(emp));
		}

	}

	public static int getSize(HashMap<String, HashSet<String>> tree, String ceo, HashMap<String, Integer> rs) {

		if (!tree.containsKey(ceo)) {
			rs.put(ceo, 0);
			return 1;

		}

		int sz = 0;
		for (String emp : tree.get(ceo)) {

			int cs = getSize(tree, emp, rs);
			sz += cs;

		}

		rs.put(ceo, sz);
		return sz + 1;

	}

}
