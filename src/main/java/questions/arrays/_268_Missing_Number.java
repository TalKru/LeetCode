package questions.arrays;

import java.util.Arrays;

/*
Given an array nums containing n distinct numbers in the range [0, n], 
return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, 
so all numbers are in the range [0,3]. 
2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, 
so all numbers are in the range [0,2]. 
2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, 
so all numbers are in the range [0,9]. 
8 is the missing number in the range since it does not appear in nums.

Constraints:
n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
All the numbers of nums are unique.
 */
public class _268_Missing_Number {

	public static void main(String[] args) {

		int[] arr = {9,6,4,2,3,5,7,0,1};
		int res = missingNumber(arr);
		//int res = missingNumber2(arr);
		//int res = missingNumber3(arr);
		System.out.println("The missing number: " + res);
	}
	
	// O(n) , using Gauss sum 1+2+...+n = n*(1+n)/2
	public static int missingNumber(int[] nums) {
		
		int sum = 0;
		for(int var : nums) {
			sum += var;
		}
		return (nums.length+1) * (nums.length)/2 - sum; // Gauss
	}
	
	// O(n), creating boolean array to represent all the numbers from the range
	// this is possible due to that range contains only distinct numbers 
	// and starts at [0, n]
	public static int missingNumber2(int[] nums) {
		
		boolean[] missArr = new boolean[nums.length + 1]; // +1 for the missing number
		
		for (int i = 0; i < nums.length; i++) {
			missArr[nums[i]] = true; // mark not missing
		}
		for (int i = 0; i < missArr.length; i++) {
			if(missArr[i] == false) { // found missing number
				return i;
			}
		}
		return -1;
	}
	
	// O(nlog(n)), using sort, simple
	public static int missingNumber3(int[] nums) {
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length-1; i++) {
			if( (nums[i]+1) != nums[i+1] ) {
				return (nums[i]+1);
			}
		}
		if(nums[0] != 0) {
			return 0;
		}
		else {
			return nums[nums.length-1]+1;
		}
	}
}














