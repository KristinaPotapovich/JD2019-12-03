package by.it.tarasevich.jd01_12;

import sun.plugin.javascript.navig.Array;

import java.util.*;

public class TaskA2 {
    private static Set<Integer> a = new TreeSet<>(Arrays.asList(1,6,9,5,2,4,5,6,7,7));
    private static Set<Integer> b = new HashSet<>(Arrays.asList(5,6,6,4,2,1,1,3,2,8,7));

    static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;

    }
    static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    public static void main(String[] args) {
        TaskA2 task = new TaskA2();
        System.out.println(task.getCross(a, b));
        System.out.println(task.getUnion(a, b));

    }
}
