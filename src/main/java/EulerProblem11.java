import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Mike on 2014-07-05.
 */
public class EulerProblem11 {

    public static void main(String[] args) {
        int size = 20;
        int[][] matrix = readMatrix(size, "C:\\Users\\Mike\\Code\\project-euler\\files\\problem11.txt");
        int max = 0;
        for (int row = 0; row <= 16; row++) {
            for (int col = 0; col <= 19; col++) {
                int val = getProdVertical(matrix, row, col);
                if (val > max) {
                    max = val;
                }
            }
        }
        for (int row = 0; row <= 19; row++) {
            for (int col = 0; col <= 16; col++) {
                int val = getProdHorizontal(matrix, row, col);
                if (val > max) {
                    max = val;
                }
            }
        }
        //System.out.println(getProdDiagonalRight(matrix, 16, 16));
        for (int row = 0; row <= 16; row++) {
            for (int col = 0; col <= 16; col++) {
                int val = getProdDiagonalRight(matrix, row, col);
                if (val > max) {
                    max = val;
                }
            }
        }
        for (int row = 0; row <= 16; row++) {
            for (int col = 19; col >= 3; col--) {
                int val = getProdDiagonalLeft(matrix, row, col);
                if (val > max) {
                    max = val;
                }
            }
        }
        System.out.println(max);

    }

    private static int getProdVertical(int[][] matrix, int row, int col) {
        return matrix[row][col] * matrix[row + 1][col] * matrix[row + 2][col] * matrix[row + 3][col];
    }

    private static int getProdHorizontal(int[][] matrix, int row, int col) {
        return matrix[row][col] * matrix[row][col + 1] * matrix[row][col + 2] * matrix[row][col + 3];
    }

    private static int getProdDiagonalRight(int[][] matrix, int row, int col) {
        return matrix[row][col] * matrix[row + 1][col + 1] * matrix[row + 2][col + 2] * matrix[row + 3][col + 3];
    }

    private static int getProdDiagonalLeft(int[][] matrix, int row, int col) {
        return matrix[row][col] * matrix[row + 1][col - 1] * matrix[row + 2][col - 2] * matrix[row + 3][col - 3];
    }

    private static int[][] readMatrix(int size, String path) {
        File file = new File(path);
        int[][] matrix = new int[size][size];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (int col = 0; col < numbers.length; col++) {
                    matrix[row][col] = Integer.parseInt(numbers[col]);
                }
                row++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matrix;
    }

    private static void printMatrix(int size, int[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
//Answer:70600674