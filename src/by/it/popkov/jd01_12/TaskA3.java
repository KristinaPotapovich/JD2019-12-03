package by.it.popkov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>();
        int nullPos = 0;
        while (true) {
            String strScan = scanner.next();
            if (strScan.equals("end")) break;
            Integer i = Integer.valueOf(strScan);
            if (i > 0) {
                arrayList.add(nullPos++, i);
            } else if (i < 0) arrayList.add(i);
            else arrayList.add(nullPos, i);
        }
        System.out.println(arrayList);
    }
}
