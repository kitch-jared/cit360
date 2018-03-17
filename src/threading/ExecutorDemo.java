package threading;

import java.util.concurrent.*;
import static threading.AtomicVariables.numberCount;
import static threading.AtomicVariables.cycleCount;

// The Executor service can create more complex threads

public class ExecutorDemo {
	public static void main(String[] args) {
		
		//create a new executor
		ExecutorService executor = Executors.newFixedThreadPool(5); // This will allow 5 threads
		//Also valid are Executors.newSingleThreadExecutor()
		//and Executors.newScheduledThreadPool(#) which scheduled the threads
		
		//methods are execute(Runnable), submit(Runnable), submit(Callable), InvokeAny(...), InvokeAll(...)
		
		//this will spawn 7 threads, but since we Fixed the Thread Pool at 5, only 5 will run at a time
		for (int i = 0; i < 7; i++) { 
			Runnable spawnStopwatch = new ExecutorStopwatch();
			
			executor.execute(spawnStopwatch);
			
		}
		
		executor.shutdown();
		
		while (!executor.isTerminated()) { } // wait for executor to be terminated
		System.out.println("\nCounted to 10 " + AtomicVariables.cycleCount + " times.");
		System.out.println("Counted " + AtomicVariables.numberCount + " numbers.");
	}
}