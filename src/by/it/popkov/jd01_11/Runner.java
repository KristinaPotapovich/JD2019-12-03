package by.it.popkov.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<String> objects = new HashSet<>();
        Set<String> mySet = new SetC<>();
        Set<String> test = new HashSet<>();
        test.add(null);
        test.add(null);
        test.add("Lenatest");
        test.add("Taniatest1");
        test.add("Taniatest2");
        test.add("Mashatest");
        test.add("Aniatest");

        objects.add("Ksenia");
        objects.add("Ksenia");
        objects.add("Lena");
        objects.add("Tania");
        objects.add("Tania");
        objects.add("Masha");
        objects.add("Ania");
        System.out.println(objects);
        objects.remove("Masha");
        objects.addAll(test);
        System.out.println(objects);
        System.out.println(objects.contains("Gena"));
        System.out.println(objects.contains("Lena"));
        System.out.println(objects.size());
        System.out.println(objects.isEmpty());
        objects.remove("Kseniatest1");
        System.out.println(objects.containsAll(test));
        objects.removeAll(test);
        System.out.println(objects);
        System.out.println("============================================");

        mySet.add("Ksenia");
        mySet.add("Ksenia");
        mySet.add("Lena");
        mySet.add("Tania");
        mySet.add("Tania");
        mySet.add("Masha");
        mySet.add("Ania");
        System.out.println(mySet);
        mySet.remove("Masha");
        mySet.addAll(test);
        System.out.println(mySet);
        System.out.println(mySet.contains("Gena"));
        System.out.println(mySet.contains("Lena"));
        System.out.println(mySet.size());
        System.out.println(mySet.isEmpty());
        mySet.remove("Kseniatest1");
        System.out.println(mySet.containsAll(test));
        mySet.removeAll(test);
        System.out.println(mySet);

//        Map<String, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("Ksenia", new Object());
//        objectObjectHashMap.put("Lena", new Object());
//        objectObjectHashMap.put("Tania", new Object());
//        objectObjectHashMap.put("Masha", "1");
//        objectObjectHashMap.put("Ania", new Object());
//        System.out.println(objectObjectHashMap.put("Masha", "2"));
//        System.out.println(objectObjectHashMap);

    }
}
