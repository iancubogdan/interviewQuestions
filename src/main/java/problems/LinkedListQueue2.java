package problems;

public class LinkedListQueue2<E> {

  class QNode<E> {
    E key;
    QNode<E> previous;

    public QNode(E key) {
      this.key = key;
      this.previous = null;
    }
  }

  QNode<E> front;

  public LinkedListQueue2() {
    front = null;
  }

  void enqueue (E key) {
    QNode<E> temp = new QNode<>(key);
    if (front == null) {
      front = temp;
      return;
    }
    front.previous = temp;
  }

  QNode<E> dequeue() {
    if (front == null) {
      return null;
    }
    QNode<E> temp = front;
    front = front.previous;
    return temp;
  }


  public static void main(String[] args) {
    LinkedListQueue2<Integer> q=new LinkedListQueue2();
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
