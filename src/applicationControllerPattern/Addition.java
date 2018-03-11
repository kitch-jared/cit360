package applicationControllerPattern;

import javax.swing.JButton;

public class Addition extends JButton implements DoMath {

	private static final String symbol = "+";
	
	public Addition() {
		super(symbol);
		CalculatorController.getInstance().getOperationMap().put(symbol,this);
		
	}

	public void execute(int num1, int num2) {
		
		CalculatorModel.getInstance().addTwoNumbers(num1, num2);
		CalculatorView.getInstance().setCalcSolution(CalculatorModel.getInstance().getCalculationValue());
	}

}
