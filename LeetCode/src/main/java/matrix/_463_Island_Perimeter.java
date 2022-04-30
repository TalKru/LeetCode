package matrix;
/*
You are given row x col grid representing a map where grid[i][j] = 1 
represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island 
(i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected 
to the water around the island. One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. 
Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4

Constraints:
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
 */
public class _463_Island_Perimeter {

	public static void main(String[] args) {

		int[][] mat = {
				{0,1,0,0},
				{1,1,1,0},
				{0,1,0,0},
				{1,1,0,0}}; // Output: 16

		printMatrix(mat);
		int res = islandPerimeter(mat);

		System.out.println("The perimeter: " + res);
	}

	public static void printMatrix(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				System.out.print(mat[i][j]  + "  ");
				//System.out.print(mat[i][j]  + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}


	// O(n^2)
	public static int islandPerimeter(int[][] grid) {

		int sectors = 0;
		int overlaps = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if(grid[i][j] == 1) { 

					sectors++; 

					boolean isRight = (j != grid[i].length - 1); // can we check right cell
					boolean isDown  = (i != grid.length    - 1); // can we check under cell

					if(!isDown && !isRight) { 
						continue; 
					}  // last cell, no need to do anything

					else if(isRight == false && isDown) { // only check down

						if(grid[i+1][j] == 1) { 
							overlaps++; 
						}
					}
					else if (isDown == false && isRight) { // only check right

						if(grid[i][j+1] == 1) { 
							overlaps++; 
						}
					}
					else { // check right & down

						if(grid[i+1][j] == 1) { 
							overlaps++; 
						}
						if(grid[i][j+1] == 1) { 
							overlaps++; 
						}
					}
				}
			}
		}
		int potentialPerimeter = sectors * 4; 
		return (potentialPerimeter - (overlaps * 2));
	}
}


























