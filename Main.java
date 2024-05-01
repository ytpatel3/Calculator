import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    // Create the display for the calculator
    StringBuilder display = new StringBuilder();
    StringBuilder currentInput = new StringBuilder();
    boolean isExpressionValid = false;

    
    System.out.println("\n\nCalculator is running.\nEnter a commands (0-9, (), =, C, Q) one at a time into the console.\n\nThis calculator can only deal with single digit numbers.\n");

    //print formatted calculator
    printCalc();

    // while loop to keep asking for commands until user enters Q
    boolean running = true;
    while (running) {
      System.out.println("\nDisplay: " + display.toString() + currentInput.toString());
      System.out.print("Command: ");
      char input = scanner.next().charAt(0);
      switch (input) {
        case 'C': //clear input
          display.setLength(0);
          currentInput.setLength(0);
          System.out.println("\nDisplay has been cleared.\n");
          isExpressionValid = false;
          //print formatted calculator
          printCalc();
          break;
        case 'c': //clear input
          display.setLength(0);
          currentInput.setLength(0);
          System.out.println("\nDisplay has been cleared.\n");
          isExpressionValid = false;
          //print formatted calculator
          printCalc();
          break;
        case '<': //backspace
          if (currentInput.length() > 0) {
            currentInput.deleteCharAt(currentInput.length() - 1);
            isExpressionValid = false;
          }
          else {
            System.out.println("\nThere is nothing to delete.");
          }
          break;
        case 'Q': //quit
          running = false;
          System.out.println("\nCalculator is shutting down.");
          break;
        case 'q': //quit
          running = false;
          System.out.println("\nCalculator is shutting down.");
          break;
        case '=': //calculate using InfixToPostfixConverter and PostfixEvaluator class methods 
          List<Token> tokens = InfixToPostfixConverter.convert(currentInput.toString());
          int result = PostfixEvaluator.evaluate(tokens);
          display.setLength(0);
          display.append(result);
          currentInput.setLength(0);
          isExpressionValid = false;
          break;
        default:
          if (isInputValid(input)) { //if the input is just a number, append to currentInput
            currentInput.append(input);
            isExpressionValid = true; // Set expression as valid after each valid input
          } else {
            System.out.println("\nInvalid key. Please use the provided keypad layout.");
            isExpressionValid = false;
          }
      }
    }
    scanner.close();

  }

  // Unary operators (as in -2) are illegal.
  private static boolean isInputValid(char input) {
    String validChars = "0123456789+-*/()";
    return validChars.indexOf(input) != -1;
  }

  public static void printCalc() {
    //print formatted calculator
    String[] layout = {
        " C < Q /",
        " 7 8 9 *",
        " 4 5 6 -",
        " 1 2 3 +",
        " 0 ( ) ="
    };
    for (String row : layout) {
        for (int i = 0; i < row.length(); i++) {
            System.out.print(row.charAt(i) + " ");
        }
        System.out.println();
    }
  }

}

/*
Output: 

Calculator is running.
Enter a commands (0-9, (), =, C, Q) one at a time into the console.

This calculator can only deal with single digit numbers.

  C   <   Q   / 
  7   8   9   * 
  4   5   6   - 
  1   2   3   + 
  0   (   )   = 

Display: 
Command: 9

Display: 9
Command: +

Display: 9+
Command: <

Display: 9
Command: -

Display: 9-
Command: (

Display: 9-(
Command: 3

Display: 9-(3
Command: *

Display: 9-(3*
Command: 2

Display: 9-(3*2
Command: )

Display: 9-(3*2)
Command: /

Display: 9-(3*2)/
Command: 3

Display: 9-(3*2)/3
Command: =

Display: 7
Command: C

Display has been cleared.

  C   <   Q   / 
  7   8   9   * 
  4   5   6   - 
  1   2   3   + 
  0   (   )   = 

Display: 
Command: Q

Calculator is shutting down.


*/
