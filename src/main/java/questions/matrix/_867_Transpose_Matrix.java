package questions.matrix;
/*
Given a 2D integer array questions.matrix, return the transpose of questions.matrix.
The transpose of a questions.matrix is the questions.matrix flipped over
its main diagonal, switching the questions.matrix's row and column indices.

Example 1:
Input: questions.matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: questions.matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
*/
public class _867_Transpose_Matrix {

	public static void main(String[] args) {



	}

	public static int[][] transpose(int[][] mat) {
		
		int n = mat.length;
		int m = mat[0].length;
		
		int[][] trMat = new int[m][n];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				
				trMat[j][i] = mat[i][j];
			}
		}
		return trMat;
	}

}
