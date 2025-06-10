import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        double operand1, operand2;
        char operator;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter operand1:");
        while (true) {
            String operand1Input = userInput.nextLine();
            if (operand1Input.trim().isEmpty()) {
                System.out.println("Illegal argument, try again");
                System.out.println("Enter operand1:");
                continue;
            }
            try {
                operand1 = Double.parseDouble(operand1Input.trim());
            } catch (Exception e) {
                System.out.println("Illegal argument, try again");
                System.out.println("Enter operand1:");
                continue;
            }
            if (operand1 <= -9999 || operand1 >= 9999) {
                System.out.println("Valid operand range is: {-9'999 < operand < 9'999, try again}");
                System.out.println("Enter operand1:");
                continue;
            }
            break;
        }
        System.out.println("Enter operand2:");
        while (true) {
            String operand2Input = userInput.nextLine();
            if (operand2Input.trim().isEmpty()) {
                System.out.println("Illegal argument, try again");
                System.out.println("Enter operand2:");
                continue;
            }
            try {
                operand2 = Double.parseDouble(operand2Input.trim());
            } catch (Exception e) {
                System.out.println("Illegal argument, try again");
                System.out.println("Enter operand2:");
                continue;
            }
            if (operand2 <= -9999 || operand2 >= 9999) {
                System.out.println("Valid operand range is: {-9'999 < operand < 9'999, try again}");
                System.out.println("Enter operand2:");
                continue;
            }
            break;
        }
        System.out.println("Enter operator:");
        while (true) {
            String operatorInput = userInput.nextLine();
            if (operatorInput.trim().isEmpty() || operatorInput.trim().length() != 1) {
                System.out.println("Illegal operator, try again");
                System.out.println("Enter operator:");
                continue;
            }
            operator = operatorInput.trim().charAt(0);
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                System.out.println("Illegal operator, try again");
                System.out.println("Enter operator:");
                continue;
            }
            break;
        }
        double result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            case '%':
                result = operand1 % operand2;
                break;
            default:
                System.out.println("Illegal argument, try again");
        }
        System.out.println("The result is: " + result);
    }
}
