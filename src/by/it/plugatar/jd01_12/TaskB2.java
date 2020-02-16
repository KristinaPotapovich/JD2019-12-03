package by.it.plugatar.jd01_12;

import java.util.*;
/*
Считалка. В кругу стоят N человек.
При ведении счетапо кругу итератором вычеркивается каждый второй человек, пока не останется один.
 */
public class TaskB2 {
    public static void main(String[] args) {
        int n = 10;
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list1.add(String.valueOf(i));
            list2.add(String.valueOf(i));
        }
        System.out.println(list1);
        String process = process(list1);
        String process1 = process(list2);
        System.out.println(process);
        System.out.println(process1);
    }

    private static String process(ArrayList<String> people) {
        int m = 2;
        Iterator<String> iterator = people.iterator();
        while (people.size() != 1) {
            for (int i = 0; i < m; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(people, i);
            }
            iterator.remove();
        }
        return people.get(0);
    }

    private static String process(ArrayList<String> people, int k) {
        int m = 2;
        Iterator<String> iterator = people.iterator();
        for (int i = k; i < m; i++)
            if (iterator.hasNext()) iterator.next();
            else return process(people, i);
        iterator.remove();
        while (people.size() != 1) {
            for (int i = 0; i < m; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(people, i);
            }
            iterator.remove();
        }
        return people.get(0);
    }

    private static String process(LinkedList<String> people) {
        Iterator<String> iterator = people.iterator();
        while (people.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(people, i);
            }
            iterator.remove();
        }
        return people.get(0);
    }

    private static String process(LinkedList<String> people, int k) {
        Iterator<String> iterator = people.iterator();
        for (int i = k; i < 2; i++)
            if (iterator.hasNext()) iterator.next();
            else return process(people, i);
        iterator.remove();
        while (people.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(people, i);
            }
            iterator.remove();
        }
        return people.get(0);
    }
}