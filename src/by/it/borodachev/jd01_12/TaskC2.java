package by.it.borodachev.jd01_12;

import java.util.*;

public class TaskC2 <T extends Number> {

    private  Set<T> getCross(Set<T> ... a){
        Set <T> res = new HashSet();
        res.addAll(a[0]);
        for (int i = 1; i < a.length; i++) {
            res.retainAll(a[i]);
        }
        return res;
    }

    private  Set <T> getUnion(Set<T>... a){
        Set <T> res = new HashSet();
        res.addAll(a[0]);
        for (int i = 1; i < a.length; i++) {
            res.addAll(a[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        TaskC2 obj =new TaskC2();

        HashSet<Integer> a=new HashSet<Integer>();
        a.addAll(Arrays.asList(1,2,3,3,3,4,4,4,5,6,7,8,3,8,9,0));
        System.out.println(a);
        HashSet b=new HashSet();
        b.addAll(Arrays.asList(1, 1, 2.2, 2, 4, 5, 7, 8, 9, 0, -2.4, 222));
        System.out.println(b);

        Set<Number> union = obj.getUnion(a, b,b);
        System.out.println(union);
    }

}
