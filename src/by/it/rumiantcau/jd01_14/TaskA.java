package by.it.rumiantcau.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TaskA {
    public static void main(String[] args) {
        String fileName = Helper.getPath("dataTaskA.bin", TaskA.class);
        TaskAWrite.writeInt(fileName);


        List<Integer> list = new ArrayList<>();
        readListInteger(fileName, list);

        printListToConsole(list);

        String resultTxt = Helper.getPath("ResultTaskA.txt", TaskA.class);
        printListToFile(list, resultTxt);
    }


    private static void printListToFile(List<Integer> list, String resultTxt) {
        try (PrintWriter writer = new PrintWriter(resultTxt)){
            double sum=0;
            for (Integer i : list) {
                writer.print(i + " ");
                sum+=i;
            }
            writer.println("\navg="+sum/list.size());

        } catch (FileNotFoundException e) {
            System.out.println("Ниасилил");
        }
    }

    private static void printListToConsole(List<Integer> list) {
        double sum=0;
        for (Integer i : list) {
            System.out.print(i + " ");
            sum+=i;
        }
        System.out.println("\navg="+sum/list.size());
    }

    private static void readListInteger(String fileName, List<Integer> list) {
        try (
                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        ) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            System.out.println("Ниасилил");
        }
    }

}
