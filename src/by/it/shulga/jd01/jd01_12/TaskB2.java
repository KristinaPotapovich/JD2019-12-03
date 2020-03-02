package by.it.shulga.jd01.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {
    static String process(ArrayList<String> ludi){
        int i=1;
        while (ludi.size()>1){
            if (i>=ludi.size()) i=i-ludi.size();
            ludi.remove(i++);
        }
        return ludi.get(0);
    }

    static String process(LinkedList<String> ludi){
        int i=1;
        while(ludi.size()>1){
            if (i>=ludi.size()) i=i-ludi.size();
            ludi.remove(i++);
        }
        return ludi.get(0);
    }

    public static void main(String[] args) {
        int n=20;
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