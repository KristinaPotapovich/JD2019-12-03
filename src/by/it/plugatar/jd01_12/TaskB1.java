package by.it.plugatar.jd01_12;

import java.util.*;
/*
Вывести все различныеслова формате слово=частота.
Слова, отличающиеся регистром букв, считать различными. isn't или don’t –одно слово.
*/

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        String word;
        while (sc.hasNext() && !(word = sc.next()).equals("end")) {
            word = word.replace(",", "");
            word = word.replace("(", "");
            word = word.replace(")", "");
            word = word.replace(".", "");
            word = word.replace("?", "");
            word = word.replace("!", "");
            word = word.replace(";", "");
            word = word.replace("\"", "");
            if (!map.containsKey(word)) map.put(word, 1);
            else {
                Integer i = map.get(word);
                map.put(word, i + 1);
            }
        }
        Integer is = map.get("isn't") == null ? 0 : map.get("isn't");
        Integer don = map.get("don't") == null ? 0 : map.get("don't");
        Integer res = is + don;
        map.put("don't", res);
        System.out.println(map);
    }
}