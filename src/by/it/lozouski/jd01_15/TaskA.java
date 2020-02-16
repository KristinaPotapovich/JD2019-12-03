package by.it.lozouski.jd01_15;

import by.it.lozouski.jd01_14.Helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

class TaskA extends Helper {
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[6][4];
        matrixFilling(matrix);
        String outArray = deepToString(matrix);
        String getFileName = Helper.getPath("matrix.txt", TaskA.class);
        try (PrintWriter printWriter = new PrintWriter(getFileName)) {
            printWriter.write(outArray);
        }
        Files.lines(Paths.get(getFileName)).forEach(System.out::println);
    }

    static String deepToString(int[][] matrix) {
        StringBuilder sb1 = new StringBuilder();
        for (int[] row : matrix) {
            for (int elemRow : row) {
                sb1.append(String.format("%3d ", elemRow));
            }
            sb1.append('\n');
        }
        return sb1.toString();
    }

    static void matrixFilling(int[][] matrix) {
        boolean min, max;
        do {
            min = false;
            max = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = -15 + (int) (Math.random() * 31);
                    if (matrix[i][j] == -15) min = true;
                    if (matrix[i][j] == 15) max = true;
                }
            }
        } while (!min || !max);
    }
}
