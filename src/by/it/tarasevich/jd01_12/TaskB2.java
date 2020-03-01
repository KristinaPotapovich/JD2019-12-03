package by.it.tarasevich.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] names = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        List<String> list1 = new ArrayList<>(Arrays.asList(names));
        List<String> list2 = new LinkedList<>(Arrays.asList(names));

        System.out.println(process((ArrayList<String>) list1));
        System.out.println(process((LinkedList<String>) list2));
    }

    static String process(ArrayList<String> peoples) {
        //     do {
        //         for (int i = 0; i < peoples.size(); i = i + 1)
        //             peoples.remove(i+1);
        //     }
        //    while ((peoples.size() > 1));
        boolean out = false;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            {
                while (it.hasNext()) {
                    it.next();
                    if (out) {
                        it.remove();
                        out = false;
                    } else
                        out = true;
                }
            }
        }


        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        //   do {
        //     for (int i = 0; i < peoples.size(); i = i+1)
        //         peoples.remove(i+1);
        //     }
        //      while ((peoples.size() > 1));

        boolean out = false;
        while (peoples.size() > 1) {
            Iterator<String> it = peoples.iterator();
            {
                while (it.hasNext()) {
                    it.next();
                    if (out) {
                        it.remove();
                        out = false;
                    } else
                        out = true;
                }
            }
        }

        return peoples.get(0);
    }
}



