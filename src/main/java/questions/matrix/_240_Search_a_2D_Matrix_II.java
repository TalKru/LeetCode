package questions.matrix;

/*
Write an efficient algorithm that searches for a value target
in an m x n integer matrix "matrix".
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-10^9 <= target <= 10^9
 */
public class _240_Search_a_2D_Matrix_II {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        int target = 5;

        System.out.println("Input: ");
        PrintMatrix.print(mat);

        System.out.println("\ntarget: " + target);
        System.out.println("Search_a_2D_Matrix: " + searchMatrix(mat, target));
    }

    /*
    Start scanning the matrix from top right corner,
    init the current position to top right corner,
    if the target is greater than the value in current position,
    then the target can not be in entire row of current position because the row is sorted,
    if the target is less than the value in current position,
    then the target can not in the entire column because the column is sorted too.
    We can rule out one row or one column each time,
    Time complexity is O(m+n).
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row <= matrix.length - 1) {

            if (target == matrix[row][col]) {
                return true;
            }
            else if (target < matrix[row][col]) {
                col--;
            }
            else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }


}
