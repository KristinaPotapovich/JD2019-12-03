package by.it.samuseva.jd01_15;

import java.io.*;


public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[6][4];
        fill(array);
        String string = arrayToString(array);
        String fileName = Helper.getPath("matrix.txt", TaskA.class);
        try (PrintWriter writer = new PrintWriter(new File(fileName))){
            writer.print(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      //  Files.lines(Paths.get(fileName)).forEach(s -> System.out.println(s));
       try (BufferedReader filetxt = new BufferedReader(new  FileReader(fileName))){
            StringBuilder line = new StringBuilder();
            String lin;
            while ((lin = filetxt.readLine()) != null){
            line.append(lin+"\n");
           }
            System.out.println(line);

       } catch (IOException e) {
            e.printStackTrace();
       }

    }

    private static String arrayToString(int[][] array) {
        StringBuilder str = new StringBuilder();
        for (int[] row : array) {
            for (int j = 0; j < row.length; j++) {
                str.append(String.format("%3d ", row[j]));
            }
            str.append("\n");
        }
        return str.toString();
    }

    private static void fill(int[][] array) {
        boolean arrayMin, arrayMax;
       do{
           arrayMin = false;
           arrayMax = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array [0].length; j++) {
                    array[i][j] = (int) (Math.random()*31) - 15;
                    if (array[i][j] == 15)  arrayMax = true;
                    if (array[i][j] == -15) arrayMin = true;
                }
            }
        } while (!arrayMin & !arrayMax);
    }
}
