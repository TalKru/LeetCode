package questions.other;

/*
Given an array of points on the X-Y plane points where
points[i] = [xi, yi], return the area of the largest triangle
that can be formed by any three different points.
Answers within 10-^5 of the actual answer will be accepted.

Example 1:
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2.00000
Explanation: The five points are shown in the above figure. The red triangle is the largest.

Example 2:
Input: points = [[1,0],[0,0],[0,1]]
Output: 0.50000

Constraints:
3 <= points.length <= 50
-50 <= xi, yi <= 50
All the given points are unique.
 */
public class _812_Largest_Triangle_Area {

    public static void main(String[] args) {

//        Point A = new Point(0, 0);
//        Point B = new Point(0, 2);
//        Point C = new Point(2, 0);
//        System.out.println("Triangle area: " + Triangle.area(A, B, C));

        int[][] points  = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        double res = largestTriangleArea(points);

        System.out.println("\033[1;33m" + "Largest_Triangle_Area: " + res);
    }

    public static double largestTriangleArea(int[][] points) {

        if (points.length < 3){
            return -1;
        }
        double maxArea = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {

                    Point A = new Point(points[i][0], points[i][1]);
                    Point B = new Point(points[j][0], points[j][1]);
                    Point C = new Point(points[k][0], points[k][1]);

                    double tempArea = Triangle.area(A, B, C); // readable extra line
                    maxArea = Math.max(maxArea, tempArea);
                }
            }
        }
        return maxArea;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /* Java method to return area of triangle using vertices
    as per following * formula area = (Ax(By -Cy) + Bx(Cy -Ay) + Cx(Ay - By))/2
    */
    static class Triangle {

        public static float area(Point A, Point B, Point C) {

            float area = (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0f;
            return Math.abs(area);
        }
    }
}
