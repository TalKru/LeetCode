package questions.arrays;

import java.util.Arrays;

/*
Given an integer array nums, move all the even integers at the
beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */
public class _905_Sort_Array_By_Parity {

    public static void main(String[] args) {

        int[] nums = {3,1,2,4};
        // int[] nums = {0,2};

        System.out.println("\033[0;35m" + Arrays.toString(nums));
        sortArrayByParity(nums);
        System.out.println("\033[1;32m" + Arrays.toString(nums));
    }

    // [2X... ...2X+1]
    public static int[] sortArrayByParity(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            while (start < nums.length -1 && nums[start] % 2 == 0) {
                start++;
            }
            while (end >= 0 && nums[end] % 2 != 0) {
                end--;
            }
            if (start < end) {
                swap(nums, start, end);
            }
        }
        return nums;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
