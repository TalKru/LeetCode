package questions.arrays;

import java.util.Arrays;

/*
A school is trying to take an annual photo of all the students.
The students are asked to stand in a single file line
in non-decreasing order by height.
Let this ordering be represented by the integer array expected
where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order
that the students are standing in. Each heights[i] is the height
of the ith student in line (0-indexed).
Return the number of indices where heights[i] != expected[i].

Example 1:
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
Example 2:
Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
Example 3:
Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.

Constraints:
1 <= heights.length <= 100
1 <= heights[i] <= 100
 */
public class _1051_Height_Checker {

    public static void main(String[] args) {

        int[] heights = {1,1,4,2,1,3};
        int res = heightChecker(heights);

        System.out.println(res);
    }

    public static int heightChecker(int[] heights) {

        int[] map = new int[101]; // heights go from 1 to 100

        for(int h: heights) {
            map[h]++;
        }
        int res = 0;
        int heightPtr = 1;

        for(int h: heights) {

            while(map[heightPtr] == 0) {
                heightPtr++;
            }
            if(heightPtr != h) {
                res++;
            }
            map[heightPtr]--;
        }
        return res;
    }


    // easy solution but less efficient
    public static int heightChecker2(int[] heights) {

        int[] sorted = heights.clone();

        Arrays.sort(sorted);

        int diffCount = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                diffCount++;
            }
        }
        return diffCount;
    }

}
