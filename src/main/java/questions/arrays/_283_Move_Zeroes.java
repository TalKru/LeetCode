package questions.arrays;

import java.util.Arrays;

/*
Given an integer array nums, move all 0's 
to the end of it while maintaining the relative order 
of the non-zero elements.
Note that you must do this in-place 
without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
public class _283_Move_Zeroes {

	public static void main(String[] args) {

		int[] arr = {0,0,1,8,8,1,0,3,12};

		System.out.println(Arrays.toString(arr));
		moveZeroes(arr);
		//moveZeroesSimple(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}


	// O(n), in place, snowball concept solution
	public static void moveZeroes(int[] nums) {

		int snowBallSize = 0;

		for (int i = 0; i < nums.length; i++) {
			
			if(nums[i] == 0) { 
				snowBallSize++;
				//continue;
			}
			else if(snowBallSize > 0) {
				int temp = nums[i];
				nums[i] = 0;
				nums[i - snowBallSize] = temp;
			}
		}
	}
	
	// O(n), in place, more simple to understand
	public static void moveZeroesSimple(int[] nums) {
			
		int cleanIndex = 0; // pointer to where to place the next non-zero element
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[cleanIndex++] = nums[i];
			}
		}
		for (int i = cleanIndex; i < nums.length; i++) { // fill the rest with 0
			nums[i] = 0;
		}
	}
	
	
	
	
	
}
















