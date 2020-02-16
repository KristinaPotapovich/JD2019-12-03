package by.it.ban.jd01_11;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Katya");
        list.add("Sasha");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        List<String> list1 = new ListA<>();
        list1.add("Vasya");
        list1.add("Petya");
        list1.add("Katya");
        list1.add("Sasha");
        System.out.println(list1);
        list1.remove(2);
        System.out.println(list1);

        Set<String> set1 = new HashSet<>();
        set1.add("first");
        set1.add("second");
        set1.add("third");
        set1.add("forth");
        System.out.println(set1.toString());

        SetC<String> set2 = new SetC<String>();
        set2.add("first");
        set2.add("second");
        set2.add("third");
        set2.add("forth");
        System.out.println(set2.toString());
    }


}
