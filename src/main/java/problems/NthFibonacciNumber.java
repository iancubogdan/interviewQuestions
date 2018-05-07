package problems;

import java.util.Scanner;

public class NthFibonacciNumber {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    while (testCases-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n+1];
      arr[0] = 0;
      arr[1] = 1;
      for (int i = 2; i <= n; i++) {
        int result = arr[i-2] + arr[i-1];
        arr[i] = result > 1000000007 ? result % 1000000007 : result;
      }
      System.out.println(arr[n]);
    }
  }
}
