import java.lang.*;
import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {

    double operand1, operand2;

    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter operand1:");
    operand1 = userInput.nextDouble();
    System.out.println("Enter operator:");
    char operator = userInput.next().charAt(0);
    System.out.println("Enter operand2:");
    operand2 = userInput.nextDouble();
    if (operand1 < -9999 || operand1 > 9999) {
        System.out.println("Illegal argument, try again");
        return;
    }
    double result = 0;

    switch(operator) {
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
