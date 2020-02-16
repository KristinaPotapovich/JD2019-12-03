package by.it.shpakovskiy.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            String line = scanner.next();
            if (line.equals("end")) {
                System.out.println("(ツ)");
                break;
            }
            line = line.replaceAll("[-.!?,;:]", "");
            map.merge(line, 1, Integer::sum);
        }
        System.out.println(map);
    }
}
