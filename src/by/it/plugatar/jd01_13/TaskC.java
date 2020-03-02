package by.it.plugatar.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static List<Double> lst = new ArrayList<>();
    private static String ln;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int err = 0;
        while (err < 5) {
            ln = sc.next();
            try {
                readData();
            } catch (Exception e){
                err++;
            }
        }
        throw new Exception("error");
    }

    private static void readData() throws Exception {
        try {
            lst.add(Double.parseDouble(ln));
        } catch (IllegalArgumentException e) {
            Thread.sleep(100);
            for (int i = lst.size() - 1; i >= 0; i--) {
                System.out.print(lst.get(i) + " ");
            }
            System.out.println();
            throw new Exception();
        }

    }
}
