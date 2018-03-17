package threading;

// This demo utilizing the "implements Runnable". This is the preferred way to create a thread
// since it allows you to still extend a different class
// However, utilizing Runnable, you must separately create a thread before starting it.

public class RunnableDemo {
	public static void main(String[] args) {
		TenSecondStopwatch timeIt = new TenSecondStopwatch(); // create a new stopwatch		
		Thread threadX = new Thread(timeIt); // create a thread for the stopwatch
		threadX.start(); // start the new thread
		
		// You will see this running at the same time as the TenSecondStopwatch thread
		TenBanana eatIt = new TenBanana();
		Thread threadY = new Thread(eatIt);
		threadY.start();
	}
}

class TenSecondStopwatch implements Runnable {

	public void run() { // a runnable class must have the run() method. This is what runs with .start
		giveMe10();	
	}
	
	public void giveMe10() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // put the thread to sleep for 1000 ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Time's up.");
	}
}

class TenBanana implements Runnable {

	public void run() {
		giveMe10Banana();	
	}
	
	public void giveMe10Banana() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " banana");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("All out of bananas");
	}
}