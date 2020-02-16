package by.it.borodachev.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskC1_1<K,V> {
    private Map<K,V> field=new HashMap<K,V>();
    private Map <V,K> revfield= new HashMap<V, K>();

    private void reverseMap() {
        for (Map.Entry<K, V> fieldSet : field.entrySet()) {
            // Будем оставлять только первое вхождение . без проверки остается только последнее
            if (!revfield.containsKey(fieldSet.getValue()))
            {
                revfield.put(fieldSet.getValue(), fieldSet.getKey());
            }
        }
    }
    public static void main(String[] args) {
        TaskC1_1 obj =new TaskC1_1<String,Integer>();

        Scanner scanner = new Scanner(System.in);
        Integer key = 0;
        String word = scanner.next();
        while (!word.equals("end")) {
            obj.field.put(key++,word);
            word = scanner.next();
        }
        obj.reverseMap();
        System.out.println(obj.revfield);

    }
}

