package javacollections;

import java.util.*;

public class QueueDemo {

	public static void main(String[] args) {
		// Queues operate similar to a checkout line. They are mainly used to use things in order. Operations at
		//    the head are very efficient
		
		Queue<String> myQueue = new LinkedList<>(Arrays.asList("First", "Second", "Third", "Fourth", "Fifth"));
		
		System.out.println(myQueue);
		
		myQueue.add("Sixth"); // add an item to the end of the list
		
		System.out.println(myQueue);
		
		System.out.println("\nThe next element is: " + myQueue.element()); // This is the next up in the queue
		
		myQueue.remove(); // removes the next element making the second element the next up
		
		System.out.println("\nThe next element is: " + myQueue.element());
		
		System.out.println(myQueue);
		
	}

}
