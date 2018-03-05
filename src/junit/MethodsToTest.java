package junit;

import java.util.Random;

public class MethodsToTest {
	
	public int addThese(int x, int y) {
		return x + y;
	}
	
	public int[] produceRandomArray() {
		Random randA = new Random();
		int a = randA.nextInt(99);
		Random randB = new Random();
		int b = randB.nextInt(99);
		Random randC = new Random();
		int c = randC.nextInt(99);
	    int[] myArray = {a,b,c};
		return myArray;
	}
	
	public int[] produceSameArray() {
		int a = 1;
		int b = 2;
		int c = 3;
		int[] myArray = {1,2,3};
		return myArray;
	}

}
