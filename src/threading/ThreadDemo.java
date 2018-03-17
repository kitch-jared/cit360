package threading;

//This demo utilizing the "extends Thread".

public class ThreadDemo {
	public static void main(String[] args) {
		TenSecondStopwatchThread timeIt = new TenSecondStopwatchThread(); // create a new stopwatch		
		timeIt.start(); // start the new thread
		
		// You will see this running at the same time as the TenSecondStopwatch thread
		TenBananaThread eatIt = new TenBananaThread();
		eatIt.start();
	}
}

class TenSecondStopwatchThread extends Thread {

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

class TenBananaThread extends Thread {

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