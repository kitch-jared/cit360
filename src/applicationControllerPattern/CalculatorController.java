package applicationControllerPattern;

import java.awt.event.*;
import java.util.HashMap;

// The Controller coordinates interactions
// between the View and Model

public class CalculatorController {
	
	static {
    	CalculatorModel.getInstance();
    	CalculatorView.getInstance();
	}

	private static CalculatorController theInstance = null;
	
	public static CalculatorController getInstance() {
		if (null == theInstance) {
			theInstance = new CalculatorController();
		}
		return theInstance;
	}
	
	private HashMap<String,DoMath> operationMap = new HashMap<String,DoMath>();
	
	public HashMap<String,DoMath> getOperationMap() {
		return operationMap;
	}
	
	private CalculatorController() {
		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class
		
		// operationMap.put("+", new Addition());
		operationMap.put("-", new Subtraction());
		operationMap.put("x", new Multiplication());
		operationMap.put("/", new Division());
	
	}
	
	public void launch() {
        CalculatorView.getInstance().Initialize();
        
		CalculatorView.getInstance().addCalculateListener(new CalculateListener());
		CalculatorView.getInstance().addAdditionListener(new AdditionListener());
		CalculatorView.getInstance().addSubtractionListener(new SubtractionListener());
		CalculatorView.getInstance().addMultiplicationListener(new MultiplicationListener());
		CalculatorView.getInstance().addDivisionListener(new DivisionListener());
		
		CalculatorView.getInstance().setLocationRelativeTo(null);
        CalculatorView.getInstance().setVisible(true);
        
        
	}
	
	class CalculateListener implements ActionListener{
		
		public void handleOperation(String operation, int num1, int num2) {
			
			DoMath myOperation = operationMap.get(operation);
			
			myOperation.execute(num1,num2);
		}

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber = CalculatorView.getInstance().getFirstNumber();
			int secondNumber = CalculatorView.getInstance().getSecondNumber();
			String operation = CalculatorView.getInstance().getOperation();
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			
			try{
				
				this.handleOperation(operation,firstNumber,secondNumber);
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				CalculatorView.getInstance().displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	
	class AdditionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			CalculatorView.getInstance().setFirstNumber(0);
			CalculatorView.getInstance().setSecondNumber(0);
			CalculatorView.getInstance().setCalcSolution(0);
				
			CalculatorView.getInstance().setOperation("+");
			
		}
		
	}
	
	class SubtractionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			CalculatorView.getInstance().setFirstNumber(0);
			CalculatorView.getInstance().setSecondNumber(0);
			CalculatorView.getInstance().setCalcSolution(0);
				
			CalculatorView.getInstance().setOperation("-");
			
		}
		
	}
	
	class MultiplicationListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			CalculatorView.getInstance().setFirstNumber(0);
			CalculatorView.getInstance().setSecondNumber(0);
			CalculatorView.getInstance().setCalcSolution(0);
				
			CalculatorView.getInstance().setOperation("x");
			
		}
		
	}
	
	class DivisionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			CalculatorView.getInstance().setFirstNumber(0);
			CalculatorView.getInstance().setSecondNumber(0);
			CalculatorView.getInstance().setCalcSolution(0);
				
			CalculatorView.getInstance().setOperation("/");
			
		}
		
	}
	
}

