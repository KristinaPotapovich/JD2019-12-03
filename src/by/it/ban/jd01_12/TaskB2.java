package by.it.ban.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    static String process(ArrayList<String> peoples){
        int i=1;
        while (peoples.size()>1){
            if (i>=peoples.size()) i=i-peoples.size();
            peoples.remove(i++);
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int i=1;
        while(peoples.size()>1){
            if (i>=peoples.size()) i=i-peoples.size();
            peoples.remove(i++);
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        int n=15;
        ArrayList<String> aList = new ArrayList<>();
        LinkedList<String> lList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            aList.add(String.valueOf(i));
            lList.add(String.valueOf(i));
        }
        System.out.println(aList);
        System.out.println(process(aList));
        System.out.println(lList);
        System.out.println(process(lList));

    }
}
