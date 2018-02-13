package javacollections;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		
		// standard array often used for List initialization
		String[] teamArray = {"Jake", "Bryce", "Devin", "Ben", "Jared", "Sergio", "Daryl"};
		
		List<String> teamList = new ArrayList<String>(); // create an empty List which is a type of collection
		// List items can be referenced by index number and can contain duplicates
		
		for (String x: teamArray)
			teamList.add(x); // add each item from teamArray to the teamList
		
		System.out.println("teamList contains ");
		for (int i = 0; i < teamList.size(); i++){ // using size method
			System.out.println(teamList.get(i)); // using get method
		}
		
		// initialized using the Arrays asList method
		List<String> taughtList = new ArrayList<String>(Arrays.asList("Bryce", "Ben", "Daryl"));
		taughtList.add("Jared"); // can still add a new item

		System.out.println("\ntaughtList contains ");
		for (int i = 0; i < taughtList.size(); i++){ // using size method
			System.out.println(taughtList.get(i)); // using get method with index value
		}
		
		List<String> needTeachList = new ArrayList<String>();
		
		for (String x: teamArray)
			needTeachList.add(x); // add each item from teamArray to the needTeachList
		
		removeItems(needTeachList, taughtList);
		
		System.out.println("\nneedTeachList contains ");
		for (int i = 0; i < needTeachList.size(); i++){ // using size method
			System.out.println(needTeachList.get(i)); // using get method
		}
		
		Collections.sort(teamList); // you can use the sort method to alphabetize
		System.out.println("\nThe alphabetized teamList is\n" + teamList);
		
		Collections.swap(teamList, 0, 6); // you can swap items
		System.out.println("\nAfter swapping the first and last item, the teamList is\n" + teamList);
		
		if (teamList.contains("Jared")) { // you check for items
			System.out.println("\nThe teamList contains Jared");
		} else {
			System.out.println("\nThe teamList does not contain Jared");
		}
			
		if (teamList.contains("John")) {
			System.out.println("\nThe teamList contains John");
		} else {
			System.out.println("\nThe teamList does not contain John");
		}
		
	}
	
	public static void removeItems(Collection<String> editList, Collection<String> removeList) {
		Iterator<String> listIterator = editList.iterator(); // create an iterator to go through the list
		
		while (listIterator.hasNext()) { // go through the iterator until it doesn't have an item
			if (removeList.contains(listIterator.next())) // if the current item is also contained in the removeList...
				listIterator.remove(); // remove the item
		}
	}

}
