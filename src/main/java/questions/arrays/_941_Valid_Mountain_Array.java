package questions.arrays;
/*
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:
Input: arr = [2,1]
Output: false

Example 2:
Input: arr = [3,5,5]
Output: false

Example 3:
Input: arr = [0,3,2,1]
Output: true

Constraints:
1 <= arr.length <= 10^4
0 <= arr[i] <= 10^4
 */
public class _941_Valid_Mountain_Array {

    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4,5,6,7,8,9};

        System.out.println(validMountainArray(arr));
    }

    // O(n) - single pass
    public static boolean validMountainArray(int[] arr) {

        if (arr.length < 3 || arr[0] >= arr[1]) {
            return false;
        }
        boolean uphill   = false;
        boolean downhill = false;
        int i = 1; // arr[0] is already checked

        while (i < arr.length && arr[i-1] < arr[i]) { // uphill

            if (arr[i-1] == arr[i]) {
                return false;
            }
            i++;
            uphill = true;
        }
        while (i < arr.length && arr[i-1] > arr[i]) { // downhill

            if (arr[i-1] == arr[i]) {
                return false;
            }
            i++;
            downhill = true;
        }
        if (i == arr.length && uphill && downhill) { // if reached the end of the array
            return true;
        }
        return false;
    }

}
