package questions.arrays;
/*
Given an array of integers nums which is sorted in ascending order, 
and an integer target, write a function to search target in nums. 
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 10^4
-10^4 < nums[i], target < 10^4
All the integers in nums are unique.
nums is sorted in ascending order.
 */
public class _704_Binary_Search {

	public static void main(String[] args) {
		
		int[] arr = {-1,0,3,5,9,12};
		int target = 5;
		
		System.out.println("index: " + search(arr, target));
	}

	// O(long n)
	public static int search(int[] arr, int target) {

		int start = 0;    
		int end = arr.length - 1;  

		while(start <= end) {

			int mid = (end - start)/2 + start;

			if(arr[mid] == target) {
				return mid;
			}
			else if(target > arr[mid]) {
				
				start = mid + 1;
			}
			else { // (target < arr[mid])
				
				end = mid - 1;
			}
		}
		return -1;
	}

}




















