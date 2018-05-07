package problems;

import java.util.Scanner;

public class LargestPrimeFactor {

  private static void calculateMaxPrime(int n) {
    int maxInt = 0;
    while (n % 2 == 0) {
//      System.out.println(2 + " ");
      n /= 2;
      maxInt = 2;
    }
    for (int i = 3; i <= Math.sqrt(n); i+= 2) {
      while (n%i == 0) {
//        System.out.println(i + " ");
        n /= i;
        if (i > maxInt) {
          maxInt = i;
        }
      }
    }
    if (n > 2) {
      if (n > maxInt) {
        maxInt = n;
      }
//      System.out.println(n);
    }
    System.out.println(maxInt);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    while (testCases-- > 0) {
      int n = in.nextInt();
      calculateMaxPrime(n);
    }
  }
}
