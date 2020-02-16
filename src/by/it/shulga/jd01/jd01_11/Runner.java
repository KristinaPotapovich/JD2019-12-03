package by.it.shulga.jd01.jd01_11;

import java.util.ArrayList;
import java.util.List;

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


        List<String> listB = new ArrayList<>();
        listB.add("111");
        listB.add("222");
        listB.add("333");
        listB.add("444");
        listB.add("555");
        System.out.println(listB);

        listB.remove(1);
        listB.add("000");

        System.out.println(listB);

    }

}
