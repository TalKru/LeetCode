package arrays;

import java.util.Arrays;
import java.util.HashSet;

/*
	Given an integer array nums, 
	return true if any value appears at least twice in the array, 
	and return false if every element is distinct.

	Example 1:
	Input: nums = [1,2,3,1]
	Output: true

	Example 2:
	Input: nums = [1,2,3,4]
	Output: false

	Example 3:
	Input: nums = [1,1,1,3,3,4,3,2,4,2]
	Output: true

	Constraints:
	1 <= nums.length <= 10^5
	-10^9 <= nums[i] <= 10^9
 */
public class _217_Contains_Duplicate {

	public static void main(String[] args) {

		//int[] nums = {1,2,3,1};
		//int[] nums = {1,2,3,4};
		int[] nums = {1,1,1,3,3,4,3,2,4,2};

		boolean res = containsDuplicate(nums);

		System.out.println("input: " + Arrays.toString(nums));
		System.out.println("Contains Duplicate: " + res);
	}


	// Using HashSet, O(n)
	public static boolean containsDuplicate(int[] nums) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if(set.contains(nums[i])) {
				return true;
			}
			else {
				set.add(nums[i]);
			}
		}
		return false;
	}

	// Using sort
	//	public static boolean containsDuplicate(int[] nums) {
	//		
	//		Arrays.sort(nums);
	//		
	//		for (int i = 0; i < nums.length-1; i++) {
	//			
	//			if(nums[i] == nums[i+1]) { return true; }
	//		}
	//		return false;
	//	}


}












