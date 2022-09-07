package questions.arrays;

import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
 */
public class _34_Find_First_Last_Position_Element_Sorted_Array {

    public static void main(String[] args) {

        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Input Target: " + target);

        int[] res = searchRange(arr, target);
        System.out.println("Result: " + Arrays.toString(res));
    }

    public static int[] searchRange(int[] arr, int target) {

        int tStrat = find(target, arr, 0);

        if (tStrat == arr.length || arr[tStrat] != target) {
            return new int[] {-1, -1};
        }
        int[] res = new int[2];
        res[0] = tStrat;
        res[1] = find(target + 1, arr, tStrat) - 1;
        return res;
    }

    private static int find(int target, int[] arr, int start) {

        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + ((end - start) / 2);

            if (arr[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return start;
    }

}
