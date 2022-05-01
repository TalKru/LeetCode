package questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Given two integer questions.arrays nums1 and nums2,
return an array of their intersection. 
Each element in the result must appear as many times as it shows 
in both questions.arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 
Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
public class _350_Intersection_of_Two_Arrays_II {

	public static void main(String[] args) {

		int[] nums1 = {9,4,9,8,4,4,4,4,4};
		int[] nums2 = {4,9,4,5,4};
		int[] intersect = intersect(nums1, nums2);
		
		System.out.println("First  array: " + Arrays.toString(nums1));
		System.out.println("Second array: " + Arrays.toString(nums2));
		System.out.println("Intersection_of_Two_Arrays: " + Arrays.toString(intersect));
	} // main
	
	
	
	public static int[] intersect(int[] nums1, int[] nums2) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums1.length; i++) {
			
			if(!map.containsKey(nums1[i])) { // add new number
				map.put(nums1[i], 1);
			}
			else { // update existing counter (value)
				int freq = map.get(nums1[i]);
				map.put(nums1[i], freq + 1);
			}
		}
		ArrayList<Integer> resultList = new ArrayList<>();
		
		for (int i = 0; i < nums2.length; i++) {
			
			if( map.containsKey(nums2[i]) ) {
				
				resultList.add(nums2[i]);
				
				int freq = map.get(nums2[i]) - 1; 
				
				if(freq > 0) {
					map.put(nums2[i], freq);
				}
				else { // newCount == 0
					map.remove(nums2[i]);
				}
			}
		}
		
		//int[] resultArr = resultList.stream().mapToInt(i->i).toArray();
		int[] resultArr = new int[resultList.size()];
		for (int i = 0; i < resultArr.length; i++) {
			resultArr[i] = resultList.get(i);
		}
		return resultArr;
	}

}


































