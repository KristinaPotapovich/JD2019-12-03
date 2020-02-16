package by.it.lozouski.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(3,5,7,9,0,2,4,514,20,4,2,0,0,2,1,1,6,22,5));
        Set<Integer> b = new TreeSet<>(Arrays.asList(2,4,1,7,8,4,2,2,514,24,5,7,30));
        System.out.println(a);
        System.out.println(b);

        Set<Integer> cross = getCross(a, b);
        System.out.println(cross);

        Set<Integer> union = getUnion(a, b);
        System.out.println(union);

    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.retainAll(b);
        return resultSet;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.addAll(b);
        return resultSet;
    }
}
