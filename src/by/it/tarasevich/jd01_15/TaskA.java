package by.it.tarasevich.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskA {
    public static String path(Class<?> cl) {
        String p = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String w = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return p + w;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[6][4];

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path(TaskA.class) + "matrix.txt")))) {
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    matrix[x][y] = (int) (Math.random() * 31 - 15);
                    pw.printf("%3d ", matrix[x][y]);
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader isr = new BufferedReader(new FileReader(path(TaskA.class) + "matrix.txt"))) {
          //  List<String> result = new ArrayList<>();
          StringBuilder result = new StringBuilder();
            String line;
            while ((line = isr.readLine()) != null) {
               // result.add(line);
                result.append(line).append("\n");
            }
            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}