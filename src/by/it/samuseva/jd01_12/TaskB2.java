package by.it.samuseva.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        List<String> lest = new ArrayList<String>();


    }
    static String process(ArrayList<String> peoples){
            Iterator<String> iterator = peoples.iterator();
            while (peoples.size()==1){
                iterator.hasNext();
                if (peoples.size()%2 == 0) {
                   iterator.next();
                   iterator.next();
                   iterator.remove();

                } else System.out.println("null");


        }
        return peoples.get(0);

    }
    static String process(LinkedList<String> list){
        String rez = "123";
        return rez;
    }
}
