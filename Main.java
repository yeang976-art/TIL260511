void main() {
    Scanner sc = new Scanner(System.in);
    boolean end = false;

    while (!end) {
        System.out.println("좌항 피연산자 입력");
        double a = sc.nextDouble();
        System.out.println("연산자 '+', '-', '*', '/', '%', '^' 중 입력");
        char calc = sc.next().charAt(0);
        System.out.println("우항 피연산자 입력");
        double b = sc.nextDouble();
        System.out.println("\n");

        // [1. 클래스 없이 구현]
        // end = calculateFunc(a, calc, b, sc);

        // [2. 클래스로 구현]
        Calculator calculator = new Calculator(a, calc, b);
        System.out.println("결과: " + calculator.calculate());
        if (!calculator.error) end = calculator.exit();
    }

    sc.close();
}

public boolean calculateFunc(double a, char calc, double b, Scanner sc) {
    switch (calc) {
        case '+':
            System.out.println("결과: " + (a + b));
            return exit(sc);
        case '-':
            System.out.println("결과: " + (a - b));
            return exit(sc);
        case '*':
            System.out.println("결과: " + (a * b));
            return exit(sc);
        case '/':
            if (b == 0) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요\n\n");
                return false;
            } else {
                System.out.println("결과: " + (a / b));
                return exit(sc);
            }
        case '%':
            if (b == 0) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요\n\n");
                return false;
            } else {
                System.out.println("결과: " + (a % b));
                return exit(sc);
            }
        case '^':
            if (a < 0 && b % 2 == 0) {
                a *= -1;
                System.out.println("결과: " + Math.pow(a, b) + "i");
            } else
                System.out.println("결과: " + Math.pow(a, b));
            return exit(sc);
        default:
            System.out.println("다시 입력하세요\n\n");
            return false;
    }
}


public boolean exit(Scanner sc) {
    sc.nextLine(); // 버퍼 비우기. 이걸 해줘야 "System.out.println("좌항 피연산자 입력")" 이 되풀이되지 않음

    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
    String ex = sc.nextLine();
    return ex.equals("exit");
}