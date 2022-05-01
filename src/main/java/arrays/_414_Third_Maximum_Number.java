package arrays;

import java.util.Arrays;

/*
Given an integer array nums, return the third distinct maximum number
 in this array. If the third maximum does not exist, 
 return the maximum number.

Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:
Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

Constraints:
1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1
 */
public class _414_Third_Maximum_Number {

	public static void main(String[] args) {

		int[] nums = {1,2,2,5,3,5};
		//int[] nums = {2,2,3,1};
		//int[] nums = {1,2,2,5,3,5};
		//int[] nums = {1,2,-2147483648};

		int res = thirdMax(nums);

		System.out.println("Input array" + Arrays.toString(nums));
		System.out.println("Third max number: " + res);
	}


	public static int thirdMax(int[] nums) {

		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;

		for (Integer n : nums) {
			
			if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;

			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} 
			else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} 
			else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		
		if(max3 == null) {
			return max1;
		}
		else { 
			return max3;
		}
	}
}















