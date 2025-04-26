//CreativeCalculator.java [MAIN APPLICATION]
public class CreativeCalculator {
    
    public static void main(String[] args) {
        
        //Initialises MVC Components
        CalculatorDesign view = new CalculatorDesign();
        new CalculatorChecker(view); //Controller handles interaction between Model and View
    }
}