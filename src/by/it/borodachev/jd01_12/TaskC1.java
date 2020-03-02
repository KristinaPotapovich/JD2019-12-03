package by.it.borodachev.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer, String> field = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Integer key = 0;
        String word = scanner.next();
        while (!word.equals("end")) {
            field.put(key++,word);
            word = scanner.next();
        }
        Map<String, Integer> ret = new HashMap<>();
        for (Map.Entry<Integer, String> fieldSet : field.entrySet()) {
            // Будем оставлять только первое вхождение . без проверки остается только последнее
             if (!ret.containsKey(fieldSet.getValue())) {
                 ret.put(fieldSet.getValue(), fieldSet.getKey());
             }
        }
        for (Map.Entry<String,Integer> retSet : ret.entrySet()) {
            System.out.println(retSet.getValue() + "=" + retSet.getKey());
        }
    }
}

