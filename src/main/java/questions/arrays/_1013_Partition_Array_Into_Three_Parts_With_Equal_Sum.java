package questions.arrays;

import java.util.Arrays;

/*
Given an array of integers arr,
return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find
indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i]
== arr[i + 1] + arr[i + 2] + ... + arr[j - 1]
== arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

Example 1:
Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

Example 2:
Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false

Example 3:
Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

Constraints:
3 <= arr.length <= 5 * 10^4
-10^4 <= arr[i] <= 10^4
 */
public class _1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {

    public static void main(String[] args) {

        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        //int[] arr = {0, 1, -1};

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.print("Partition_Array_Into_Three_Parts_With_Equal_Sum? -> ");
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {

        int sum = 0;

        for (int val : arr) {
            sum += val;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int each = sum / 3;
        int temp = 0;
        int sectors = 0;

        // count parts with right sum
        for (int j : arr) {

            temp += j;

            if (temp == each) {
                temp = 0;
                sectors++;
            }
        }
        return (sectors >= 3) ? true : false;
    }
}
