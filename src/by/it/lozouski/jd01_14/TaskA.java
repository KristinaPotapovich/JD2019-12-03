package by.it.lozouski.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {
    public static void main(String[] args) {
        String fileName = Helper.getPath("dataTaskA.bin", TaskA.class);
        write(fileName);

        List<Integer> list = new ArrayList<>();
        read(fileName,list);
        printToConsole(list);

        String resultTaskA = Helper.getPath("resultTaskA.txt", TaskA.class);
        printToFile(resultTaskA,list);

    }
    static void write(String fileName){
        try (
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))
        ){
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 50);
                dos.write(value);
            }
        } catch (IOException e) {
            System.out.println("Всё поломалось!!!");
            e.printStackTrace();
        }
    }
    static void read(String fileName,List<Integer> list){
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (dis.available() > 0){
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            System.out.println("Всё поломалось!!!");
            e.printStackTrace();
        }
    }

    static void printToConsole(List<Integer> list){
        double sum = 0;
        for (Integer element : list) {
            System.out.print(element+" ");
            sum+=element;
        }
        double avg = sum/list.size();
        System.out.println('\n'+"avg="+avg);
    }
    static void printToFile(String resultTaskA, List<Integer> list){
        try( PrintWriter writer = new PrintWriter(resultTaskA)){
            double sum = 0;
            for (Integer element : list) {
                writer.print(element+" ");
                sum+=element;
            }
            double avg = sum/list.size();
            writer.print('\n'+"avg="+avg);
        } catch (FileNotFoundException e) {
            System.out.println("Всё поломалось!!!");
            e.printStackTrace();
        }
    }
}
