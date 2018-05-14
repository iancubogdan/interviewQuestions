package problems;

import java.util.Scanner;

/**
 * Created by iancu on 5/14/2018.
 */
public class ReverseStrings {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            String s = sc.next();
            String [] words = s.split("\\.");
            String rev = "";
            for(int i=words.length-1;i>0;i--)
            {
                rev += words[i]+".";

            }

            rev = rev + words[0];


            System.out.println(rev);
        }
    }
}
