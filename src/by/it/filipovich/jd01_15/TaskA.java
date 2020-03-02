package by.it.filipovich.jd01_15;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[6][4];
        String fileName = Helper.pathToFile("matrix.txt", TaskA.class);
        fillMatrix(matrix);
        String str = transformToString(matrix);
        try (PrintWriter print = new PrintWriter(fileName)){
            print.print(str);
        }
        Files.lines(Paths.get(fileName)).forEach (System.out::println);

    }

    private static String transformToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int i : row) {
                sb.append(String.format("%3d ",i));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void fillMatrix(int[][] matrix) {
        boolean min,max;
        do{
            min = false;
            max = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = -15 + (int)(Math.random()*31);
                    if(matrix[i][j]==-15)
                        min=true;
                    if(matrix[i][j] == 15)
                        max = true;
                }
            }
        }
        while(!min || !max);
    }
}
