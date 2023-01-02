package questions.arrays;

import java.util.Arrays;
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
 */
public class _4_Median_of_Two_Sorted_Arrays {

	public static void main(String[] args) {

		int[] arr1 = {1, 2};
		int[] arr2 = {3, 4};
		int[] sortedArr = mergeSortedArrays(arr1, arr2);

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(sortedArr));

		double res = findMedianSortedArrays(arr1, arr2);
		System.out.println(res);
	}

	//------------------------------------------------------------------------------//
	// O(m+n))
	public static double findMedianSortedArrays(int[] arr1, int[] arr2) {

		// Arrays.sort(nums1);// consider it done
		// Arrays.sort(nums2);//

		int[] mergedArr = mergeSortedArrays(arr1, arr2);

		return medianSortedArray(mergedArr); 
	}

	private static double medianSortedArray(int[] arr) {

		int n = arr.length;

		if(n == 0) {
			return 0;
		}
		if(n % 2 == 0) {

			int a = arr[n / 2];
			int b = arr[(n / 2) - 1];
			return (double)(a + b) / 2; 
		}
		else {
			return arr[n/2];
		}
	}

	private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

		int n = arr1.length;
		int m = arr2.length;

		if(n == 0) {
			return arr2;
		}
		if(m == 0) {
			return arr1;
		}
		int[] mergeArr = new int[n + m];

		int a = 0; // arr1 index
		int b = 0; // arr2 index
		int i = 0; // mergeArr index
		while(a < n && b < m) {

			if(arr1[a] < arr2[b]) {

				mergeArr[i++] = arr1[a++];
			}
			else {
				mergeArr[i++] = arr2[b++];
			}
		}

		while(a < n) {
			mergeArr[i++] = arr1[a++];
		}
		while(b < m) {
			mergeArr[i++] = arr2[b++];
		}
		return mergeArr;
	}
	//------------------------------------------------------------------------------//
	/*
	O(log(min(M,N))) iterative
	https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
	*/
	double findMedianSortedArrays2(int[] nums1, int[] nums2) {
	    
		int N1 = nums1.length;
	    int N2 = nums2.length;
	    
	    if (N1 < N2) {
	    	return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.
	    }
	    int lo = 0;
	    int hi = N2 * 2;
	    
	    while (lo <= hi) {
	        int mid2 = (lo + hi) / 2;   // Try Cut 2 
	        int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly
	        
	        double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];	// Get L1, R1, L2, R2 respectively
	        double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
	        double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
	        double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];
	        
	        if (L1 > R2) {
	        	lo = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
	        }
	        else if (L2 > R1) {
	        	hi = mid2 - 1;	// A2's lower half too big; need to move C2 left.
	        }
	        else {
	        	return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
	        }
	    }
	    return -1;
	} 
	//------------------------------------------------------------------------------//
}






















