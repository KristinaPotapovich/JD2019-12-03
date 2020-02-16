package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskC2 {
//    @SafeVarargs
//    static <T extends Number> Set<T> getUnion(Set<T>... sets) {
//        Set<T> result=new HashSet<>(sets[0]);
//        for (int i = 1; i < sets.length; i++) {
//            result.addAll(sets[i]);
//        }
//        return result;
//    }

    @SafeVarargs
    static Set<Number> getCross(Set<Number>... sets) {
        Set<Number> result = new HashSet<>(sets[0].size());
        sets[0].forEach(elem -> result.add(elem.doubleValue()));
        for (int i = 1; i < sets.length; i++) {
            HashSet<Double> set = new HashSet<>();
            sets[i].forEach(number -> set.add(number.doubleValue()));
            result.retainAll(set);
        }
        return result;
    }

    @SafeVarargs
    static Set<Number> getUnion(Set<Number>... sets) {
        Set<Number> result = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            result.addAll(sets[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] d1 = {1, 2, 3, 4, 5, 7, 10};
        Double[] d2 = {2d, 3d, 4d, 5d, 6d, 7d, 8d, 10d};
        Long[] d3 = {1L, 2L, 3L, 7L, 9L, 10L};
        Float[] d4 = {2f, 3f, 4f, 7f, 9f, 10f};
        Set<Number> set1 = new HashSet<>(Arrays.asList(d1));
        Set<Number> set2 = new TreeSet<>(Arrays.asList(d2));
        Set<Number> set3 = new HashSet<>(Arrays.asList(d3));
        Set<Number> set4 = new TreeSet<>(Arrays.asList(d4));
        System.out.println("Cross: " + getCross(set1, set2, set3, set4));
        System.out.println("Union: " + getUnion(set1, set2, set3, set4));
    }
}
