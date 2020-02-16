package by.it.shpakovskiy.jd01_14;

import java.io.*;
import java.util.ArrayList;

class TaskA {
    public static void main(String[] args) {
        String fileName = "src/by/it/shpakovskiy/jd01_14/dataTaskA.bin";
        writBinFile(fileName);
        ArrayList<Integer> list = new ArrayList<>();
        readFileInList(fileName,list);
        printListAndAvg(list);
        String resultFileName = "src/by/it/shpakovskiy/jd01_14/resultTaskA.txt";
        printListAndAvgToFile(list, resultFileName);
    }

    private static void printListAndAvg(ArrayList<Integer> list) {
        list.forEach(v -> System.out.print(v + " "));
        System.out.println();
        System.out.println("avg=" + getAvg(list));
    }

    private static double getAvg(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return (double) sum / list.size();
    }

    private static void printListAndAvgToFile(ArrayList<Integer> list, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            list.forEach(v -> printWriter.print(v + " "));
            printWriter.println();
            printWriter.print("avg=" + getAvg(list));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readFileInList(String fileName, ArrayList<Integer> list) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (dataInputStream.available() > 0) {
                list.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writBinFile(String fileName) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int) (Math.random() * 100) * i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
