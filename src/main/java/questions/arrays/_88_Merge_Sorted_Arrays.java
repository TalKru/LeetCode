package questions.arrays;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, 
but instead be stored inside the array nums1. To accommodate this, 
nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 */
public class _88_Merge_Sorted_Arrays {

	public static void main(String[] args) {

		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3;
		int n = 3;

		merge(nums1, m, nums2, n);

		System.out.println(Arrays.toString(nums1));
	}




	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		if(n == 0) return;

		int[] nums3 = new int[m]; // placeholder for nums1 real size
		int indx2 = 0;
		int indx3 = 0;

		for (int i = 0; i < m; i++) {          // so we can use now nums1 as sorting into it
			nums3[i] = nums1[i];
		}

		for (int i = 0; i < (m+n); i++) {

			if(indx3 == m) {                   // nums3 done
				nums1[i] = nums2[indx2++];
				continue;
			}
			else if (indx2 == n) {              // nums2 done
				nums1[i] = nums3[indx3++];
				continue;
			}
			
			if(nums2[indx2] < nums3[indx3]) {
				nums1[i] = nums2[indx2++];
			}
			else {
				nums1[i] = nums3[indx3++];
			}
		}
	}



	/* using sort */ 
	//public void merge(int[] nums1, int m, int[] nums2, int n) {
	//
	//		int index = 0;
	//
	//		for(int i = m; i < nums1.length; i++){
	//			nums1[i] = nums2[index++];
	//		}
	//		Arrays.sort(nums1);
	//}
}


















