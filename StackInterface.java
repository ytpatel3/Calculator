interface Stack<T> {

  void push(T item);  // Push an item onto the stack

  T pop();  // Pop an item from the stack

  T peek();  // Peek at the top item of the stack without removing it

  boolean isEmpty();  // Check if the stack is empty

}