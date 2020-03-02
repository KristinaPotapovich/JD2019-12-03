package by.it.shulga.jd01.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {

        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {

        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,1,1,2,2,2,3,3,4,4,5,6,7,8,8,9,10));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(11,12,1,2,233,2,34,3,4,44,5,6,7,88,8,9,10));
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));
    }
}
