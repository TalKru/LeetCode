package questions.arrays;
/*
You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints 
of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, 
such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4
 */
public class _11_Container_With_Most_Water {

	public static void main(String[] args) {

		int[] arr = {1,8,6,2,5,4,8,3,7};
		int result = maxArea(arr);
		System.out.println(result);
	}

	
	// O(n), using smart advancing technique 
	public static int maxArea(int[] height) {

		int start = 0;
		int end = height.length-1;

		int maxCap = Integer.MIN_VALUE;
		int currCap = 0;

		while(start < end) {
			
			currCap = Math.min(height[start], height[end]) * (end - start);

			if(currCap > maxCap) {
				maxCap = currCap;
			}
			// advance with the height which has more potential
			// meaning keep the point with larger height
			// and move inwards with lower pointer
			if(height[start] > height[end]) { 
				end--;
			}
			else { start++; }
		}
		return maxCap;
	}


	// O(n^2), Brute force, slow
	//	public static int maxArea(int[] height) {
	//
	//		int maxCap = Integer.MIN_VALUE;
	//		int currCap = 0;
	//
	//		for (int i = 0; i < height.length; i++) { // start selection
	//			for (int j = i+1; j < height.length; j++) { // search
	//
	//				currCap = Math.min(height[j], height[i]) * (j-i);
	//
	//				if(currCap > maxCap) {
	//					maxCap = currCap;
	//				}
	//			}
	//		}
	//		return maxCap;
	//	}
}











