package by.it.lozouski.jd01_12;

import java.util.*;
class TaskC2 {
    public static void main(String[] args) {
        System.out.println("Cross & Union Integer numbers: ");
        Set<? extends Number> a = new HashSet<>(Arrays.asList(3, 5, 7, 9, 0, 2, 4, 514, 20, 4, 2, 0, 0, 2, 1, 1, 6, 22, 5));
        Set<? extends Number> b = new TreeSet<>(Arrays.asList(2, 4, 1, 7, 8, 4, 2, 2, 514, 24, 5, 7, 30));
        System.out.println("set A: " + a);
        System.out.println("set B: " + b);

        Set<?> cross = getCross(a, b);
        System.out.println(cross);

        Set<?> union = getUnion(a, b);
        System.out.println(union);

        //--------------- A lot of sets ----------------
        System.out.println("--------------- A lot of sets ----------------");

        Set<? extends Number> set1 = new HashSet<>(Arrays.asList(0b1101, 0b1010, 0b0101, 0b0000, 0b1111));
        Set<? extends Number> set2 = new TreeSet<>(Arrays.asList(0b1101, 0b0000, 0b0101, 0b1101, 0b0101));
        Set<? extends Number> set3 = new LinkedHashSet<>(Arrays.asList(0b1101, 0b1111, 0b0010, 0b0110, 0b0000, 0b0101));

        Set<? extends Number> set4 = new HashSet<>(Arrays.asList(2.0, 2.2, 4.1, 2.5, 2.9, 220.1, 10.0, 10.1));
        Set<? extends Number> set5 = new TreeSet<>(Arrays.asList(2.4, 10.0, 2.5, 4.1, 2.9, 33.3, 44.5, 10.1));
        Set<? extends Number> set6 = new LinkedHashSet<>(Arrays.asList(10.0, 10.1, 2.4, 222.3, 4.1, 12.5, 23.1, 23.4));
        Set<?> aLotOfSetsCross1 = getCross(set1, set2, set3);
        Set<?> aLotOfSetsUnion1 = getUnion(set1, set2, set3);
        Set<?> aLotOfSetsCross2 = getCross(set4, set5, set6);
        Set<?> aLotOfSetsUnion2 = getUnion(set4, set5, set6);
        System.out.println("Binary:");
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("set3: " + set3);
        System.out.println("a lot Of Sets Cross1 : " + aLotOfSetsCross1);
        System.out.println("a lot Of Sets Union1 : " + aLotOfSetsUnion1);
        System.out.println("Double:");
        System.out.println("set4: " + set4);
        System.out.println("set5: " + set5);
        System.out.println("set6: " + set6);
        System.out.println("a lot Of Sets Cross2 : " + aLotOfSetsCross2);
        System.out.println("a lot Of Sets Union2 : " + aLotOfSetsUnion2);

    }
    static Set<?> getCross(Set<? extends Number> firstSet, Set<?>... otherSets) {
        Set<?> resultSet = new HashSet<>(firstSet);
        for (Set<?> obj : otherSets) {
            resultSet.retainAll(obj);
        }
        return resultSet;
    }

    @SafeVarargs
    static Set<? extends Number> getUnion(Set<? extends Number>... differentSets) {
        Set<Number> resultSet = new TreeSet<>();
        for (Set<? extends Number> objects : differentSets) {
            resultSet.addAll(objects);
        }
        return resultSet;
    }
}
