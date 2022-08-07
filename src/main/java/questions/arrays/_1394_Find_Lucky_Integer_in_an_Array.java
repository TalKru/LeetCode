package questions.arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers arr,
a lucky integer is an integer that has a frequency
in the array equal to its value.
Return the largest lucky integer in the array.
If there is no lucky integer return -1.

Example 1:
Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:
Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:
Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.

Constraints:
1 <= arr.length <= 500
1 <= arr[i] <= 500
 */
public class _1394_Find_Lucky_Integer_in_an_Array {

    public static void main(String[] args) {

        int[] arr = {1,2,2,3,3,3};
        int res = findLucky(arr);

        System.out.println("Find_Lucky_Integer_in_an_Array: " + res);
    }


    public static int findLucky(int[] arr) {

        int maxLucky = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {

            int currFreq = map.getOrDefault(n, 0);

            map.put(n, currFreq + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getKey() == entry.getValue() && entry.getValue() > maxLucky) {
                maxLucky = entry.getValue();
            }
        }
        return maxLucky;
    }
}
