package questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/*
Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers 
in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]

Constraints:
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime?
You may assume the returned list does not count as extra space.
 */
public class _448_Find_All_Numbers_Disappeared_in_Array {

	public static void main(String[] args) {

		int[] nums = {4,3,2,7,8,2,3,1};

		System.out.println(Arrays.toString(nums));

		List<Integer> missingFromRange = findDisappearedNumbers(nums);

		System.out.println(missingFromRange.toString());
	}
	
	
	// O(n)
	public static List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> leftNums = new ArrayList<>();
		
		boolean[] visited = new boolean[nums.length];
		
		for (int num : nums) {
			visited[num-1] = true;
		}
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				leftNums.add(i+1);
			}
		}
		return leftNums;
	}

	// O(n)
	public static List<Integer> findDisappearedNumbers2(int[] nums) {

		List<Integer> leftNums = new ArrayList<>();

		HashSet<Integer> set = new HashSet<>();

		for (Integer i : nums) {
			set.add(i);
		}

		for (int i = 1; i <= nums.length; i++) { // i = [1, n]

			if(!set.contains(i)) {
				leftNums.add(i);
			}
		}
		return leftNums;
	}

	// second option, more creative, fill all numbers in range, 
	// then delete those which appear in original array
	public static List<Integer> findDisappearedNumbers3(int[] nums) {

		List<Integer> leftNums = new ArrayList<>();

		for (int i = 1; i <= nums.length; i++) { // i = [1, n]
			leftNums.add(i);
		}
		for (Integer i : nums) {
			leftNums.remove(i);
		}
		return leftNums;
	}
}
















