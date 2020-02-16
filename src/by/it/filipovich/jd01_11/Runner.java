package by.it.filipovich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> listA = new ListA<>();
        List<String> array = new ArrayList<>();
        List<String> listB = new ListB<>();
        Set<String> setC = new HashSet<>();


        listA.add("One");listA.add("Two");listA.add("Three");listA.add("Four");listA.add("Five");

        listB.add("One");listB.add("Two");listB.add("Three");listB.add("Four");listB.add("Five");

        array.add("One");array.add("Two");array.add("Three");array.add("Four");array.add("Five");

        array.addAll(listA);

        listB.remove(1);
        listB.add("Zero");
        listB.addAll(listA);

        setC.add("One");setC.add("Two");setC.add("Three");setC.add("Four");setC.add("Five");
        setC.remove("F");
        setC.contains("Four");

        System.out.println(array);
        System.out.println(setC);
    }
}
