package questions.matrix;

/*
Write an efficient algorithm that searches for a value target
in an m x n integer matrix 'matrix'. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is
greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
 */
public class _74_Search_a_2D_Matrix {

    public static void main(String[] args) {

        int[][] mat = {
                { 1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 70}
        };
        int target = 16;

        PrintMatrix.print(mat);
        System.out.println("\033[0;34m" + "\nTarget: " + target);
        System.out.println("\033[0;34m" + "Target exist in the Matrix?");

        if (searchMatrix(mat, target)) {
            System.out.println("\033[1;32m" + "Yes!");
        }
        else {
            System.out.println("\033[1;31m" + "No!");
        }
    }


    private static boolean searchMatrix(int[][] mat, int target) {

        int COLS = mat[0].length;
        int start = 0;
        int end = mat.length * mat[0].length - 1;

        while(start <= end) {

            int mid = (end - start)/2 + start;

            int row = (mid / COLS);         // (!)
            int col = (mid - (row * COLS)); // (!)

            if(mat[row][col] == target) {
                return true;
            }
            else if(target > mat[row][col]) {
                start = mid + 1;
            }
            else { // (target < arr[mid])
                end = mid - 1;
            }
        }
        return false;
    }

}
