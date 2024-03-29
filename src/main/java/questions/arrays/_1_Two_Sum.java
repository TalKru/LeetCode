package questions.arrays;
/*
	Given an array of integers nums and an integer target, 
	return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, 
	and you may not use the same element twice.
	You can return the answer in any order.

	Example 1:
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

	Example 2:
	Input: nums = [3,2,4], target = 6
	Output: [1,2]

	Example 3:
	Input: nums = [3,3], target = 6
	Output: [0,1]

	Constraints:
	2 <= nums.length <= 10^4
	-10^9 <= nums[i] <= 10^9
	-10^9 <= target <= 10^9
	Only one valid answer exists.

	Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
import java.util.Arrays;
import java.util.HashMap;

public class _1_Two_Sum {

	public static void main(String[] args) {

		int[] arr = {1,5,7,6,5,10,10,0,7,9}; // [2,8]
		int target = 14;
		
		System.out.println("Input: " + Arrays.toString(arr));
		System.out.println("Target: " + target);
		
		int[] resArr = twoSum(arr, target);

		System.out.println("Two sum (indexes): " + Arrays.toString(resArr));
	} // main
	
	
	
	/* O(n) solution */
	public static int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];
		HashMap<Integer, Integer> hash = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if( hash.containsKey(nums[i]) ) {
				result[0] = i;
				result[1] = hash.get(nums[i]);
				return result;
			}
			else {
				hash.put(target - nums[i], i);
			}
		}
		return result;
	}

}





