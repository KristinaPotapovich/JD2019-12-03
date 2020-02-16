package by.it.busel.jd01_12;

import java.util.*;

class TaskA2 {
    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<Integer>(a);
        result.retainAll(b);
        return result;
    }

    private static List<Integer> intFiller() {
        Random randomaizer = new Random();
        Integer[] integers = new Integer[25];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = randomaizer.nextInt(100);
        }
        return Arrays.asList(integers);
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> union = new HashSet<Integer>(a);
        union.addAll(b);
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<Integer>(intFiller());
        Set<Integer> b = new TreeSet<Integer>(intFiller());
        Set<Integer> cross = getCross(a, b);
        Set<Integer> union = getUnion(a, b);

    }
}
