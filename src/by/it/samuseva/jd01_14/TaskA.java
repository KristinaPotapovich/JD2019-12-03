package by.it.samuseva.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String fileName = Helper.getPath("dataTaskA.bin", TaskA.class);
        writeInt(fileName);

        List<Integer> list = new ArrayList<>();
        readListInteger(fileName, list);
        printListToConsol(list);

        String resultFile = Helper.getPath("resultTaskA.txt", TaskA.class);
        writerListToFile(list, resultFile);

    }

    private static void writeInt(String fileName) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            for (int i = 0; i <20 ; i++) {
                dos.writeInt((int) (Math.random()*100));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readListInteger(String fileName, List<Integer> list) {
        try (DataInputStream input = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))
        )
        {
            while (input.available()>0){
                list.add(input.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printListToConsol(List<Integer> list) {
        double sum = 0;
        for (Integer element : list) {
            System.out.print(element + " ");

            sum +=element;
        }
        System.out.println("\navg="+ sum/list.size());
    }

    private static void writerListToFile(List<Integer> list, String resultFile) {
        try (PrintWriter pw = new PrintWriter(resultFile))
        {
            double sum = 0;
            for (Integer element : list) {
                pw.print(element + " ");
                sum +=element;
            }
            pw.print("\navg="+ sum/list.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


