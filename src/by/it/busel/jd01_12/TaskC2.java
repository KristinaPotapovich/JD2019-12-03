package by.it.busel.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TaskC2 {

    public static void main(String[] args) {
        Set<Integer> ints = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Long> longs = new TreeSet<>(Arrays.asList(1L, 2L, 3L, 11L, 22L, 33L));
        Set<Double> doubles = new TreeSet<>(Arrays.asList(1D, 2D, 3D, 11D, 22D, 33D, 111D, 222D, 333D));
        Set<Float> floats = new HashSet<>(Arrays.asList(1F, 2F, 3F, 11F, 22F, 33F, 111F, 222F, 333F,
                1111F, 2222F, 3333F));
        System.out.println(getCross(ints, longs, doubles, floats));
        System.out.println(getUnion(ints, longs, doubles, floats));

    }


    @SafeVarargs
    private static Set<Number> getCross(Set<? extends Number> a, Set<? extends Number>... sets) {
        Set<Number> result = new HashSet<>(a);
        a.stream().map(Number::doubleValue).forEach(result::add);
        for (Set<? extends Number> set : sets) {
            result.retainAll(set.stream().map(Number::doubleValue).collect(Collectors.toSet()));
        }
        return result;
    }

    @SafeVarargs
    private static Set<Number> getUnion(Set<? extends Number> a, Set<? extends Number>... sets) {
        Set<Number> union = new HashSet<>(a);
        for (Set<? extends Number> set : sets) {
            union.addAll(set);
        }
        return union;
    }
}
