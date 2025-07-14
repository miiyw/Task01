package level2.calculator;

import java.util.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InvalidOperatorException, DivideByZeroException {
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator(); // Calculator 인스턴스 생성 // 연산 결과가 무한으로 저장될 수 있는 리스트 생성

        while(true) {
            try {
                int num1;
                while (true) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    if (sc.hasNextInt()) { // 입력한 값이 정수인지 확인
                        num1 = sc.nextInt();
                        if (num1 >= 0) break; // 0 이상이면 반복 종료
                        else System.out.println("음수는 입력할 수 없습니다.");
                    } else { // 정수가 아닌 경우
                        System.out.println("숫자만 입력 가능합니다.");
                        sc.next(); // 잘못된 입력을 소비하고 다음 반복으로 이동
                    }
                }

                int num2;
                while (true) {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    if (sc.hasNextInt()) { // 입력한 값이 정수인지 확인
                        num2 = sc.nextInt();
                        if (num2 >= 0) break; // 0 이상이면 반복 종료
                        else System.out.println("음수는 입력할 수 없습니다.");
                    } else { // 정수가 아닌 경우
                        System.out.println("숫자만 입력 가능합니다.");
                        sc.next(); // 잘못된 입력을 소비하고 다음 반복으로 이동
                    }
                }

                System.out.print("사칙 연산 기호를 입력하세요: "); // +, -, *, /
                char operator = sc.next().charAt(0); // 사칙 연산 기호를 적합한 타입으로 선언한 변수에 저장
                // charAt(0): 문자열의 0번째 위치에 있는 문자(첫 글자) 반환

                int result = calc.calculate(num1, num2, operator);
                System.out.println("결과: " + result + "\n");
            } catch (DivideByZeroException | InvalidOperatorException e) { // 콘솔에 예외 처리 메시지 출력할 수 있도록 처리
                System.out.println("! 예외 발생: " + e.getMessage() + "\n");
                continue; // 예외 발생 시 처음으로 다시 입력받기
            }

            // 반복 여부 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.next();
            if (input.trim().equals("exit")) { // 입력값이 "exit"면 반복 종료
                break;
            }
            System.out.println();
        }
    }
}