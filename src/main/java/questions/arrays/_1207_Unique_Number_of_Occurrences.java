package questions.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*

 */
public class _1207_Unique_Number_of_Occurrences {

    public static void main(String[] args) {

        // The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
        // No two values have the same number of occurrences
        int[] arr = {1,2,2,1,1,3};

        System.out.println("Unique_Number_of_Occurrences: " + uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
             /* (num   , Occurrences) */
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            int currCount = map.getOrDefault(num, 0);

            map.put(num, currCount + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (set.contains(entry.getValue())) {
                return false;
            }
            else {
                set.add(entry.getValue());
            }
        }
        return true;
    }
}
