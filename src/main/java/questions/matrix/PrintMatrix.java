package questions.matrix;

public class PrintMatrix {

    public static void print(int[][] mat) {

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {

                System.out.print("\033[0;34m" + mat[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
