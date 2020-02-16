package by.it.shpakovskiy.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskC {
    private static Scanner scanner;
    public static void main(String[] args) throws Exception {
        scanner=new Scanner(System.in);
        readData();
    }

    static void readData() throws Exception {
        int count=0;
        List<Double> list=new ArrayList<>();
        while (true){
            try {
                list.add(Double.parseDouble(scanner.next()));
            }catch (NumberFormatException e){
                count++;
                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i)+" ");
                }
                System.out.println();
                if (count==5){
                    throw new Exception(e);
                }
            }
        }
    }
}
