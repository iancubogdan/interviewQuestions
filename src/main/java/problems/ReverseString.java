package problems;

import java.util.Stack;

public class ReverseString {


  public static void reverse(StringBuffer s){
    LinkedListStack<Character> stack = new LinkedListStack();
    for (int i = 0; i < s.length(); i++) {
      stack.push(s.charAt(i));
    }
    for (int i = 0; i < s.length(); i++) {
      s.setCharAt(i, stack.pop());
    }
  }

  public static void main(String[] args) {
    //create a new string
    StringBuffer  s= new StringBuffer("GeeksforGeeks");

    //call reverse method
    reverse(s);

    //print the reversed string
    System.out.println("Reversed string is : " + s);
  }

}
