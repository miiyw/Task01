package level1.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 양의 정수를 입력받으라는 조건 추가함
        int num1;
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = sc.nextInt();
            if (num1 >= 0) break; // 양수만 입력받기 위한 조건
            System.out.println("음수는 입력할 수 없습니다.");
        }

        int num2;
        while (true) {
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = sc.nextInt();
            if (num2 >= 0) break; // 양수만 입력받기 위한 조건
            System.out.println("음수는 입력할 수 없습니다.");
        }

        System.out.println("num1 = " + num1 + ", num2 = " + num2);
    }
}