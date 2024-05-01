//operator class

public class Operator extends Token {

  private char operator; //instance character variable for the operator

  public Operator(char op) {
    operator = op;
  }

  public char getOperator(){
    return operator;
  }

  boolean isOperator() {
    return true; //returns true if the token is an operator
  }

}