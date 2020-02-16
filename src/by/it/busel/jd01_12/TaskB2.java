package by.it.busel.jd01_12;

import java.util.*;

class TaskB2 {
    public static void main(String[] args) {
        Random random = new Random();
        List<String> list = randomStringsAsList(random.nextInt(100) + 10);
        ArrayList<String> arrlist = new ArrayList<String>(list);
        LinkedList<String> linlist = new LinkedList<String>(list);
        String lastFromArrList = process(arrlist);
        System.out.println(lastFromArrList);
        String lastFromLinList = process(linlist);
        System.out.println(lastFromLinList);
    }

    private static List<String> randomStringsAsList(int capacity) {
        String[] sample = new String[capacity];
        for (int i = 1; i < capacity; i++) {
            sample[i] = "n" + i;
        }
        return Arrays.asList(sample);
    }

    private static String process(ArrayList<String> peoples) {
        boolean second = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (second) {
                    iterator.remove();
                    second = false;
                } else {
                    second = true;
                }
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        boolean second = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (second) {
                    iterator.remove();
                    second = false;
                } else {
                    second = true;
                }
            }
        }
        return peoples.get(0);
    }
}
