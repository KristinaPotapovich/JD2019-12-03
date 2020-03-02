package by.it.shulga.jd01.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String,Integer> map = new HashMap<String, Integer>(){
            @Override
            public Integer put(String key, Integer value) {
                if(key.equals("isn't")) key="don't";
                Integer oldva=super.put(key, value);
                if (oldva!=null)
                    super.put(key, ++oldva);
                return oldva;
            }
        };
        while (true) {
            String next = scanner.next();
            if(next.equals("end")) break;
            next= next.replaceAll("[-.,)(;:!?]","");
            map.put(next,1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }



    }
}