import java.util.Scanner;

public class Calculator {
    private double a,b;
    private char calc;
    private Scanner fsc;
    public boolean error = false;

    public Calculator(double a, char calc, double b) {
        this.a = a;
        this.b = b;
        this.calc = calc;
        this.fsc = new Scanner(System.in);
    }

    public String calculate() {
        error = false;

        switch (calc) {
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '*':
                return String.valueOf(a * b);
            case '/':
                if (b == 0) {
                    error = true;
                    return "0으로 나눌 수 없습니다.\n";
                } else {
                    return String.valueOf(a / b);
                }
            case '%':
                if (b == 0) {
                    error = true;
                    return "0으로 나눌 수 없습니다.\n";
                } else {
                    return String.valueOf(a % b);
                }
            case '^':
                if (a < 0 && b % 2 == 0) {
                    a *= -1;
                    return Math.pow(a, b) + "i";
                } else
                    return String.valueOf(Math.pow(a, b));
            default:
                return "다시 입력하세요\n";
        }
    }

    public boolean exit() {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        String ex = fsc.nextLine();
        return ex.equals("exit");
    }
}
