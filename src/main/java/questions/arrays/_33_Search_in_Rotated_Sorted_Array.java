package questions.arrays;

import java.util.Arrays;

/*
There is an integer array nums sorted in ascending order 
(with distinct values).
Prior to being passed to your function, nums is possibly rotated
 at an unknown pivot index k (1 <= k < nums.length) such that 
 the resulting array is 
 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
 For example, [0,1,2,4,5,6,7] 
 might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, 
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-10^4 <= target <= 10^4
 */
public class _33_Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {

		int[] arr = {4,5,6,7,0,1,2};
		int target = 0;
		//int[] arr = {4,5,6,7,0,1,2};
		//int[] arr = {};
		//int[] arr = {};

		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("target: " + target);
		System.out.println("Index of the target: " + search(arr, target));
	}

	// O(log n)
	public static int search(int[] nums, int target) {

		int left = 0;
	    int right = nums.length - 1;
	    
	    while (left <= right) {
	    	
	        int mid = left + (right - left) / 2;
	        
	        if (nums[mid] == target) {
	            return mid;
	        } 
	        else if (nums[mid] > target) {
	            // the left half is monotonic, yet still does not satisfy
	            if (nums[left] <= nums[mid] && nums[left] > target) { 
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        } else {
	            // the right half is monotonic, yet still does not satisfy
	            if (nums[right] >= nums[mid] && nums[right] < target) { 
	                right = mid - 1;
	            } 
	            else {
	                left = mid + 1;
	            }
	        }
	    }
	    return -1;
	}



	// O(log n)
	public static int search2(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {

			int mid = (left + right) / 2;

			if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return left == right && nums[left] == target ? left : -1;
	}

}
