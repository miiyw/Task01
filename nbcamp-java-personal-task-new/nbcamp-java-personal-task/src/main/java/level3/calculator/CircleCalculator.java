package level3.calculator;

public class CircleCalculator<T extends Number> extends Calculator<T> {
    // 원의 넓이 생성자
    public CircleCalculator() {
        super();
    }

    // PI는 수학적으로 불변인 상수이기 때문에 final과 static 사용
    final static double PI = 3.14159;

    // 원의 넓이를 계산하는 메서드 구현
    @Override
    public T calculate(T... numbers) {
        if (numbers.length != 1) { // 반지름이 여러 개 전달되었다면
            throw new IllegalArgumentException("반지름은 하나의 값만 입력해야 합니다."); // 오류 출력
        }

        double radius = numbers[0].doubleValue(); // 입력된 반지름 값 저장
        double result = radius * radius * PI; // 원의 넓이 계산

        // double → Double → T 타입 변환
        resultList.add((T) Double.valueOf(result)); // double을 Double로 변환하여 저장
        return (T) Double.valueOf(result); // 결과를 T 타입으로 반환
    }
}
