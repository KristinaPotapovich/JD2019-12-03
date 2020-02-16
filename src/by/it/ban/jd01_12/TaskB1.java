package by.it.ban.jd01_12;


import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String,Integer> map = new HashMap<String, Integer>(){
            @Override
            public Integer put(String key, Integer value) {
                if(key.equals("isn't")) key="don't";
                Integer oldValue=super.put(key, value);
                if (oldValue!=null)
                    super.put(key, ++oldValue);
                return oldValue;
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
