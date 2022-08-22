package questions.matrix;

/*
Given a m x n matrix grid which is sorted in
non-increasing order both row-wise and column-wise,
return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100

Follow up: Could you find an O(n + m) solution?
 */
public class _1351_Count_Negative_Nums_Sorted_Matrix {

    public static void main(String[] args) {

        int[][] mat = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3},
        };
        int res = countNegatives(mat);

        System.out.println("Count_Negative_Nums_Sorted_Matrix: " + res);
    }


    /*
    the negative regions of the matrix will form a "staircase" shape, e.g.:
    ++++++
    ++++--
    ++++--
    +++---
    +-----
    +-----

    What this solution then does is to "trace" the outline of the staircase.
    Start from bottom-left corner of the matrix, count in the negative numbers in each row.
     */
    public static int countNegatives(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        int negativeCount = 0;

        if (mat[0][0] < 0) {    // all vals are negative
            return rows * cols;
        }
        if (mat[rows - 1][cols - 1] > 0) { // all positive
            return negativeCount;
        }
        int c = 0;
        int r = rows - 1;

        while (r >= 0 && c < cols) {

            if (mat[r][c] < 0) {
                r--;
                negativeCount += cols - c;
            }
            else {
                c++;
            }
        }
        return negativeCount;
    }

}
