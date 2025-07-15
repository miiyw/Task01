package level3.calculator;

import java.util.*;

public class ArithmeticCalculator<T extends Number> extends Calculator<T> {
    Scanner sc = new Scanner(System.in);

    // 연산자 문자와 연산자 객체를 매핑하는 맵
    //Map<Character, Operator> operatorMap = new HashMap<>();
    Map<OperatorType, Operator> operatorMap = new HashMap<>();

    // 사칙 연산 생성자 - 이 부분만 수정하면 확장 가능
    public ArithmeticCalculator() {
        super(); // Calculator 생성자 호출
        operatorMap.put(OperatorType.ADD, new AddOperator());
        operatorMap.put(OperatorType.SUBTRACT, new SubtractOperator());
        operatorMap.put(OperatorType.MULTIPLY, new MultiplyOperator());
        operatorMap.put(OperatorType.DIVIDE, new DivideOperator());
        operatorMap.put(OperatorType.MOD, new ModOperator());
    }

    // 사칙 연산 계산기
    @Override
    public T calculate(T... numbers) {
        // 가변 인자
        if (numbers.length != 2) { // 입력된 값이 2개가 아니라면
            throw new IllegalArgumentException("두 개의 숫자를 입력해야 합니다."); // 오류 출력
        }

        T num1 = numbers[0];
        T num2 = numbers[1];

        System.out.print("사칙 연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

//        // 연산자에 해당하는 Operator 객체를 가져옴
//        Operator op =  operatorMap.get(operator);
//        // 잘못된 연산 기호를 입력했을 때의 처리
//        if (op == null) {
//            System.out.println("잘못된 연산 기호입니다.");
//            return 0;
//        }

        // 입력한 연산 기호를 'OperatorType'으로 변환
        OperatorType operatorType = getOperatorType(operator);
        if (operatorType == null) { // 잘못된 연산 기호를 입력했을 때의 처리
            System.out.println("잘못된 연산 기호입니다.");
            return null;
        }

        // 연산자에 해당하는 Operator 객체를 가져옴
        Operator op =  operatorMap.get(operatorType);

        try {
            T result = (T) op.operate(num1, num2); // 연산 수행
            resultList.add(result); // 결과 저장
            return result; // 결괏값 반환
        } catch (DivideByZeroException e) { // 나눗셈과 나머지 연산에서 0으로 나누었을 때 예외 처리
            System.out.println("! 예외 발생: " + e.getMessage() + "\n");
            return null;
        }
    }

    // 연산 결과 중 가장 먼저 저장된 데이터 삭제하는 메서드 구현
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            System.out.println("삭제 후 현재 저장된 결과: " + resultList + "\n");
        }
        else { // 만약 리스트에 연산 결과가 없다면
            System.out.println("리스트가 비어 있습니다.\n"); // 안내문 출력
        }
    }

    // char 연산자를 OperatorType으로 변환하는 메서드
    private OperatorType getOperatorType(char operator) {
        for (OperatorType type : OperatorType.values()) { // 연산 기호(+, -, *, /, %)를 하나씩 가져옴
            if (type.getOperate() == operator) {
                return type; // 일치하는 연산 기호 타입 반환
            }
        }
        return null; // 잘못된 연산 기호가 입력되었을 때
    }
}