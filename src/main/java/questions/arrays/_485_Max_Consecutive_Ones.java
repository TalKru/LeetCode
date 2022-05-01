package questions.arrays;
/*
Given a binary array nums, return the 
maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits 
are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
 
Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
*/
public class _485_Max_Consecutive_Ones {

	public static void main(String[] args) {

		int[] arr = {1,1,0,1,1,1};
		
		System.out.println("maximum number of consecutive 1's in the array: " + findMaxConsecutiveOnes(arr));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			currSum += nums[i];
			
			maxSum = Math.max(maxSum, currSum);
			
			if(nums[i] == 0) { currSum = 0; }
		}
		return maxSum;
	}
}
