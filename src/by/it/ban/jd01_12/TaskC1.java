package by.it.ban.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random = new Random();
        Map<Integer, String> map = new TreeMap<>();
        int i;
        while (true) {
            String next = scanner.next();
            if(next.equals("end")) break;
            i=random.nextInt();
            while (map.containsKey(i)) i=random.nextInt();
            map.put(i,next);
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue()+" = "+entry.getKey());
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            map2.put(entry.getValue(),entry.getKey());
        }
        System.out.println("-------");
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
