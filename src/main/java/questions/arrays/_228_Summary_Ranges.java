package questions.arrays;

import java.util.LinkedList;
import java.util.List;

/*
You are given a *sorted* *unique* integer array nums.
Return the smallest sorted list of ranges that cover all the numbers
 in the array exactly. That is, each element of nums is covered by 
 exactly one of the ranges, and there is no integer x such that 
 x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 
Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 
Constraints:
0 <= nums.length <= 20
-2^31 <= nums[i] <= 2^31 - 1
All the values of nums are unique.
nums is sorted in ascending order.
*/
public class _228_Summary_Ranges {

	public static void main(String[] args) {
		
		//int[] arr = {0,1,2,4,5,7};
		int[] arr = {0,2,3,4,6,8,9};
		//int[] arr = {0,1,2,4,5,7};
		
		List<String> resList = summaryRanges(arr);
		
		System.out.println(resList.toString());
	}

	
	// O(n)
	public static List<String> summaryRanges(int[] nums) {
		
		int len = nums.length;
		
	    List<String> result = new LinkedList<>();
	    
	    for (int i = 0; i < len; i++) {
	    	
	        int num = nums[i];
	        
	        while (i < len-1 && nums[i]+1 == nums[i+1]) {
	            i++;
	        }
	        if (num != nums[i]) {
	            result.add(num + "->" + nums[i]);
	        } 
	        else {
	            result.add(num + "");
	        }
	    }
	    return result;
	}

}


















