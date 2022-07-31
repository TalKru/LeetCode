package questions.arrays;

/*
Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray
[numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target.
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4
 */
public class _209_Minimum_Size_Subarray_Sum {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int res = minSubArrayLen(target, nums);

        System.out.println(res);
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (end < n) {
            sum += nums[end];
            end++;

            if (sum >= target) {
                minLen = Math.min(minLen, end - start);
                end--;
                sum -= nums[end]; // restore
                sum -= nums[start];
                start++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
