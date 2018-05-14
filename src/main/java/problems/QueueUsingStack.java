package problems;

import java.util.Stack;

public class QueueUsingStack {
  static class Queue  {
    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;
  }

  static void push(Stack<Integer> top, int data) {
    top.push(data);
  }

  static int pop(Stack<Integer> top) {
    if (top.isEmpty()) {
      System.out.println("StackUnderflow");
      System.exit(0);
    }
    return top.pop();
  }

  void enQueue(Queue q, int data) {
    push(q.stack1, data);
  }

  int deQueue(Queue q) {
    int x;
    if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
      System.out.println("Queue is empty");
      System.exit(0);
    }

    if (q.stack2.isEmpty()) {
      while (!q.stack1.isEmpty()) {
        push(q.stack2, pop(q.stack1));
      }
    }
    return pop(q.stack2);
  }
}
