package javacollections;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		// maps are key/object pairs. Objects can be referenced by their unique key. Order is irrelevant.
		// Maps can also be "hash" (unsorted) or "tree" (sorted) like sets.
		
		Map treeMap = new TreeMap();
		
		treeMap.put("salaryJim", 100000); // note using put instead of add
		treeMap.put("salaryTim", 70000);
		treeMap.put("salarySlim", 58000);
		treeMap.put("salaryKim", 122000);
		
		System.out.println("Map is " + treeMap); // sorted by key name
		
		System.out.println("\nSlim's salary is " + treeMap.get("salarySlim")); // items are referenced by their key
		
		if (treeMap.containsKey("salaryJim")) {
		    System.out.println("\nWe have a salary on file for Jim.");
		}
		
		treeMap.replace("salaryJim", 111111); //replacing an item
		
		System.out.println("\nJim got a raise!");
		System.out.println("Map is " + treeMap);
		
		treeMap.remove("salaryJim"); // removing an item
		
		System.out.println("\nJim got fired!");
		System.out.println("Map is " + treeMap);

		Map hashMap = new HashMap();
		hashMap.put("salaryJim", 100000);
		hashMap.put("salaryTim", 70000);
		hashMap.put("salarySlim", 58000);
		hashMap.put("salaryKim", 122000);

		System.out.println("\nMap is " + hashMap); // not sorted
		
	}

}
