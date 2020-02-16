package by.it.akhmelev.jd01_12;

import java.util.*;

public class TaskA2 {

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> res = new HashSet<>(a);
        res.addAll(b);
        return res;

    }

    public static void main(String[] args) {
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,321,3,4,4,4,5,6,7,8,3,8,9,0));
        System.out.println(a);
        Set<Integer> b=new TreeSet<>((o1, o2) -> o2-o1);
        b.addAll(Arrays.asList(1, 1, 2, 2, 4, 5, 7, 8, 9, 0, -2, 222));
        System.out.println(b);
        Set<Integer> union = getUnion(a, b);
        System.out.println(union);


    }


}
