package mvc;

// This package including all of its .java files are from 
// http://www.newthinktank.com/2013/02/mvc-java-tutorial/

public class MVCCalculator {
    
    public static void main(String[] args) {
    	
    	CalculatorView theView = new CalculatorView();
        
    	CalculatorModel theModel = new CalculatorModel();
        
        CalculatorController theController = new CalculatorController(theView,theModel);
        
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
        
    }
}