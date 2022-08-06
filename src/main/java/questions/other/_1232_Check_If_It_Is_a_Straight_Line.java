package questions.other;

/*
You are given an array coordinates, coordinates[i] = [x, y],
where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 */
public class _1232_Check_If_It_Is_a_Straight_Line {

    public static void main(String[] args) {

        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        //int[][] coordinates = {{0,0},{0,1},{0,-1}};

        boolean res = checkStraightLine(coordinates);

        System.out.println("Check_If_It_Is_a_Straight_Line: " + res);
    }

    public static boolean checkStraightLine(int[][] coord) {

        double m1 = slope(coord[0][0], coord[0][1], coord[1][0], coord[1][1]);

        for (int i = 1; i < coord.length - 1; i++) {

            double m2 = slope(coord[i][0], coord[i][1], coord[i + 1][0], coord[i + 1][1]);

            if (m1 != m2) {
                return false;
            }
        }
        return true;
    }

    // (y2 - y1) / (x2 - x1)
    private static double slope(int x1, int y1, int x2, int y2) {

        double a = (y2 - y1);
        double b = (x2 - x1);

        if (b == 0) {
            return Double.MAX_VALUE;
        }
        return a / b;
    }
}
