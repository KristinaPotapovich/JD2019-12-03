package by.it.busel.jd01_12;

import java.math.BigInteger;
import java.util.*;


public class TaskC1modified {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<C1Entry<BigInteger, String>> list = new ArrayList<>();
        consoleListFiller(list, scanner);
        listPrinter(list);
        list.sort(Comparator.comparing(C1Entry::getKey));
        listPrinter(list);
        List<C1Entry<BigInteger, String>> listModified = modArrayListInitializer();
        distinctFiller(list, listModified);
        listPrinter(listModified);
    }

    /**
     * a method that fills a List of C1Entry-objects with data that is input from a console
     *
     * @param list          a list to be filled with data that is input from a console
     * @param sourceScanner a Scanner-object by the means of which data is being taken from a console
     */
    private static void consoleListFiller(List<C1Entry<BigInteger, String>> list, Scanner sourceScanner) {
        Random random = new Random();
        while (true) {
            String text = sourceScanner.next();
            if (text.equals("end")) {
                System.out.println();
                break;
            }
            list.add(new C1Entry<>(BigInteger.valueOf(hash(text.hashCode()) >>
                    (System.nanoTime() % 2 == 0 ? 2 : 1) + random.nextInt(100000)
                            + System.nanoTime()), text));
        }

    }

    /**
     * a method that modifies a standard hashcode of some object, which is got
     * by the means of a "someObject.hashcode"
     *
     * @param hashcode a standard hashcode of some object, which is got by the
     *                 means of a "someObject.hashcode"
     * @return a modified integer value
     */
    private static int hash(int hashcode) {
        hashcode ^= (hashcode >>> 20) ^ (hashcode >>> 12);
        return hashcode ^ (hashcode >>> 7) ^ (hashcode >>> 4);
    }

    /**
     * a method that prints a list containing C1Entry-object created to store
     * String-objects and their unique serial numbers
     *
     * @param list a list which is to be printed
     */
    private static void listPrinter(List<C1Entry<BigInteger, String>> list) {
        for (C1Entry<BigInteger, String> next : list) {
            System.out.println(next.getValue() + "=" + next.getKey());
        }
    }

    /**
     * a method that initializes a new ArrayList which possesses a modified
     * (overridden) "contains(Object o)" method that redirects (if possible)
     * execution to a newly created method "containsByValue(C1Entry<K, V> o)"
     * that checks whether an aforementioned ArrayList contains a C1Entry<K, V>
     * object (some kind of associative array) with a value (String) that absents in
     * "this" ArrayList
     *
     * @return a newly created object of an aforementioned ArrayList
     */
    private static List<C1Entry<BigInteger, String>> modArrayListInitializer() {
        return new ArrayList<C1Entry<BigInteger, String>>() {
            @SuppressWarnings("unchecked")
            @Override
            public boolean contains(Object o) {
                if (o != null) {
                    try {
                        return this.containsByValue((C1Entry<BigInteger, String>) o);
                    } catch (ClassCastException ignored) {
//                        return false;
                    }
                }
                return super.contains(o);
            }

            <K, V> boolean containsByValue(C1Entry<K, V> o) {
                if (o != null) {
                    for (C1Entry<BigInteger, String> listElement : this) {
                        if (listElement.getValue().equals(o.getValue())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
    }

    /**
     * a method which looks through "sourceList" (an ArrayList-object), checks
     * whether "destListWithOverriddenMethodContains" (an ArrayList-object)
     * contains an String-value from "sourceList", no matter if this "String-value"
     * has another serial number in "destListWithOverriddenMethodContains"
     * and adds a container-object with this String-value
     * to "destListWithOverriddenMethodContains"
     *
     * @param sourceList                           a source List, which elements are being checked
     * @param destListWithOverriddenMethodContains a destination list to be filled with
     *                                             objects with unique(distinct)
     *                                             String-values
     */
    private static void distinctFiller(List<C1Entry<BigInteger, String>> sourceList,
                                       List<C1Entry<BigInteger, String>> destListWithOverriddenMethodContains) {
        for (C1Entry<BigInteger, String> sEntry : sourceList) {
            if (!destListWithOverriddenMethodContains.contains(sEntry)) {
                destListWithOverriddenMethodContains.add(sEntry);
            }
        }

    }
}
