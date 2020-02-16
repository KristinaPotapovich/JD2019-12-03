package by.it.popkov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {
    private static Set getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> outPut = new HashSet<>(a);
        outPut.retainAll(b);
        return outPut;
    }

    private static Set getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> outPut = new HashSet<>(a);
        outPut.addAll(b);
        return outPut;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(23, 6, 1, 6, 2, 21, 7, 8, 24, 2));
        Set<Integer> b = new TreeSet<>(Arrays.asList(7, 2, 56, 3, 42, 1, 6, 8, 98, 2, 10));
        System.out.println(getCross(a,b));
        System.out.println(getUnion(a,b));

    }
}
