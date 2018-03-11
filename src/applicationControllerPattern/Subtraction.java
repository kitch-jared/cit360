package applicationControllerPattern;

public class Subtraction implements DoMath {

	public void execute(int num1, int num2) {
		
		CalculatorModel.getInstance().subtractTwoNumbers(num1, num2);
		CalculatorView.getInstance().setCalcSolution(CalculatorModel.getInstance().getCalculationValue());
	}

}
