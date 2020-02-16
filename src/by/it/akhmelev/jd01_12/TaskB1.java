package by.it.akhmelev.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TaskB1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;
            String[] words = line.split("[^a-zA-Z']+");
            for (String word : words) {
                if (word.equals("end")) break;
                if (map.containsKey(word)) {
                    Integer integer = map.get(word);
                    integer++;
                    map.put(word, integer);
                } else {
                    map.put(word, 1);
                }
            }
        }


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }


    }


}
