package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonRepeatingCharacter {

//    private static char[] getCharCountArray(String s) {
//        char count[] = new char[256];
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i)]++;
//        }
//        return count;
//    }
//
//    private static int firstNonRepeating( String s) {
//        char count[] = getCharCountArray(s);
//
//        for (int i = 0; i < s.length(); i++) {
//            if (count[s.charAt(i)] == 1) {
//                return i;
//            }
//        }
//
//        return -1;
//    }

    static class CountIndex {
        int count, index;

        public CountIndex(int index) {
            this.index = index;
            this.count =1;
        }

        public void incCount() {
            count++;
        }
    }

    static final int NO_OF_CHARS = 256;

    static Map<Character, CountIndex> map = new HashMap<Character, CountIndex>(NO_OF_CHARS);

    private static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).incCount();
            } else {
                map.put(c, new CountIndex(i));
            }
        }
    }


    private static int firstNonRepeating(String str) {
        getCharCountArray(str);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)).count == 1 && result > map.get(str.charAt(i)).index) {
                result = map.get(str.charAt(i)).index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int testCases = in.nextInt();
//        while (testCases-- > 0) {
//            int n = in.nextInt();
//            String s = in.next();
//            System.out.println(firstNonRepeating(s) != -1 ? s.charAt(firstNonRepeating(s)) : -1);
//        }

            String s = "hello";
            System.out.println(firstNonRepeating(s) != -1 ? "" + s.charAt(firstNonRepeating(s)) : -1);


//        String str = "geeksforgeeks";
        int index =  firstNonRepeating(s);
//
        System.out.println(index == -1 ? "Either all characters are repeating or string " +
                "is empty" : "First non-repeating character is " +  s.charAt(index));
    }

}
