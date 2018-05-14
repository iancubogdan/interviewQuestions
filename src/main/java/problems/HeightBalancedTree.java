package problems;

import java.util.Map;

/**
 * Created by iancu on 5/14/2018.
 */
public class HeightBalancedTree {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Height {
        int height = 0;
    }

    static class BinaryTree {
        Node root;

        boolean isBalanced(Node node) {
            int lh, rh;

            if (node == null) {
                return true;
            }
            lh = height(node.left);
            rh = height(node.right);

            if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
                return true;
            }
            return false;
        }

        boolean isBalanced(Node root, Height height) {
            if (root == null) {
                height.height = 0;
                return true;
            }

            Height lheight = new Height(), rheight = new Height();
            boolean l = isBalanced(root.left, lheight);
            boolean r = isBalanced(root.right, rheight);
            int lh = lheight.height, rh = rheight.height;

            height.height = Math.max(lh, rh) + 1;

            if(Math.abs(lh - rh) > 1) {
                return false;
            }
            else {
                return l && r;
            }
        }

        private int height(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static void main(String args[])
    {
//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//        tree.root.left.left.left = new Node(8);
//
//        if(tree.isBalanced(tree.root))
//            System.out.println("Tree is balanced");
//        else
//            System.out.println("Tree is not balanced");

        Height height = new Height();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

//                tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//        tree.root.left.left.left = new Node(8);

        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
