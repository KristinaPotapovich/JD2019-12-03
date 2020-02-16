package by.it.ban.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    static String process(ArrayList<String> peoples){
        int i=1;
        while (peoples.size()>1){
            if (i>=peoples.size()) i=i-peoples.size();
            peoples.remove(i++);
        }
        return peoples.get(0);
    }

    static String process2(LinkedList<String> peoples){
        Iterator<String> iterator;
        while(peoples.size()>1){
            iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if (iterator.hasNext()) iterator.next();
                else {
                    iterator = peoples.iterator();
                    iterator.next();
                }
                iterator.remove();
            }
        }
        return peoples.getFirst();
    }
    static String process(LinkedList<String> peoples){
        while(peoples.size()>1){
            peoples.add(peoples.remove());
            peoples.remove();
        }
        return peoples.getFirst();
    }

    public static void main(String[] args) {
        int n=4096;
        ArrayList<String> aList = new ArrayList<>();
        LinkedList<String> lList = new LinkedList<>();
        LinkedList<String> lList2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            aList.add(String.valueOf(i));
            lList.add(String.valueOf(i));
            lList2.add(String.valueOf(i));
        }
        System.out.println(aList);
        long iniTime;
        double delta;
        iniTime=System.nanoTime();
        System.out.println(process(aList));
        delta=(System.nanoTime()-iniTime)/1000.0;
        System.out.println("aList="+delta);

        iniTime=System.nanoTime();
        System.out.println(process(lList));
        delta=(System.nanoTime()-iniTime)/1000.0;
        System.out.println("lList="+delta);
        //Время работы для  ArrayList=5869 мкс
        //Время работы для LinkedList=12823 мкс.(lList как Array по индексу)
        //Время работы для  ArrayList=4810 мкс.
        //Время работы для LinkedList=2068 мкс.(lList через Iterator - next-next работает быстрее чем индекс)
        iniTime=System.nanoTime();
        System.out.println(process2(lList2));
        delta=(System.nanoTime()-iniTime)/1000.0;
        System.out.println("lList="+delta);
        //Время работы для  LinkedList=136.7 с добавлением в конец
    }
}
