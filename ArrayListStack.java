import java.util.*;
import java.io.*;

//implementation of Stack using ArrayList

class ArrayListStack<T> implements Stack<T> {

  private ArrayList<T> items;

  public ArrayListStack() {
    items = new ArrayList<>();
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  //implements push, pop, peek methods from interface

  public void push(T item) {
    items.add(item);
  }

  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return items.remove(items.size() - 1);
  }

  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return items.get(items.size() - 1);
  }

}