package by.it.popkov.jd01_15;

import java.io.*;

class TaskA {
    public static void main(String[] args) {
        String fileName = Support.fileFullName(TaskA.class, "matrix.txt");
        int[][] matrix = new int[6][4];
        matrixBuilder(matrix);
        matrixWriter(matrix, fileName);
        matrixReader(fileName);
    }

    private static void matrixReader(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            int b;
            while ((b = randomAccessFile.read()) >= 0){
                sb.append((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());

    }

    private static void matrixWriter(int[][] matrix, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    printWriter.printf("%3d ", anInt);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static void matrixBuilder(int[][] matrix) {
        boolean min = false;
        boolean max = false;
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + (int) (Math.random() * 31);
                if (row[i] == 15) max = true;
                else if (row[i] == -15) min = true;
            }
        }
        if (!max || !min) matrixBuilder(matrix);
    }
}
