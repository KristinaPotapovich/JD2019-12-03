package by.it.ban.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner scan;
    private static List<Double> list;

    public static void main(String[] args) {
        scan= new Scanner(System.in);
        list = new ArrayList<>();
        readData();
    }
    static void readData() {
        int errorCounter=0;
        while (true) {
            String next = scan.next();
            String delim="";
            try {
                double d = Double.parseDouble(next);
                list.add(d);
            } catch (NumberFormatException e) {
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException ignored) { }
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(delim+ list.get(i));
                    delim=" ";
                }
                System.out.println();
                errorCounter++;
                if(errorCounter>=5) throw e;
            }
        }




    }
}
