package by.it.plugatar.jd01_11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Katya");
        list.add("Sasha");
        System.out.println(list);
        list.remove(2);

        //Iterator<String> iterator = list.iterator();

        List<String> list1 = new ArrayList<>();
        list1.add("Vasya");
        list1.add("Petya");
        list1.add("Katya");
        list1.add("Sasha");
        System.out.println(list1);
    }
}
