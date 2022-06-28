package questions.arrays;

import java.util.Arrays;

/*
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white,
and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class _75_Sort_Colors {

    public static void main(String[] args) {

        int[] arr = {2,0,2,1,0,2,2,0,0,0,1,0,2,1,0};

        System.out.println("\033[0;33m" + Arrays.toString(arr));
        sortColors(arr);
        System.out.println("\033[0;36m" + Arrays.toString(arr));
    }


    public static void sortColors(int[] nums) {

        int zeroPtr = 0;
        int twoPtr = nums.length - 1;
        int i = 0;

        while( i <= twoPtr ) {

            if( nums[i] == 0 ) {
                swap(nums, zeroPtr++, i++);
            }
            else if( nums[i] == 2) {
                swap(nums, twoPtr--, i); // NOTE! i++ will result skipping untested values
            }
            else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
