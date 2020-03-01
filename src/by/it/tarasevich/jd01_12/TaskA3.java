package by.it.tarasevich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        int pos = 0;
        while (!(str = scanner.next()).equals("end")) {
            Integer value = Integer.valueOf(str);
            if (value > 0)
                num.add(pos++, value);
            else if (value == 0)
                num.add(pos, 0);
            else
                num.add(value);
        }
        System.out.println(num);
    }
}