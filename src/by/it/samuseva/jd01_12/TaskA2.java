package by.it.samuseva.jd01_12;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new TreeSet<>();
        for (int i = 0; i < 35; i++) {
            a.add((int) (Math.random()*21)-10);
            b.add((int) (Math.random()*21)-10);
        }
        System.out.println(a + "\n" + b);
        System.out.println(getUnion(a,b));

    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> rezult = new HashSet<>(a);
        rezult.addAll(b);
        return rezult;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> rezult = new HashSet<>(a);
        rezult.retainAll(b);
        return rezult;
    }

}
