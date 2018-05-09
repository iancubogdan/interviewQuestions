package problems;

public class ArrayQueue {
  int front, rear, size;
  int capacity;
  int array[];

  public ArrayQueue(int capacity) {
    this.capacity = capacity;
    front = this.size = 0;
    rear = capacity - 1;
    array = new int[capacity];
  }

  boolean isFull() {
    return size == capacity;
  }

  boolean isEmpty() {
    return (size == 0);
  }

  void enqueue(int item) {
    if (isFull()) {
      return;
    }
    rear = (rear + 1) % capacity;
    array[rear]  = item;
    size++;
    System.out.println(item + " enqueued to queue");
  }

  int dequeue() {
    if (isEmpty()) {
      return Integer.MIN_VALUE;
    }

    int item = array[front];
    front = (front + 1) % capacity;
    size --;
    return item;
  }

  int front() {
    if (isEmpty())
      return Integer.MIN_VALUE;

    return array[front];
  }

  // Method to get rear of queue
  int rear() {
    if (isEmpty())
      return Integer.MIN_VALUE;

    return this.array[rear];
  }

  public static void main(String[] args) {
    ArrayQueue queue = new ArrayQueue(1000);

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);

    System.out.println(queue.dequeue() +
        " dequeued from queue\n");

    System.out.println("Front item is " +
        queue.front());

    System.out.println("Rear item is " +
        queue.rear());
  }
}
