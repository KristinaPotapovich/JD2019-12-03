package by.it.filipovich.jd01_12;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new TreeSet<>();

        addElementsToSetA(setA);
        addElementsToSetB(setB);

        System.out.println(getUnion(setA,setB));;
        System.out.println(getCross(setA,setB));

    }

    private static void addElementsToSetA(Collection collection){
        collection.add(44);
        collection.add(23);
        collection.add(4);
        collection.add(8);
        collection.add(7);

    }

    private static void addElementsToSetB(Collection collection){
        collection.add(55);
        collection.add(23);
        collection.add(45);
        collection.add(8);
        collection.add(7);

    }

    private static Set<Integer> getCross(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> setC = new HashSet<>(setA);
        setC.retainAll(setB);
        return setC;
    }

    private static Set<Integer> getUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> setC = new HashSet<>(setA);
        setC.addAll(setB);
        return setC;
    }

}
