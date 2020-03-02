package by.it.kuzmichalex.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    static int[][] matrix = new int[6][4];

    public static void main(String[] args) {
        buildMatrix();
        String sFileName = FHelper.getFileName("matrix.txt", TaskA.class);
        saveMatrix(sFileName);
        readAndPrint(sFileName);
    }

    private static void readAndPrint(String sFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(sFileName))) {
            String readedString;

           while (true){
                readedString=br.readLine();
                if(readedString==null)break;
               System.out.println(readedString);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveMatrix(String sFileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(sFileName))
        ) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    pw.printf("%3d ", anInt);
                }
                pw.println();
            }
        } catch (IOException e) {
            System.out.println("Output error. File:" + sFileName);
        }
    }

    private static void buildMatrix() {
        boolean bMin = false;
        boolean bMax = false;
        do {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    Random rnd = new Random();
                    matrix[i][j] = rnd.nextInt(31) - 15;
                    if (matrix[i][j] == -15) bMin = true;
                    if (matrix[i][j] == 15) bMax = true;
                }
            }
        } while ((!bMin) || (!bMax));
    }
}
