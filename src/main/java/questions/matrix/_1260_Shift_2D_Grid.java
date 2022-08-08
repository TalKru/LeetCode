package questions.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given a 2D grid of size m x n and an integer k.
You need to shift the grid k times.

In one shift operation:
Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.


Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2:
Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

Example 3:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]

Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
 */
public class _1260_Shift_2D_Grid {

    public static void main(String[] args) {

        int[][] grid = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int k = 1;

        System.out.println("Input: ");
        PrintMatrix.print(grid);
        System.out.println("k = " + k);

        List<List<Integer>> matList = shiftGrid(grid, k);

        System.out.println("\nAfter k shifts: ");
        System.out.println(matList);
    }


    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        // matrix size n x m
        int n = grid.length;
        int m = grid[0].length;

        int[] arr = new int[n * m];

        k %= (n * m); // rotary array, the shift may exceed all possible shifts and start over
        /*
        copy from mat to arr with the k shift amount
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int newIndex = ((i * m) + j + k) % (n * m);
                arr[newIndex] = grid[i][j];
            }
        }
        List<List<Integer>> matList = new ArrayList<>();

        int iter = 0;
        /*
        copy from arr to List<List<Integer>>
        while keeping the original matrix row as separate lists
         */
        for (int i = 0; i < n; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {

                row.add(arr[iter++]);
            }
            matList.add(row);
        }
        return matList;
    }
}
