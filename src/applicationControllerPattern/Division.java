package applicationControllerPattern;

public class Division implements DoMath {

	public void execute(int num1, int num2) {
		
		CalculatorModel.getInstance().divideTwoNumbers(num1, num2);
		CalculatorView.getInstance().setCalcSolution(CalculatorModel.getInstance().getCalculationValue());
	}

}
