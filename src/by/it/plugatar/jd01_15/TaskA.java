package by.it.plugatar.jd01_15;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[6][4];
        fill(array);
        // System.out.println(Arrays.deepToString(array));
        String string = deepToString(array);
        //new HelperWrapper().getPath2();
        String filename = Helper.getPath("matrix.txt", TaskA.class);
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.print(string);
        }
        Files
                .lines(Paths.get(filename))
                .forEach(System.out::println);
       /*
       try(BufferedReader reader = new BufferedReader((new FileReader(filename))
       )
       { while (reader.ready()){
           System.out.println(reader.readLine());
       }
       catch (IOException e){
           e.printStackTrace();
       }
       */

    }


    private static String deepToString(int[][] array) {
        StringBuilder out = new StringBuilder();
        for (int[] row : array) {
            for (int i : row) {
                out.append(String.format("%3d ", i));
            }
            out.append("\n");
        }
        return out.toString();
    }

    private static void fill(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) (Math.random() * 31) - 15;
            }
        }
    }
}

