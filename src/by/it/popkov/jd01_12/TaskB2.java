package by.it.popkov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class TaskB2 {
    static String process(ArrayList<String> peoples) {
        ArrayList<String> copy = new ArrayList<>(peoples);
        boolean a = false;
        while (copy.size() > 1) {
            Iterator<String> iterator = copy.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (a) {
                    iterator.remove();
                    a = false;
                } else a = true;
            }
        }
        return copy.get(0);
    }

    static String process(LinkedList<String> peoples) {
        LinkedList<String> copy = new LinkedList<>(peoples);
        boolean a = false;
        while (copy.size() > 1) {
            Iterator<String> iterator = copy.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (a) {
                    iterator.remove();
                    a = false;
                } else a = true;
            }
        }
        return copy.get(0);
    }

    public static void main(String[] args) {
        System.out.println(process(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"))));
        System.out.println(process(new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"))));
    }
}
