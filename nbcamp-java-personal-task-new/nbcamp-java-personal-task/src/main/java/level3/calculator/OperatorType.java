package level3.calculator;

public enum OperatorType {
    ADD('+'),  SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/'), MOD('%');
    final private char operate; // 필드 추가

    // 생성자
    OperatorType(char operate) {
        this.operate = operate;
    }

    // 메서드
    public char getOperate() {
        return operate;
    }
}
