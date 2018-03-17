package threading;

import static threading.AtomicVariables.numberCount;
import static threading.AtomicVariables.cycleCount;

public class ExecutorStopwatch implements Runnable {

	public void run() { // a runnable class must have the run() method. This is what runs with .start
		giveMe10();	
	}
	
	public void giveMe10() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			AtomicVariables.incrementNumber();
			try {
				Thread.sleep(100); // put the thread to sleep for 100 ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		AtomicVariables.incrementCycle();
	}
}
