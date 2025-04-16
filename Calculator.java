import java.lang.*;
import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {

    double operand1, operand2;

    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter operand1, operand2 and operator:");

    operand1 = userInput.nextDouble();
    operand2 = userInput.nextDouble();

    char operator = userInput.next().charAt(0);
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
