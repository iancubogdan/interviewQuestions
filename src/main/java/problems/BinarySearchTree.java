package problems;

public class BinarySearchTree {

  class Node {
    int key;
    Node left, right;

    public Node(int key) {
      this.key = key;
      left = right = null;
    }
  }

  Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  void insert(int key) {
    root = insertRec(root, key);
  }

  private Node insertRec(Node root, int key) {
    if (root == null) {
      root = new Node(key);
      return root;
    }
    if (key < root.key) {
      root.left = insertRec(root.left, key);
    } else if (key > root.key) {
      root.right = insertRec(root.right, key);
    }
    return root;
  }

  void inOrder() {
    inOrderRec(root);
  }

  private void inOrderRec(Node root) {
    if (root != null) {
      inOrderRec(root.left);
      System.out.println(root.key);
      inOrderRec(root.right);
    }
  }

  public Node search(Node root, int key) {
    if (root == null || root.key == key) {
      return root;
    }
    if (root.key > key) {
      return search(root.left, key);
    }
    return search(root.right, key);
  }

  void deleteKey(int key) {
    root = deleteRec(root, key);
  }

  private Node deleteRec(Node root, int key) {
    if (root == null) {
      return root;
    }
    if (key < root.key) {
      root.left = deleteRec(root.left, key);
    } else if (key > root.key) {
      root.right = deleteRec(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      root.key = minValue(root.right);
      root.right = deleteRec(root.right, root.key);
    }
    return root;
  }

  private int minValue(Node root) {
    int minValue = root.key;
    while (root.left != null) {
      minValue = root.left.key;
      root = root.left;
    }
    return minValue;
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);

    System.out.println("Inorder traversal of the given tree");
    tree.inOrder();

    System.out.println("\nDelete 20");
    tree.deleteKey(20);
    System.out.println("Inorder traversal of the modified tree");
    tree.inOrder();

    System.out.println("\nDelete 30");
    tree.deleteKey(30);
    System.out.println("Inorder traversal of the modified tree");
    tree.inOrder();

    System.out.println("\nDelete 50");
    tree.deleteKey(50);
    System.out.println("Inorder traversal of the modified tree");
    tree.inOrder();
  }
}
