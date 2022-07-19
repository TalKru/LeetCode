package questions.arrays;

import java.util.Arrays;

/*
Given an integer array nums,
return the largest perimeter of a triangle with a non-zero area,
formed from three of these lengths.
If it is impossible to form any triangle of a non-zero area, return 0.

Example 1:
Input: nums = [2,1,2]
Output: 5

Example 2:
Input: nums = [1,2,1]
Output: 0

Constraints:
3 <= nums.length <= 104
1 <= nums[i] <= 106
 */
public class _976_Largest_Perimeter_Triangle {

    public static int largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        for (int i = nums.length - 1; (i - 2) >= 0 ; i--) { // "i - 2 >= 0" condition for not exceeding when check nums[i - 2]

            if (nums[i-1] + nums[i-2] > nums[i]) {
                return (nums[i] + nums[i-1] + nums[i-2]);
            }
        }
        return 0;
    }
}
