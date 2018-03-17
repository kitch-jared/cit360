package threading;

public class AtomicVariables {
	static volatile int numberCount;
	static volatile int cycleCount;
	
	static synchronized void incrementNumber() {
        numberCount++;
    }
	
	static synchronized void incrementCycle() {
        cycleCount++;
    }
}
