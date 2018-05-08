package problems;

public class LinkedListStack<T> {

  class StackNode<T> {
    T data;
    StackNode next;

    public StackNode(T data) {
      this.data = data;
      next = null;
    }

    T getData() {
      return data;
    }
  }

  private StackNode<T> first;
//  private static int size = 0;


  public LinkedListStack() {
    first = null;
  }

  public void push(T data) {
    StackNode node = new StackNode(data);
    node.next = first;
    first = node;
//    size++;
  }

  public T pop() {
    if (isEmpty()) {
      System.out.println("Stack Underflow");
      return null;
    }
    T value = first.data;
    first = first.next;
    return value;
  }

  public T peek() {
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public static void main(String[] args) {
    LinkedListStack<Integer> stack = new LinkedListStack();
    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println("Popped : " + stack.pop());
    System.out.println("Top element is : " + stack.peek());

    System.out.println("isEmpty: " + stack.isEmpty());
    stack.pop();
    stack.pop();
    System.out.println("isEmpty: " + stack.isEmpty());
    stack.pop();

  }
}
