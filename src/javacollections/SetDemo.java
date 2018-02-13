package javacollections;

import java.util.*;

public class SetDemo {

	public static void main(String[] args) {
		// sets do not allow duplicates and are not stored in order (order is irrelevant).
		// also known as hash sets

		//initialize set with four items
		Set<String> mySet = new HashSet<>(Arrays.asList("Apple", "Orange", "Banana", "Strawberry"));
		
		System.out.println(mySet);
		
		mySet.add("Peach"); // Adding an item
		
		System.out.println(mySet);
		
		mySet.add("Orange"); // Attempting to add an existing item
		
		System.out.println(mySet); // items are unique, so there is not a duplicate even though we added it again
		
		Iterator<String> setIterator = mySet.iterator(); // sets can also use iterators.
		
		while (setIterator.hasNext()) { // go through the iterator until it doesn't have an item
			System.out.println(setIterator.next());  // printing each item
		}
	}

}
