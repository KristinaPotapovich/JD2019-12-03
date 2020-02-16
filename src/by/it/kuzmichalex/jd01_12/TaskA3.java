package by.it.kuzmichalex.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int idxZero = 0;
        while (true) {
            String inputString = scanner.next();
            if (inputString.toLowerCase().equals("end")) break;
            Integer inputInteger = Integer.valueOf(inputString);
            if (inputInteger < 0) list.add(inputInteger);
            else if (inputInteger == 0) list.add(idxZero, inputInteger);
            else list.add(idxZero++, inputInteger);
        }
        System.out.println(list);
    }
}
