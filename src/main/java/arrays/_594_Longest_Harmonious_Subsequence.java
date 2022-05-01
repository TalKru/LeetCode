package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
We define a harmonious array as an array where the difference 
between its maximum value and its minimum value is exactly 1.
Given an integer array nums, return the length of its longest 
harmonious subsequence among all its possible subsequences.
A subsequence of array is a sequence that can be derived from 
the array by deleting some or no elements without changing the 
order of the remaining elements.

Example 1:
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Example 2:
Input: nums = [1,2,3,4]
Output: 2

Example 3:
Input: nums = [1,1,1,1]
Output: 0
 */
public class _594_Longest_Harmonious_Subsequence {

	public static void main(String[] args) {

		int[] arr = {1,3,2,2,5,2,3,7};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(findLHS(arr));
	}

	
	
	public static int findLHS(int[] nums) {
		
		HashMap<Long, Integer> map = new HashMap<>();
		
	    for (long num : nums) {
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	    int result = 0;
	    
	    for (long key : map.keySet()) {
	    	
	        if (map.containsKey(key + 1)) {
	            result = Math.max(result, map.get(key + 1) + map.get(key));
	        }
	    }
	    return result;
	}
}



