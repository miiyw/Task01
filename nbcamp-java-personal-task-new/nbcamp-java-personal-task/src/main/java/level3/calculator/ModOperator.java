package level3.calculator;

public class ModOperator<T extends Number> implements Operator<T> {
    public T operate(T num1 , T num2) throws DivideByZeroException {
        if (num2.intValue() == 0) { // intValue()를 사용하여 0을 체크
            throw new DivideByZeroException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
        }

        // T 타입이 정수 타입일 경우
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(((Integer) num1).intValue() % ((Integer) num2).intValue());
        }

        // T 타입이 Double일 경우
        else if (num1 instanceof Double && num2 instanceof Double) {
            return (T) Double.valueOf(((Double) num1).doubleValue() % ((Double) num2).doubleValue());
        }
        // 지원되지 않는 타입일 경우 예외 처리
        throw new UnsupportedOperationException("지원되지 않는 타입입니다.");
    }
}
