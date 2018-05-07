package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OccurencesOfAnagrams {
  public static void runTestCase(String text, String word) {
    int wordLength = word.length();
    int anagramCount = 0;
    for (int i = 0; i <= text.length() - wordLength; i++) {
      if (isAnagram(text.substring(i, i+wordLength), word)) {
        anagramCount++;
      }
    }
    System.out.println(anagramCount);

  }

  public static boolean isAnagram(String text, String word) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < text.length(); i++) {
      Character c = text.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c)+1);
      } else {
        map.put(c, 1);
      }
    }
    for (int i = 0; i < word.length(); i++) {
      Character c = word.charAt(i);
      if (map.containsKey(c)) {
        if (map.get(c) == 0) {
          return false;
        } else {
          map.put(c, map.get(c)-1);
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for (int i = 0; i < testCases; i++) {
      runTestCase(in.next(), in.next());
    }
  }
}
