package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskA2 {
    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(5, 8, 9, 13, 81, 64, 398, 846, 154);
        Set<Integer> a = new HashSet<>(listA);
        List<Integer> listB = Arrays.asList(46, 85, 368, 425, 1627, 5, 102, 746, 9, 398);
        Set<Integer> b = new TreeSet<>(listB);
        System.out.println("listA = " + listA);
        System.out.println("setA = " + a);
        System.out.println("listB = " + listB);
        System.out.println("setB = " + b);
        System.out.println("Cross: " + getCross(a, b));
        System.out.println("Union: " + getUnion(a, b));
    }
}
