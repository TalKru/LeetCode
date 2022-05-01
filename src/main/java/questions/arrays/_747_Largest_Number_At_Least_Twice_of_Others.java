package questions.arrays;
/*
You are given an integer array nums where
 the largest integer is unique.
Determine whether the largest element in the array is
 at least twice as much as every questions.other number in the array.
 If it is, return the index of the largest element,
 or return -1 otherwise.

Example 1:
Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every questions.other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.

Example 2:
Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.
Example 3:

Input: nums = [1]
Output: 0
Explanation: 1 is trivially at least twice the value as any questions.other number because there are no questions.other numbers.

Constraints:
1 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.
*/
public class _747_Largest_Number_At_Least_Twice_of_Others {

    public static void main(String[] args) {

        int[] arr = {3,6,1,0};
        //int[] arr = {1,2,3,4};
        //int[] arr = {0,0,3,2};
        int index = dominantIndex(arr);
        System.out.println("Index of Largest_Number_At_Least_Twice_of_Others: " + index);
        System.out.println("Vlue: " + arr[index]);
    }

    // O(n)
    public static int dominantIndex(int[] nums) {

        if(nums.length <= 1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }
            else if(nums[i] > secondMax && nums[i] < max){
                secondMax = nums[i];
            }
        }
        return (max >= (2 * secondMax)) ? maxIndex : -1;
    }
}












