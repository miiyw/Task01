package level3.calculator;

public interface Operator<T> {
    T operate(T num1, T num2) throws DivideByZeroException;
}
