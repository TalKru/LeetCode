package questions.arrays;

/*
Let's call an array arr a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain,
return any i such that
arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1

Constraints:
3 <= arr.length <= 104
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.

Follow up: Finding the O(n) is straightforward, could you find an O(log(n))
 */
public class _852_Peak_Index_in_a_Mountain_Array {

    public static void main(String[] args) {

        //int[] arr = {0,1,2,3,10,5,4,3,2,0};
        int[] arr = {18,29,38,59,98,100,99,98,90};

        System.out.print("Mountain index: ");
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int start = 1; // Index
        int end = arr.length - 2;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) { // up
                start = mid + 1;
            }
            else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) { // down
                end = mid - 1;
            }
        }
        return -1;
    }

    // O(n) solution is simple, when Mountain is guaranteed
    // all it takes is to find that k where arr[k] > arr[k+1]
    public static int peakIndexInMountainArray2(int[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
