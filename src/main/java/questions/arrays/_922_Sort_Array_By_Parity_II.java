package questions.arrays;

import java.util.Arrays;
import java.util.Stack;

/*
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
Return any answer array that satisfies this condition.

Example 1:
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Example 2:
Input: nums = [2,3]
Output: [2,3]

Constraints:
2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
 */
public class _922_Sort_Array_By_Parity_II {

    public static void main(String[] args) {

        int[] arr = {0,1,3,2,9,8};

        System.out.println("Input:  " + Arrays.toString(arr));
        sortArrayByParityII(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    // in place, without additional data structs
    // swap even numbers from odd indexes into even indexes
    public static int[] sortArrayByParityII(int[] nums) {

        int nextEven = 1; // start scan from the first odd index

        for (int i = 0; i < nums.length; i += 2) { // iterate ONLY over even indexes

            if (nums[i] % 2 != 0) {  // found odd value at even index

                while(nextEven < nums.length) {

                    if (nums[nextEven] % 2 == 0) {
                        swap(nextEven, i, nums);
                        break;
                    }
                    nextEven += 2;
                }
            }
        }
        return nums;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // using 2 structs fot even & odd
    public static int[] sortArrayByParityII2(int[] nums) {

        Stack<Integer> sOdd = new Stack<>();
        Stack<Integer> sEven = new Stack<>();

        for (int num : nums) {

            if (num % 2 == 0) {
                sEven.push(num);
            } else {
                sOdd.push(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {

            if (i % 2 == 0) {
                nums[i] = sEven.pop();
            } else {
                nums[i] = sOdd.pop();
            }
        }
        return nums;
    }

}
