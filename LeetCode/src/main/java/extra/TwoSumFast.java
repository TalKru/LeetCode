package extra;

import java.util.Arrays;
import java.util.HashMap; // import the HashMap class

public class TwoSumFast {

	public static void main(String[] args) {

		int[] arr = {1,5,7,6,5,10,10,0,7,9};
		int sum = 1;

		Solution obj = new Solution();

		int[] res = obj.twoSum(arr, sum);
		
		System.out.println(Arrays.toString(arr));
		System.out.println("Sum: " + sum);
		System.out.println("indexes: " + Arrays.toString(res));
		System.out.println("cell values: " + arr[res[0]] + ", " + arr[res[1]] );
	} // main

}


//=================================================================================================
class Solution {
	
	public int[] twoSum(int[] nums, int sum) {
		
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			
			// if the corresponding pair can be found now, return the answer, eale add new pair to the map
			boolean isFound = map.containsKey(nums[i]);

			if(isFound) {
				res[0] = i;
				res[1] = map.get(nums[i]);
				return res;
			}
			else {
				map.put(sum - nums[i], i);
			}
		}
		System.err.println("not found");
		return res;
	}
}











