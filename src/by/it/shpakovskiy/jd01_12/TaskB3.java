package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskB3 {
    static String process(ArrayList<String> peoples) {
        return TaskB2.process(peoples);
    }

    static String processI(LinkedList<String> peoples) {
        return TaskB2.process(peoples);
    }

    static String process(LinkedList<String> peoples) {
        String cash;
        while (peoples.size()>1){
            cash=peoples.pollFirst();
            peoples.removeFirst();
            peoples.addLast(cash);
        }
        return peoples.getFirst();
    }

    public static void main(String[] args) {
        String[] array = new String[40960];
        for (int i = 0; i < array.length; i++) {
            array[i] = "" + (i + 1);
        }
        List<String> list = Arrays.asList(array);
        ArrayList<String> arrayList = new ArrayList<>(list);
        LinkedList<String> linkedList = new LinkedList<>(list);
        long startA=System.nanoTime();
        String a=process(arrayList);
        long finishA=System.nanoTime();
//        String b=processI(linkedList);
//        long finishB=System.nanoTime();
        String c=process(linkedList);
        long finishC=System.nanoTime();
        System.out.println(a+" "+((finishA-startA)/1000));
//        System.out.println(b+" "+((finishB-finishA)/1000));
        System.out.println(c+" "+((finishC-finishA)/1000));
    }
}
