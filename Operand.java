//operand class

public class Operand extends Token {

  private int val;
  
  //constructor
  public Operand(int value) {
    val = value;
  }

  public int getValue() {
    return val;
  }

  boolean isOperator() {
    return false; //operand is not an operator
  }


}