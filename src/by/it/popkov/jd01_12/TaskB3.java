package by.it.popkov.jd01_12;

import java.util.*;

public class TaskB3 {
    static String process(ArrayList<String> peoples) {
        ArrayList<String> copy = new ArrayList<>(peoples);
        boolean even = false;
        while (copy.size() > 1) {
            Iterator<String> iterator = copy.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (even) {
                    iterator.remove();
                    even = false;
                } else even = true;
            }
        }
        return copy.get(0);
    }

    static String process(LinkedList<String> peoples) {
        Deque<String> copy = new LinkedList<>(peoples);
        boolean even = false;
        while (copy.size() > 1) {
            if (even) {
                copy.removeFirst();
                even = false;
            } else {
                copy.add(copy.removeFirst());
                even = true;
            }
        }
        return copy.getFirst();
    }

    public static void main(String[] args) {
        String[] array = new String[409600];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i);
        }
        System.out.println(process(new ArrayList<>(Arrays.asList(array))));
        System.out.println(process(new LinkedList<>(Arrays.asList(array))));
    }
}
