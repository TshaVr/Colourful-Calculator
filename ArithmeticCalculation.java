//ArithmeticCalculation.java [MODEL]
public abstract class ArithmeticCalculation {
    
    public abstract double calculate(double value1, double value2);
    
    public static class Addition extends ArithmeticCalculation {
        @Override
        public double calculate(double value1, double value2) {
            return value1 + value2;
        }
    }
    
    public static class Subtraction extends ArithmeticCalculation {
        @Override
        public double calculate(double value1, double value2) {
            return value1 - value2;
        }
    }
    
    public static class Multiplication extends ArithmeticCalculation {
        @Override
        public double calculate(double value1, double value2) {
            return value1 * value2;
        }
    }
    
    public static class Division extends ArithmeticCalculation {
        @Override
        public double calculate(double value1, double value2) {
            if (value2 == 0) {
                throw new ArithmeticException("ERROR! Cannot be divided by ZERO");
            }
            return value1 / value2;
        }
    }
}
    
    
    
    
