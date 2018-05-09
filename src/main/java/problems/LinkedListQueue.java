package problems;

public class LinkedListQueue<E> {

  class QNode<E> {
    E key;
    QNode<E> next;

    public QNode(E key) {
      this.key = key;
      this.next = null;
    }
  }

  QNode<E> front, rear;

  public LinkedListQueue() {
    front = rear = null;
  }

  void enqueue (E key) {
    QNode<E> temp = new QNode<>(key);
    if (rear == null) {
      front = rear = temp;
      return;
    }
    rear.next = temp;
    rear = temp;
  }

  QNode<E> dequeue() {
    if (front == null) {
      return null;
    }
    QNode<E> temp = front;
    front = front.next;

    if (front == null) {
      rear = null;
    }
    return temp;
  }

  public static void main(String[] args) {
    LinkedListQueue<Integer> q=new LinkedListQueue();
    q.enqueue(10);
    q.enqueue(20);
    q.dequeue();
    q.dequeue();
    q.enqueue(30);
    q.enqueue(40);
    q.enqueue(50);

    System.out.println("Dequeued item is "+ q.dequeue().key);
  }
}
