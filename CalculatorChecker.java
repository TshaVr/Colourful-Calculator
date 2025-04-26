//CalculatorChecker.java [CONTROLLER]
import javax.swing.*;


public class CalculatorChecker {

    private ArithmeticCalculation calculation = null; //Initialise to null
    private final CalculatorDesign view;
    private double value1 = 0, value2 = 0;

    public CalculatorChecker(CalculatorDesign view) {
        this.view = view;

        // Event handling for number buttons by using inner class - UPDATES DISPLAY IN THE VIEW
        for (JButton button : view.numberButtons) {
            button.addActionListener(e -> {
                String value = button.getText();
                    view.displayField.setText(view.displayField.getText() + value);
            });
                    
        }
        
         // Event handling for operator buttons by using inner class
         for (JButton button : view.operatorButtons) {
             button.addActionListener(e -> {
                 String operator = button.getText();
                 
                 try{
                 value1 = Double.parseDouble(view.displayField.getText());
                }
                catch (NumberFormatException ex) {
                      view.displayField.setText("Invalid Input"); 
                      return;
                }
                
                  view.displayField.setText(""); //Clear display field for the second value
               
                 
                 //Assign specific operation class based on the operator
                 switch(operator) {
                     case "+" -> calculation = new ArithmeticCalculation.Addition();
                     case "-" -> calculation = new ArithmeticCalculation.Subtraction();
                     case "*" -> calculation = new ArithmeticCalculation.Multiplication();
                     case "/" -> calculation = new ArithmeticCalculation.Division();
                     default -> calculation = null; //Invalid Operator
                     
                 }
             });
        
        }
        
        //Event handling for equals button
        view.equalsButton.addActionListener(e -> controlCalculation());
        
        //Event handling for clear button
        view.clearButton.addActionListener(e -> view.displayField.setText(""));
    }


    // Method to control the calculation and update the view with the answer
    private void controlCalculation() {
        try {
            if (calculation == null) {
                view.displayField.setText("No Operator Selected!");
                return;
            }
            
            value2 = Double.parseDouble(view.displayField.getText());
            double answer = calculation.calculate(value1, value2);
            view.displayField.setText(String.valueOf(answer));  // Display result
        } 
        
        catch (NumberFormatException ex) {
            view.displayField.setText("Invalid Input, Try Again :(");
        } 
        
        catch (ArithmeticException ex) {
            view.displayField.setText("Math Error o_o");
        } 
        
        catch (Exception ex) {
            view.displayField.setText("Syntax Error T.T");
        }
    }
}
