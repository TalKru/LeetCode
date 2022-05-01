package arrays;

import java.util.Arrays;
import java.util.HashSet;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */
public class _136_Single_Number {

	public static void main(String[] args) {

		int[] arr = {4,1,2,1,2};

		System.out.println("Input" + Arrays.toString(arr));

		int unique = singleNumber(arr);

		System.out.println("unique in the array: " + unique);

	} // main



	/*
	Bit Manipulation - Using XOR

	If we take XOR of zero and some bit, it will return that bit
	a ^ 0 = a

	If we take XOR of two same bits, it will return 0
	a ^ a = 0

	XOR operator is commutative
	a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b

	So we can XOR all bits together to find the unique number.

	Time complexity: O(n)
	Space complexity: O(1)
	 */
	public static int singleNumber(int[] nums) {

		int result = 0;

		for(int n : nums) {
			result ^= n;
		}
		return result;
	}



	/* 
	 * Add every new element to the HshSet, 
	 * for each repeating element do not add it, 
	 * but remove the original, 
	 * this way in the end only unique elements will remain 
	 * */
	//	public static int singleNumber(int[] nums) {
	//
	//		HashSet<Integer> set = new HashSet();
	//
	//		for (int i = 0; i < nums.length; i++) {
	//
	//			if(set.contains(nums[i])) {           // O(1)
	//				set.remove(nums[i]);              // O(1)
	//			}
	//			else {
	//				set.add(nums[i]);                 // O(1)
	//			}
	//		}
	//		return set.iterator().next();
	//	}

}





