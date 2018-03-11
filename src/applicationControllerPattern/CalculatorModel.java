package applicationControllerPattern;

// The Model performs all the calculations needed
// and that is it. It doesn't know the View
// exists

public class CalculatorModel {
	
	private static CalculatorModel theInstance = null;
	
	public static CalculatorModel getInstance() {
		if (null == theInstance) {
			theInstance = new CalculatorModel();
		}
		return theInstance;
	}

	private CalculatorModel() {
	}
	
	
	// Holds the value of the sum of the numbers
	// entered in the view
	
	private int calculationValue;
	
	public void addTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber + secondNumber;
		
	}
	
	public void subtractTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber - secondNumber;
		
	}
	
	public void multiplyTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber * secondNumber;
		
	}
	
	public void divideTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber / secondNumber;
		
	}
	
	public int getCalculationValue(){
		
		return calculationValue;
		
	}
	
}