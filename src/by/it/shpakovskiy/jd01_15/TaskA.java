package by.it.shpakovskiy.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[6][4];
        fillArray(array);
        String string = convertArrayToString(array);
        String fileName = "src/by/it/shpakovskiy/jd01_15/matrix.txt";
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.print(string);
        }
        Files.lines(Paths.get(fileName)).forEach(System.out::println);
    }

    private static String convertArrayToString(int[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] line : array) {
            for (int elem : line) {
                stringBuilder.append(String.format("%3d ", elem));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static void fillArray(int[][] array) {
        boolean min = false;
        boolean max = false;
        while (!min || !max) {
            for (int[] line : array) {
                for (int i = 0; i < line.length; i++) {
                    line[i] = -15 + (int) (Math.random() * 31);
                    if (line[i] == -15) min = true;
                    if (line[i] == 15) max = true;
                }
            }
        }
    }
}
