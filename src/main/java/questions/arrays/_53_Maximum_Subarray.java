package questions.arrays;

import java.util.Arrays;

/*
	Given an integer array nums, find the contiguous subarray 
	(containing at least one number) which has the largest sum and return its sum.
	A subarray is a contiguous part of an array.
	
	Example 1:
	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	
	Example 2:
	Input: nums = [1]
	Output: 1
	
	Example 3:
	Input: nums = [5,4,-1,7,8]
	Output: 23
	 
	
	Constraints:
	1 <= nums.length <= 105
	-104 <= nums[i] <= 104
*/


public class _53_Maximum_Subarray {

	public static void main(String[] args) {
		
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] arr = {-1};
		//int[] arr = {-2,1};
		//int[] arr = {};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(maxSubArray(arr));

	}

	public static int maxSubArray(int[] nums) {
		
		int bestSum = Integer.MIN_VALUE;
		int tempSum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			tempSum += nums[i];
			
			if(tempSum > bestSum) {
				bestSum = tempSum;
			}
			if(tempSum < 0) {
				// reset
				tempSum = 0;
			}
		}
		return bestSum;
	}
}
