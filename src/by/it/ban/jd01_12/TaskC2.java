package by.it.ban.jd01_12;

import java.util.*;

public class TaskC2 {

    private static <T> Set<T> getCross(Set<T> ... sets){
        Set<T> res = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            res.retainAll(sets[i]);
        }
        return res;
    }

    private static <T extends Number> Set<T> getUnion(Set<T> ... sets){
        Set<T> res = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            res.addAll(sets[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        TaskC2 task = new TaskC2();
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,321,3,4,4,4,5,6,7,8,3,8,9,0));
        System.out.println(a);
        Set<Integer> b=new TreeSet<>((o1, o2) -> o2-o1);
        b.addAll(Arrays.asList(1, 1, 2, 2, 4, 5, 7, 8, 9, 0, -2, 222));
        System.out.println(b);
        Set<Integer> union = getUnion(a, b);
        System.out.println(union);
        Set<Integer> cross = getCross(a, b);
        System.out.println(cross);

        Set<Double> sdA = new HashSet<>(Arrays.asList(1.0, 1.1, 1.3, 1.4, 1.5, 1.5, 1.6, 1.6));
        Set<Double> sdB = new HashSet<>(Arrays.asList(1.2, 1.3, 1.4, 1.5, 2.1, 2.1, 2.3));
        Set<Double> sdC = new HashSet<>(Arrays.asList(1.2, 1.4, 1.5, 2.1, 2.1, 2.3));
        System.out.println(getCross(sdA, sdB, sdC));
        System.out.println(getUnion(sdA, sdB,sdC));
    }


}
