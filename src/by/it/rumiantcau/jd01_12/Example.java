package by.it.rumiantcau.jd01_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Example {

    public static void main(String[] args) {
        Map<String, Integer> map = new
                HashMap<>();
        map.put("10", 10);
        map.put("1", 1);
        map.put("2", 11);
        map.put("3", 111);
        map.put("5", 11111);
        for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getKey().equals("2"))
                map.remove(entry.getKey());
            else
                System.out.println(entry.getKey() + "=" + entry.getValue());
        }


    }


}
