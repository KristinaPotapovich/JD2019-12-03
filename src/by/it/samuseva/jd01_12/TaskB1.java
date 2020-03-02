package by.it.samuseva.jd01_12;

import java.util.*;

public class TaskB1 {
    private  Map<String, Integer> words = new HashMap<>();

    private Integer value (String word){
       // Integer i = 1;
        for(Map.Entry<String,Integer> item : words.entrySet()){
            if (item.getKey() == null) words.putIfAbsent(word, 1);
            else  if (item.getKey().equals(word)) {
                item.setValue(item.getValue()+1);
                return item.getValue();
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        TaskB1 map = new TaskB1();
        // Map<String, Integer> words = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String word = scan.next();
            word = word.replaceAll("[—,.:;?!()]+", "");

            if (word.equals("end")) break;
            else {
                 map.words.putIfAbsent(word,map.value(word));
            }
        }
        for(Map.Entry<String,Integer> item : map.words.entrySet()){
            System.out.println(item.getKey() + "=" + item.getValue());
        }
    }
}
