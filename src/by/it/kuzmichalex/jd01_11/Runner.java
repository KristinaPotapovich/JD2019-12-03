package by.it.kuzmichalex.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {

        ArrayList<Integer> ll = new ArrayList<Integer>();
        ll.add(5);
        ll.add(6);
        ll.add(7);

        SetC<Integer> sc = new SetC<>();
        sc.add(1);
        sc.add(2);
        sc.add(3);
        sc.add(4);

        System.out.println("sc:" + sc);
        System.out.println("ll:" + ll);
        sc.addAll(ll);
        System.out.println("sc:" + sc);
        sc.remove(2);
        System.out.println("sc:" + sc);

    }

}
