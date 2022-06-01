package questions.arrays;

import java.util.Arrays;

/*
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums,
return true if the given array is monotonic, or false otherwise.

Example 1:
Input: nums = [1,2,2,3]
Output: true

Example 2:
Input: nums = [6,5,4,4]
Output: true

Example 3:
Input: nums = [1,3,2]
Output: false

Constraints:
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5
 */
public class _896_Monotonic_Array {

    public static void main(String[] args) {

        //int[] nums = {1,2,2,3,3,4,4,7,9,42,40};
        int[] nums = {2, 2, 2, 2, 2, 2, 2, 2, 2};

        System.out.println(Arrays.toString(nums));
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {

        if (nums.length < 2) {
            return true;
        }
        boolean increasing = false;
        boolean decreasing = false;
        boolean isMystery = true;

        for (int i = 1; i < nums.length; i++) {

            while ((i < nums.length - 1) && nums[i - 1] == nums[i]) { // advance until Tie break is found
                i++;
            }
            if (isMystery && nums[i - 1] < nums[i]) {
                increasing = true;
                isMystery = false;
            }
            if (isMystery && nums[i - 1] > nums[i]) {
                decreasing = true;
                isMystery = false;
            }
            if (increasing && nums[i - 1] > nums[i]) {
                return false;
            }
            if (decreasing && nums[i - 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }

}
