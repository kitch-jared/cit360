package applicationControllerPattern;

public class Multiplication implements DoMath {

	public void execute(int num1, int num2) {
		
		CalculatorModel.getInstance().multiplyTwoNumbers(num1, num2);
		CalculatorView.getInstance().setCalcSolution(CalculatorModel.getInstance().getCalculationValue());
	}

}
