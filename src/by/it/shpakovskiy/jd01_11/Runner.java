package by.it.shpakovskiy.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Runner {
    public static void main(String[] args) {
        List<Integer> list=new ListB<>();
        List<Integer> list1=new ArrayList<>(2);
        list1.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list1.add(2);
        list.retainAll(list1);
        System.out.println(list1.toString());
        System.out.println(list.toString());
        HashSet<String> set=new HashSet<>();
        set.add("hello");
        set.toString();
    }
}
