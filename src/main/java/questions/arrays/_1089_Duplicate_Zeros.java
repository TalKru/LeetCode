package questions.arrays;

import java.util.Arrays;

/*
Given a fixed-length integer array arr,
duplicate each occurrence of zero,
shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place and do not return anything.

Example 1:
Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:
Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]

Constraints:
1 <= arr.length <= 10^4
0 <= arr[i] <= 9
 */
public class _1089_Duplicate_Zeros {

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        //int[] arr = {8,4,5,0,0,0,0,7};
        System.out.println("Input Array:     " + Arrays.toString(arr));

        duplicateZeros(arr);
        System.out.println("Duplicate_Zeros: " + Arrays.toString(arr));
    }

    // best, O(1) space, O(n) time
    public static void duplicateZeros(int[] arr) {

        int n = arr.length;
        int count = 0;

        for (int num : arr) {
            if (num == 0) {
                count++;
            }
        }
        int i = n - 1;
        int write = n + count - 1;

        while (i >= 0 && write >= 0) {

            if (arr[i] != 0) { // Non-zero, just write it in
                if (write < n) {
                    arr[write] = arr[i];
                }
            }
            else { // Zero found, write it in twice if we can
                if (write < n) {
                    arr[write] = arr[i];
                }
                write--;

                if (write < n) {
                    arr[write] = arr[i];
                }
            }
            i--;
            write--;
        }
    }

    // first attempt, O(n) space, O(n) time
    public static void duplicateZeros2(int[] arr) {

        int[] copyToArr = new int[arr.length];
        int n = arr.length;
        int i = 0;
        int s = i; // shift

        while (s < n) {

            if (arr[i] == 0) {
                copyToArr[s] = 0;
                s++;
            }
            if (s >= n) {
                break;
            }
            copyToArr[s++] = arr[i++];
        }
        System.arraycopy(copyToArr, 0, arr, 0, n);
    }

}
