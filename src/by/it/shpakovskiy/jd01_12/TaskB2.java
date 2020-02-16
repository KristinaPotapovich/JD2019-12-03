package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskB2 {
    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count++ % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count++ % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        String[] array = new String[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = "" + (i + 1);
        }
        List<String> list = Arrays.asList(array);
        ArrayList<String> arrayList = new ArrayList<>(list);
        LinkedList<String> linkedList = new LinkedList<>(list);
        long startA=System.nanoTime();
        String a=process(arrayList);
        long finishAAndStartB=System.nanoTime();
        String b=process(linkedList);
        long finishB=System.nanoTime();
        System.out.println(a+" "+((finishAAndStartB-startA)/1000));
        System.out.println(b+" "+((finishB-finishAAndStartB)/1000));
    }
}
