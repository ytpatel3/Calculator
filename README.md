# Calculator

  - Unary operators (as in -2) are illegal.
  - All operations, including division, are integer operations.
  - The input expression contains no embedded spaces and no illegal characters, since it is entered
  by using a keypad.
  - The input expression is a syntactically correct infix expression.
  - Division by zero will not occur.
  - The calculator has a display and a keypad of 20 keys, which are arranged as follows:
       C < Q /
       7 8 9 *
       4 5 6 −
       1 2 3 +
       0 ( ) =


How to Use the Program:

1. Input Infix Expression: The user should input one by one in the command prompt a mathematical operator, operand, or the other calculator keys (0-9, +, -, *, /, C, Q, ). Program is designed to only allow single digit calculations.
2. Evaluation: The program will convert the infix expression to postfix notation and provide the result in the “Display: “ line.
3. Handling Division By Zero: If there is an attempt to divide by zero in the expression, the program will throw an error to let the user know that division by zero is not allowed.
4. Repeat or Exit: The program will continue to prompt the user for infix expressions until the user decides to exit the program by entering a specific command like 'Q'.

How the Program Works:
This program consists of multiple Java classes that work together to convert an infix expression to a postfix expression and then evaluate the postfix expression.

1. StackInterface: This interface defines the basic operations of a stack data structure, such as push, pop, peek, and isEmpty.
2. ArrayListStack: This class implements the Stack interface using an ArrayList to create a stack data structure. It provides methods to push, pop, peek, and check if the stack is empty.
3. Token: This abstract class checks if a token is an operator. It also includes a static method ‘divide’ to handle division by zero by throwing an ArithmeticException.
4. InfixToPostfixConverter: This class converts an infix mathematical expression to a postfix expression using the shunting yard algorithm, which involves using stacks to manage operators and operands.
5. PostfixEvaluator: This class evaluates a postfix expression by iterating through each token (operand or operator) in the expression and performing the corresponding operation, such as addition, subtraction, multiplication, or division. If a division by zero is encountered, it throws an exception.
6. Main: This class contains the main method where the program execution begins. It takes user input for infix expressions, converts them to postfix using InfixToPostfixConverter, evaluates the postfix expression using PostfixEvaluator, and displays the result.
   
