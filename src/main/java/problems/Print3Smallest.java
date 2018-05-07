package problems;

public class Print3Smallest {

  static void print3Smallest(int array[]) {
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    int thirdMin = Integer.MAX_VALUE;

    for (int i = 0; i < array.length; i++) {
      if (array[i] < firstMin) {
        thirdMin = secondMin;
        secondMin = firstMin;
        firstMin = array[i];
      } else if (array[i] < secondMin) {
        thirdMin = secondMin;
        secondMin = array[i];
      } else if (array[i] < thirdMin) {
        thirdMin = array[i];
      }
    }
    System.out.println("First min = " + firstMin );
    System.out.println("Second min = " + secondMin );
    System.out.println("Third min = " + thirdMin );
  }

  public static void main(String[] args) {
    int array[] = {4, 9, 1, 32, 12};
    print3Smallest(array);
  }

}
