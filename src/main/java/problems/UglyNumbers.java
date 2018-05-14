package problems;

/**
 * Created by iancu on 5/14/2018.
 */
public class UglyNumbers {

    int maxDivide(int a, int b) {
        while(a % b == 0)
            a = a/b;
        return a;
    }

    int isUgly(int no) {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);

        return (no == 1)? 1 : 0;
    }

    int getNthUglyNo(int n) {
        int i = 1;
        int count = 1; // ugly number count

        // check for all integers until count becomes n */
        while(n > count) {
            i++;
            if(isUgly(i) == 1)
                count++;
        }
        return i;
    }

    int getNthUglyNo2(int n)
    {
        int ugly[] = new int[n];  // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;

        for(int i = 1; i < n; i++)
        {
            next_ugly_no = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2)
            {
                i2 = i2+1;
                next_multiple_of_2 = ugly[i2]*2;
            }
            if (next_ugly_no == next_multiple_of_3)
            {
                i3 = i3+1;
                next_multiple_of_3 = ugly[i3]*3;
            }
            if (next_ugly_no == next_multiple_of_5)
            {
                i5 = i5+1;
                next_multiple_of_5 = ugly[i5]*5;
            }
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no;
    }

    public static void main(String args[]) {
        UglyNumbers obj = new UglyNumbers();
        int no = obj.getNthUglyNo2(150);
        System.out.println("150th ugly no. is "+ no);
    }
}
