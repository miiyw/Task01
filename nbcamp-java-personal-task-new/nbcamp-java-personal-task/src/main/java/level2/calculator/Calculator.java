package level2.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    protected List<Double> resultList; // 연산 결과와 원의 넓이를 저장하는 리스트

    // 기본 생성자 구현
    public Calculator() {
        this.resultList = new ArrayList<>(); // 사칙 연산 결과 저장 리스트 초기화
    }

    // Getter 메서드 구현
    public List<Double> getResultList() {
        return new ArrayList<>(this.resultList);
    }

    // Setter 메서드 구현
    public void setResultList(List<Double> newResultList) {
        this.resultList = new ArrayList<>(newResultList); // 리스트 복사본으로 안전한 수정이 가능하게 함
    }

    // 저장된 연산 결과를 조회하는 메서드 구현
    public void inquiryResults() {
        System.out.print("저장된 연산 결과: ");
//        for (double number : resultList) { // 향상된 for문 사용하여 연산 결과 출력
//            System.out.print(number + " / ");
//        }
        for (double number : resultList) {
            System.out.printf("%.2f / ", number); // 소수점 둘째 자리까지 출력
        }
        System.out.println();
        System.out.println();
    }
}