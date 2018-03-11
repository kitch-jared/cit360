package applicationControllerPattern;

import java.awt.Container;
import java.awt.GridLayout;

// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 

import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorView extends JFrame{
	
	private static CalculatorView theInstance = null;
	
	public static CalculatorView getInstance() {
		if (null == theInstance) {
			theInstance = new CalculatorView();
		}
		return theInstance;
	}

	private JTextField firstNumber  = new JTextField(10);
	private JLabel operation = new JLabel("+",SwingConstants.CENTER);
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("Calculate");
	private JTextField calcSolution = new JTextField(10);

	private JLabel chooseLabel = new JLabel("Choose an operation:");
	private Addition addButton = null;			// Playing with concepts of packaging all things having to do with 
												// "Addition"
	private JButton subtractButton = new JButton("-");
	private JButton multiplyButton = new JButton("x");
	private JButton divideButton = new JButton("/");
	
	private CalculatorView(){
		
	}
	
	public void Initialize() {
		// Sets up the view and adds the components
		
		JPanel calcPanel = new JPanel();
		calcPanel.setLayout(new GridLayout(4,0,10,10));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(658, 200);
		
		calcPanel.add(firstNumber);
		calcPanel.add(operation);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		
		calcPanel.add(new JLabel(""));
		calcPanel.add(new JLabel(""));
		calcPanel.add(new JLabel(""));
		calcPanel.add(new JLabel(""));
		calcPanel.add(new JLabel(""));
		
		calcPanel.add(chooseLabel);
		calcPanel.add(new JLabel(""));
		calcPanel.add(new JLabel(""));
		calcPanel.add(new JLabel(""));
		calcPanel.add(new JLabel(""));
		
		addButton = new Addition();
		calcPanel.add(addButton);
		calcPanel.add(subtractButton);
		calcPanel.add(multiplyButton);
		calcPanel.add(divideButton);
		
		this.add(calcPanel);
	}
	
	public int getFirstNumber(){
		
		return Integer.parseInt(firstNumber.getText());
		
	}
	
	public int getSecondNumber(){
		
		return Integer.parseInt(secondNumber.getText());
		
	}
	
	public void setFirstNumber(int myNumber){
		
		firstNumber.setText(Integer.toString(myNumber));
		
	}
	
	public void setSecondNumber(int myNumber){
		
		secondNumber.setText(Integer.toString(myNumber));
		
	}
	
	public String getOperation(){
		
		return operation.getText();
		
	}
	
	public void setOperation(String newOperation){
		
		operation.setText(newOperation);
		
	}
	
	public int getCalcSolution(){
		
		return Integer.parseInt(calcSolution.getText());
		
	}
	
	public void setCalcSolution(int solution){
		
		calcSolution.setText(Integer.toString(solution));
		
	}
	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	
	void addCalculateListener(ActionListener listenForCalcButton){
		
		calculateButton.addActionListener(listenForCalcButton);
		
	}
	
	void addAdditionListener(ActionListener listenForAddButton) {
		
		addButton.addActionListener(listenForAddButton);
		
	}
	
	void addSubtractionListener(ActionListener listenForSubtractButton) {
		
		subtractButton.addActionListener(listenForSubtractButton);
		
	}
	
	void addMultiplicationListener(ActionListener listenForMultiplyButton) {
		
		multiplyButton.addActionListener(listenForMultiplyButton);
		
	}
	
	void addDivisionListener(ActionListener listenForDivideButton) {
		
		divideButton.addActionListener(listenForDivideButton);
		
	}
	
	// Open a popup that contains the error message passed
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}