package level3.calculator;

public class MultiplyOperator<T> implements Operator<T> {
    public T operate(T num1, T num2) {
        if (num1 instanceof Double && num2 instanceof Double) {
            return (T) Double.valueOf(((Double) num1).doubleValue() * ((Double) num2).doubleValue());
        }
        else if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(((Integer) num1).intValue() * ((Integer) num2).intValue());
        }
        // 지원되지 않는 타입일 경우 예외 처리
        throw new UnsupportedOperationException("지원되지 않는 타입입니다.");
    }
}