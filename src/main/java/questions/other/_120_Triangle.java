package questions.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below.
More formally, if you are on index i on the current row,
you may move to either index i or index i + 1 on the next row.

Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10

Constraints:
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-10^4 <= triangle[i][j] <= 10^4
 */
public class _120_Triangle {

    public static void main(String[] args) {

        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
//        List<List<Integer>> triangle = List.of(
//                List.of(-1),
//                List.of(9, -2),
//                List.of(0, 4, 5),
//                List.of(7, 4, -4, -5),
//                List.of(9, 6, 0, 5, 7),
//                List.of(9, 2, -9, -4, 5, -2),
//                List.of(-4, -9, -5, -7, -5, -5, -2),
//                List.of(-9, 5, -6, -4, 4, 1, 6, -4),
//                List.of(-4, 3, 9, -2, 8, 6, -9, -2, -2),
//                List.of(7, -6, 9, 8, -4, 2, -4, -2, -1, -2),
//                List.of(0, 3, 2, 4, 0, -6, 7, 6, 7, -5, 2),
//                List.of(9, 0, -8, 6, 4, 6, 2, 5, -9, 9, -1, -6),
//                List.of(6, -3, -4, -5, 0, 3, 3, 4, -6, -4, -7, 7, 3)
//        );
        System.out.println("Input triangle:");

        for (List<Integer> list : triangle) {
            for (int n : list) {

                if (n >= 0) {
                    System.out.print("+" + n + "\t");
                } else {
                    System.out.print(n + "\t");
                }
            }
            System.out.println();
        }
        int minSum = minimumTotal(triangle);

        System.out.println("Min path from top to bottom (sum): " + minSum);
    }
    // ============================================================================================== //

    // In place, bottom up
    public static int minimumTotal(List<List<Integer>> triangle) {

        int LEVELS = triangle.size();

        for (int level = LEVELS - 2; level >= 0 ; level--) { // going up the triangle for the prev to last level

            int levelLen = triangle.get(level).size(); // [0][1]...[levelLen - 2][levelLen - 1]

            for (int i = 0; i < levelLen; i++) {

                int leftChild  = triangle.get(level + 1).get(i);
                int rightChild = triangle.get(level + 1).get(i + 1);
                int minChild = Math.min(leftChild, rightChild);
                int addMinChildVal = triangle.get(level).get(i) + minChild; // each node adds to itself the min value from one of its children

                triangle.get(level).set(i, addMinChildVal); // update the node itself
            }
        }
        return triangle.get(0).get(0);
    }
    // ============================================================================================== //
    public static int minimumTotal2(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size(); // last row size
        int[] pathsArr = new int[n];         // pathsArr[i] represents the min total from bottom to current position
        pathsArr[0] = triangle.get(0).get(0);

        // induction rule
        // pathsArr[j] = min(pathsArr[j - 1], pathsArr[j]) + curVal
        for (int i = 1; i < m; i++) {

            List<Integer> cur = triangle.get(i);

            for (int j = cur.size() - 1; j >= 0; j--) {

                if (j == 0) {
                    pathsArr[j] += cur.get(j);
                }
                else if (j == cur.size() - 1) {
                    pathsArr[j] = pathsArr[j - 1] + cur.get(j);
                }
                else {
                    pathsArr[j] = Math.min(pathsArr[j - 1], pathsArr[j]) + cur.get(j);
                }
            }
        }
        //System.out.println("\n" + Arrays.toString(pathsArr));
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, pathsArr[i]);
        }
        return min;
        //return Arrays.stream(pathsArr).min().getAsInt();
    }
    // ============================================================================================== //
}
