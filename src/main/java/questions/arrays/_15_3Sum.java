package questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
Given an integer array nums, return all the triplets 
[nums[i], nums[j], nums[k]] 
such that i != j, i != k, 
and j != k, 
and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
 */
public class _15_3Sum {

	public static void main(String[] args) {

		int[] nums = {-1,0,1,2,-1,-4};

		List<List<Integer>> result = threeSum(nums);
		//List<List<Integer>> result = threeSum2(nums);

		System.out.println(result.toString());
	}


	
	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if(nums.length < 3) return Collections.emptyList();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length-2; i++) { 
			
			// why not nums[i] == nums[i+1] instead?
			// the reason is if we have answer [-3] [-3] 2 1 [6]
			// and we skip this first -3, it will be lost (-3, -3, 6)
			// also, the second result (-3, 2, 1) will be captured in the same i position
			// therefore there is no need to use the second -3 once again
			// it will not yield new results but only create duplicates
			if( i > 0 && nums[i] == nums[i-1]) continue; // avoid duplicates
			
			int start = i+1;
			int end = nums.length-1;

			while(start < end) {
				int tempSum = nums[i] + nums[start] + nums[end];

				if(tempSum == 0) {
					result.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					// Never let 'start' var refer to the same value twice to avoid duplicates
			        while (start < end && nums[start] == nums[start-1]) {
			        	start++;
			        }
				}
				else if(tempSum > 0) {
					end--;
				}
				else/*(tempSum < 0)*/ {
					start++;
				}
			}
		}
		return result;
	}



	// brute force, not efficient ~O(n^3)
	public static List<List<Integer>> threeSum2(int[] nums) {

		if(nums.length < 3) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		HashSet<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {

					if(nums[i] + nums[j] + nums[k] == 0) {

						List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(temp); 
						set.add(temp); // remove duplicates
					}
				}
			}
		}
		result.addAll(set);
		return result;
	}
}


























