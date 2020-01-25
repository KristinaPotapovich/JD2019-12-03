package by.it.akhmelev.jd01_11;

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
    }


}
