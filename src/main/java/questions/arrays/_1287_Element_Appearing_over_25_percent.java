package questions.arrays;

import java.util.Arrays;

/*
Given an integer array sorted in non-decreasing order,
 there is exactly one integer in the array that occurs
 more than 25% of the time, return that integer.

Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6

Example 2:
Input: arr = [1,1]
Output: 1

Constraints:
1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
 */
public class _1287_Element_Appearing_over_25_percent {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int res = findSpecialInteger(arr);

        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Element_Appearing_over_25_percent: " + res);
    }


    // O(n) time
    // O(1) space
    public static int findSpecialInteger(int[] arr) {
        int cand = arr[0];
        int freq = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == cand) {
                freq++;
            }
            else { // reset
                cand = arr[i];
                freq = 1;
            }

            if (freq > arr.length / 4) {
                return cand;
            }
        }
        return -1;
    }


    /*
    Checking the first and last index of occurring of the elements at position
    n / 4, (2 * n) / 4 and (3 * n) / 4
    The logic is, let's say we divide the array into 4 parts,
    i.e. the first part will be from [0, n / 4], second from [n / 4, (2 * n) / 4],
    third from [(2 * n) / 4, (3 * n) / 4] and fourth from [(3 * n) / 4, n - 1].
    Now, whatever would be our required element should be at one of
    the index n / 4 or (2 * n) / 4 or (3 * n) / 4.
    Let's call these indices as our special indices.
    The answer should be at one of our special indices because,
    these indices are the marked at 25% intervals of the array,
    and since the required element is the one having occurrence more than 25%
    and the array is sorted, so the required element must be present at one of our special points.
    Now, we need to verify for our 3 special index, if the element at current index, say i,
    is a valid required element or not. Dealing with that is fast if we use Binary Search.
    We can find the first index of occurrence of element arr[i]
    which would be the lower_bound of arr[i], say l,
    and similarly find last index of occurrence of element arr[i]
    which would be the upper_bound of arr[i], say r.
    The frequency of arr[i] hence would be r - l + 1,
    and we could check if it's greater than n / 4
     */
    public static int bin_find1(int arr[], int val) {
        // for finding lower bound
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] >= val) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }

    public static int bin_find2(int arr[], int val) {
        // for finding upper bound
        int l = 0, r = arr.length - 1;
        int ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (arr[mid] <= val) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }

    public static boolean valid(int arr[], int ind) {
        int n = arr.length;
        int start = bin_find1(arr, arr[ind]);
        int end = bin_find2(arr, arr[ind]);
        if (end - start + 1 > n / 4) return true;
        return false;
    }

    public static int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int first = n / 4;
        int second = n / 2;
        int third = 3 * n / 4;

        if (valid(arr, first)) {
            return arr[first];
        }
        else if (valid(arr, second)) {
            return arr[second];
        }
        else if (valid(arr, third)) {
            return arr[third];
        }
        return -1;
    }
}
