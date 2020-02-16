package by.it.kuzmichalex.jd01_12;

import java.util.*;

public class TaskC2 {

    /**
     * Метод для определения пересечения N множеств
     *
     * @param - Э! А что подстказа не выскакивает? Короче, передавайте множество множеств
     * @return множество, являющееся пересечением переданных. Порядок абы-какой.
     */
    @SuppressWarnings("all")
    static Set<?> getCross(Set<?> setStart, Set<?>... sets) {
        Set<?> returnSet = new HashSet<>(setStart);
        for (Set<?> set : sets) {
            returnSet.retainAll(set);
        }
        return returnSet;
    }

    /**
     *
     *
     * @param - так и не дожэдался подсказки. А без неё не можется. Эта самая ителижиидея делает из людей лентяев!
     * @return множество, являющееся объединением переданных. С натуральной, без ГМО, сортировкой!
     */
    @SuppressWarnings("all")
    private static <set> Set<? extends Number> getUnion(Set<? extends Number>... sets) {
        Set<Number> returnSet = new TreeSet<>();
        for (Set<? extends Number> set : sets) {
            returnSet.addAll(set);
        }
        return returnSet;
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        System.out.println("-------------------------testing witch int");
        Set<? extends Number> a_int = new HashSet<>(Arrays.asList(0, 1, 1, 3003, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 11, 10, 1001));
        Set<? extends Number> b_int = new TreeSet<>(Arrays.asList(19, 18, 17, 16, 15, 15, 1001, 15, 14, 13, 12, 11, 10, 2002));
        System.out.println("HashSet : " + a_int);
        System.out.println("TreeSet1: " + b_int);

        Set<?> crossSet = getCross(a_int, b_int);
        System.out.println("cross(2 args): " + crossSet);
        Set<?> unionSet = getUnion(a_int, b_int);
        System.out.println("union(2 args): " + unionSet);

        System.out.println("-------------------------testing witch double");
        Set<? extends Number> a_double = new HashSet<>(Arrays.asList(0.0, 1.0, 1.0, 3003.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 12.0, 11.0, 10.0, 1001.0));
        Set<? extends Number> b_double = new TreeSet<>(Arrays.asList(19.0, 18.0, 17.0, 16.0, 15.0, 15.0, 1001.0, 15.0, 14.0, 13.0, 12.0, 11.0, 10.0, 2002.0));
        Set<? extends Number> c_double = new TreeSet<>(Arrays.asList(11.0, 12.0, 22.2, 33.3, 44.4));

        System.out.println("HashSet : " + a_double);
        System.out.println("TreeSet1: " + b_double);
        System.out.println("TreeSet2: " + c_double);
        crossSet = getCross(a_double, b_double, c_double);
        System.out.println("cross(3 args): " + crossSet);
        unionSet = getUnion(a_double, b_double, c_double);
        System.out.println("union(3 args): " + unionSet);


    }
}
