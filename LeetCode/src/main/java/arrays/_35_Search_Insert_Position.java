package arrays;
/*
	Given a sorted array of distinct integers and a target value, 
	return the index if the target is found. If not, 
	return the index where it would be if it were inserted in order.

	You must write an algorithm with O(log n) runtime complexity.

	Example 1:
	Input: nums = [1,3,5,6], target = 5
	Output: 2

	Example 2:
	Input: nums = [1,3,5,6], target = 2
	Output: 1

	Example 3:
	Input: nums = [1,3,5,6], target = 7
	Output: 4

	Example 4:
	Input: nums = [1,3,5,6], target = 0
	Output: 0

	Example 5:
	Input: nums = [1], target = 0
	Output: 0

	Constraints:
	1 <= nums.length <= 104
	-104 <= nums[i] <= 104
	nums contains distinct values sorted in ascending order.
	-104 <= target <= 104
 */

public class _35_Search_Insert_Position {

	public static void main(String[] args) {

		//  index   |0|1|2|3|4|5|6|7|8|9|
		int[] arr = {1,3,5,6,7,9};
		int target = 5;

		int res = searchInsert(arr, target);
		System.out.println("index = " + res);
	}



	public static int searchInsert(int[] nums, int target) {

		// search range [i,j]
		int i = 0;
		int j = nums.length-1;
		int pvt = j/2; // the "middle"

		while(i < j) {
			//============================)
			if(target == nums[pvt]) {
				return pvt;
			}
			//============================)
			if(target > nums[pvt]) {
				i = pvt+1;
				pvt = (i+j)/2;
			}
			else { // target < nums[pvt]
				j = pvt-1;
				pvt = (i+j)/2;
			}
		} // while

		// reached this line only if target was not found in the array
		if(target > nums[pvt]) {
			return pvt+1;
		}
		else { // (target > nums[pvt])
			return pvt;
		}
	}


}




















