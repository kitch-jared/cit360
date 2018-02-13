package javacollections;

import java.util.*;

public class TreeDemo {

	public static void main(String[] args) {
		// trees are sets kept in alpha-numeric order
		
		//initialize set with four items
		NavigableSet<String> mySet = new TreeSet<>(Arrays.asList("Orange", "Apple", "Banana", "Strawberry"));
		
		System.out.println(mySet); // it is automatically sorted
		
		mySet.add("Peach"); // Adding an item
		
		System.out.println(mySet);
		
		mySet.add("Orange"); // Attempting to add an existing item
		
		System.out.println(mySet); // items are unique, so there is not a duplicate even though we added it again

		System.out.println("First lowest element: "+ mySet.first());
		
		System.out.println("A subset of everything from Banana to (but not including) Strawberry" + mySet.subSet("Banana", "Strawberry"));
		
	}

}
