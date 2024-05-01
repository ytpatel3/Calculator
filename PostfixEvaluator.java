import java.util.*;
import java.io.*;

//PostfixEvaluator will evaluate the postfix expression derived from the InfixToPostfixConverter class

public class PostfixEvaluator {

  public static int evaluate(List<Token> postfix) {

    // operand stack of integers
    Stack<Integer> operandStack = new ArrayListStack<>();

    // iterate through each token in the postfix expression
    for (Token t : postfix) {

      // if the token is an operand, push it onto the operands stack
      if (t instanceof Operand) {
        operandStack.push(((Operand) t).getValue());
      }
      // if the token is an operator, apply the operator to operands
      else {
        char op = ((Operator) t).getOperator();
        // Pop two operands from the stack
        int op2 = operandStack.pop();
        int op1 = operandStack.pop();
        // Apply the operator to the operands and push the result onto the stack
        operandStack.push(applyOperation(op, op1, op2));
      }
    }

    // The final result is the only element remaining on the operands stack
    return operandStack.pop();
  }

  // Apply operator to operands
  private static int applyOperation(char operator, int operand1, int operand2) {
    switch (operator) {
      case '+':
        return operand1 + operand2;
      case '-':
        return operand1 - operand2;
      case '*':
        return operand1 * operand2;
      case '/':
        return divide(operand1, operand2); // Integer division; might implement exact division in the future
      default:
        throw new IllegalArgumentException("\nInvalid operator.");
    }
  }

  // this method will ensure that the user cannot divide by 0 and will keep asking
  // for a new divisor until user enters a number that isn't 0
  public static int divide(int dividend, int divisor) {
    Scanner scanner = new Scanner(System.in);
    if (divisor == 0) {
      System.out.println("\nDivision by zero is not allowed.");
      int newDivisor;
      do {
        System.out.print("Enter a new divisor: ");
        while (!scanner.hasNextInt()) {
          System.out.println("Invalid input. Please enter a valid integer divisor.");
          scanner.next();
        }
        newDivisor = scanner.nextInt();
      } while (newDivisor == 0);
      return dividend / newDivisor;
    } else {
      return dividend / divisor;
    }

  }

}