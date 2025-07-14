package level2.calculator;

public interface Operator {
    double operate(double num1, double num2) throws DivideByZeroException;
}
