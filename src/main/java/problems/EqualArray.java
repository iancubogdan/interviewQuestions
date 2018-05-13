package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iancu on 5/13/2018.
 */
public class EqualArray {
    public static boolean areEqual(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        if (n != m) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!map.containsKey(arr2[i])) {
                return false;
            }
            if (map.get(arr2[i]) == 0) {
                return false;
            }
            map.put(arr2[i], map.get(arr2[i]) - 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(arr2[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args)
    {
        int arr1[] = { 3, 5, 2, 5, 2};
        int arr2[] = { 2, 3, 5, 5, 2};

        if (areEqual(arr1, arr2))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
