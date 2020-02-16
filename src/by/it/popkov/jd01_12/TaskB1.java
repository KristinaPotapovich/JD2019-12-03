package by.it.popkov.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> wordNumber = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String row = scanner.next();
            if (row.equals("end")) break;
            row = row.replaceAll("[—/!?:;,.)]+", "");
            if (!wordNumber.containsKey(row)) {
                wordNumber.put(row, 1);
            } else if (row.length()>0) {
                wordNumber.put(row, wordNumber.get(row) + 1);
            }
        }
        System.out.println(wordNumber);
    }
}
