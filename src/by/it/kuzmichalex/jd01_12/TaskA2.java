package by.it.kuzmichalex.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    /**
     * Метод для определения пересечения 2х множеств
     *
     * @param setOne Первое множество
     * @param setTwo Второе множество
     * @return Третье множество, являющееся пересечением первых двух. Порядок абы-какой.
     */
    static Set<Integer> getCross(Set<Integer> setOne, Set<Integer> setTwo) {
        Set<Integer> returnSet = new HashSet<>(setOne);
        returnSet.retainAll(setTwo);
        return returnSet;
    }

    /**
     * Метод для объединения 2х множеств с сохранением уникальности каждого элемента
     *
     * @param setOne Первое множество
     * @param setTwo Второе множество
     * @return Третье множество, являющееся объединением первых двух, причём отсортированное
     */
    static Set<Integer> getUnion(Set<Integer> setOne, Set<Integer> setTwo) {
        Set<Integer> returnSet = new TreeSet<>(setOne);
        returnSet.addAll(setTwo);
        return returnSet;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(0, 1, 1, 3003, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 11, 10, 1001));
        Set<Integer> b = new TreeSet<>(Arrays.asList(19, 18, 17, 16, 15, 15, 1001, 15, 14, 13, 12, 11, 10, 2002));
        System.out.println("HashSet: " + a);
        System.out.println("TreeSet: " + b);
        Set<Integer> crossSet = getCross(a, b);
        System.out.println("cross:   " + crossSet);
        Set<Integer> unionSet = getUnion(a, b);
        System.out.println("union:   " + unionSet);

    }
}
