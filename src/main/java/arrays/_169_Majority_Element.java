package arrays;

import java.util.Arrays;

/*
	Given an array nums of size n, return the majority element.
	
	The majority element is the element that appears more than ⌊n / 2⌋ times. 
	You may assume that the majority element always exists in the array.
	
	
	Example 1:
	Input: nums = [3,2,3]
	Output: 3
	
	Example 2:
	Input: nums = [2,2,1,1,1,2,2]
	Output: 2
	 
	Constraints:
	n == nums.length
	1 <= n <= 5 * 104
	-231 <= nums[i] <= 231 - 1
	 
	Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class _169_Majority_Element {

	public static void main(String[] args) {
		
		int[] arr = {2,2,1,1,1,2,2};
		
		System.out.println(majorityElement(arr));
	} // main
	

	
	/* candidate repeat counter */
	public static int majorityElement(int[] nums) {
		
		int repeats = 1;   
		int cand = nums[0]; // candidate
		
		for (int i = 1; i < nums.length; i++) { // i = 1, cand inits to first element
			
			if(cand == nums[i]) {
				repeats++;
			}
			else { repeats--; }
			
			if(repeats == 0) { // we have new candidate!
				cand = nums[i];
				repeats = 1;
			}
		}
		return cand;
	}
	
	
	
	
	/* 
	 When arrays is sorted and also the majority element appears more than (n/2)+ times
	 an overlapping occurs which promise 
	 that we hit the element in the middle no matter how its spread across the array
	 when it sorted!
	 
	        input:      	[3][3][1][7][3][3][4][3]  length = 8 ->  n = 5 (or more)  
	        sorted:		    [1][3][3][3][3][3][4][7]
	        5 cell overlap  [1][2][3][4][5]
	        5 cell overlap     [1][2][3][4][5]
	        5 cell overlap        [1][2][3][4][5]
	        5 cell overlap           [1][2][3][4][5]
	                                 |    |
	        (cells that              [x][x]            can be accessed as array[n/2]
	        will always contain 
	        this element)
	  */
//	public static int majorityElement(int[] nums) {
//		
//		Arrays.sort(nums);
//		return nums[nums.length/2];
//	}
	
	
	
	
} // class










