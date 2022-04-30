package arrays;
/*
	Given an integer array nums sorted in non-decreasing order, 
	remove the duplicates in-place such that each unique element appears only once. 
	The relative order of the elements should be kept the same.
	Since it is impossible to change the length of the array in some languages, 
	you must instead have the result be placed in the first part of the array nums. 
	More formally, if there are k elements after removing the duplicates, 
	then the first k elements of nums should hold the final result. 
	It does not matter what you leave beyond the first k elements.

	Return k after placing the final result in the first k slots of nums.

	Do not allocate extra space for another array. 
	You must do this by modifying the input array in-place with O(1) extra memory.

	Custom Judge:

	The judge will test your solution with the following code:

	int[] nums = [...]; // Input array
	int[] expectedNums = [...]; // The expected answer with correct length

	int k = removeDuplicates(nums); // Calls your implementation

	assert k == expectedNums.length;
	for (int i = 0; i < k; i++) {
	    assert nums[i] == expectedNums[i];
	}
	If all assertions pass, then your solution will be accepted.

	Example 1:
	Input: nums = [1,1,2]
	Output: 2, nums = [1,2,_]
	Explanation: Your function should return k = 2, 
	with the first two elements of nums being 1 and 2 respectively.
	It does not matter what you leave beyond the returned k (hence they are underscores).

	Example 2:
	Input: nums = [0,0,1,1,1,2,2,3,3,4]
	Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
	Explanation: Your function should return k = 5,
	with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
	It does not matter what you leave beyond the returned k (hence they are underscores).

	Constraints:
	0 <= nums.length <= 3 * 104
	-100 <= nums[i] <= 100
	nums is sorted in non-decreasing order.
 */

import java.util.Arrays;

public class _26_Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {

		//int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4};
		int[] arr = {1,2};
		//int[] arr = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 7};
		//int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0,0, 0, 0, 0, 0,0, 0, 0, 0, 0,};

		System.out.println("before removal: " + Arrays.toString(arr));
		int ans = removeDuplicates(arr);

		System.out.println("after: removal: " + Arrays.toString(arr));
		System.out.println("Number of uniqe elements = " + ans);
		System.out.println(Arrays.toString(arr));
	}


	
	public static int removeDuplicates(int[] nums) {

		int c = 0; // current
		int u = 1; // uniqe 

		while(u < nums.length) { 

			if(nums[c] >= nums[u]) { // if duplicate or mess
				++u;
			}
			else { // (nums[c] < nums[u]) { // found next uniqe
				swap(nums, c+1, u);
				++c;
				++u;
			}
		}
		return (c+1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

} // class

