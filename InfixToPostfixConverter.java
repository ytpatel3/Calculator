//this class will convert the user's infix input to postfix for faster computation
import java.util.*;
import java.io.*;

class InfixToPostfixConverter {

  //hashmap to store the precedence/priority of the operators
  private static final Map<Character, Integer> precedence = new HashMap<>();

  static { //precendecce of operators (PEMDAS)
    precedence.put('+', 1);
    precedence.put('-', 1);
    precedence.put('*', 2);
    precedence.put('/', 2);
  }

  //convert method
  public static List<Token> convert(String infix) {

    //list to store postfix expression
    List<Token> postfix = new ArrayList<>();

    //operator stack
    Stack<Character> operatorStack = new ArrayListStack<>();

    for(char c: infix.toCharArray()) { //iterate through each character in user's infix expression after converting string to an array of characters

      //if the character is a digit, immediatly add it to the postfix expression
      if(Character.isDigit(c) == true) {
        postfix.add(new Operand(Character.getNumericValue(c))); //change char c to to an operand token
      }

      //if character is an opening parentheses, immediate push it onto operator stack
      else if(c == '(') {
        operatorStack.push(c);
      }

      // If the character is ')', pop operators from the stack and add them to the postfix expression until '(' is encountered, then discard '('
      else if(c == ')') {
        //while loop to pop operators until '(' is encountered
        while((operatorStack.isEmpty() == false) && (operatorStack.peek() != '(')) {
          postfix.add(new Operator(operatorStack.pop()));
        }
        operatorStack.pop(); // discard '('
      }

      // else (when c is an operator))
      else {
        //pop operators from the stack and add them to the postfix expression, until the stack is empty or the operator at the top of the stack has lower precedence than the current operator
        while ((operatorStack.isEmpty() == false) && (precedence.getOrDefault(operatorStack.peek(), 0) >= precedence.getOrDefault(c, 0))) {
          postfix.add(new Operator(operatorStack.pop()));
        }
        // Push the current operator onto the stack
        operatorStack.push(c);
      }
    }

    // After processing all characters, pop remaining operators from the stack and add them to the postfix expression
    while (operatorStack.isEmpty() == false) {
      postfix.add(new Operator(operatorStack.pop()));
    }

    // Return the postfix expression
    return postfix;

  }



}