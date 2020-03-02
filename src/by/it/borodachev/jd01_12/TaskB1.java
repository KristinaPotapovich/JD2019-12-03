package by.it.borodachev.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> rez = new HashMap<>();

        StringBuilder text = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        while (!word.equals("end")) {
            word=word.replaceAll("[,;.//-:]","");
            word=word.trim();
            if (word.length() >0) {
                Integer wordCnt = rez.get(word);
                if (wordCnt == null) {
                    wordCnt = 1;
                } else {
                    wordCnt++;
                }
                rez.put(word, wordCnt);
            }
            word = scanner.next();
        }
          for (Map.Entry<String, Integer> ret : rez.entrySet()) {
            System.out.println(ret.getKey() + "=" + ret.getValue());
        }
    }
}
