package questions.matrix;

/*
You are given an n x n 2D matrix representing an image,
rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place,
which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
public class _48_Rotate_Image {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 4},
                {8, 8, 8, 8},
                {5, 6, 7, 8},
                {9, 9, 9, 9}
        };
        PrintMatrix.print(mat);
        rotate(mat);
        System.out.println("Rotation 90-degree right:");
        PrintMatrix.print(mat);
    }


    // Firstly transpose the matrix and then flip it symmetrically.
    public static void rotate(int[][] matrix) {

        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < matrix[0].length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }

    public static void rotate2(int[][] matrix) {

        int len = matrix.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
        }
    }


    /*
    public static void rotate(int[][] matrix) {

        int len = matrix.length;

        for (int r = 0; r < len/2; r++) {
            for (int c = r; c < len-r-1; c++) {

                //tempMat[r][c] = matrix[c][len - 1 - r]; // rotate 90-degree left
                //tempMat[c][len - 1 - r] = matrix[r][c]; // rotate 90-degree right
                swapMatrixCells(matrix, r, c, c, len - 1 - r);
            }
        }
    }

    public static void swapMatrixCells(int[][] mat, int r, int c, int r2, int c2) {

        int temp = mat[r][c];
        mat[r][c] = mat[r2][c2];
        mat[r2][c2] = temp;
    }
    */
}
