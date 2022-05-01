package questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Given two integer questions.arrays nums1 and nums2,
return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
public class _349_Intersection_of_Two_Arrays {

	public static void main(String[] args) {

		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] intersect = intersection(nums1, nums2);
		
		System.out.println("First  array: " + Arrays.toString(nums1));
		System.out.println("Second array: " + Arrays.toString(nums2));
		System.out.println("Intersection_of_Two_Arrays: " + Arrays.toString(intersect));
	}


	public static int[] intersection(int[] nums1, int[] nums2) {

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}

		ArrayList<Integer> reslutList = new ArrayList<>();
		//LinkedList<Integer> intersectionList = new LinkedList<>();

		for (int i = 0; i < nums2.length; i++) {

			if(set.contains(nums2[i])) {
				
				reslutList.add(nums2[i]);
				set.remove(nums2[i]);      // remove element to prevent duplicates
			}
		}
		// one line to replce the rest of the code
		//return reslutList.stream().mapToInt(number -> number).toArray();
		int[] resArr = new int[reslutList.size()];
		
		for (int i = 0; i < resArr.length; i++) {
			resArr[i] = reslutList.get(i);
		}
		return resArr;
		
	}

}
