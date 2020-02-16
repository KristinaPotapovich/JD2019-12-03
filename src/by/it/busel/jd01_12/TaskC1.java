package by.it.busel.jd01_12;


import java.math.BigInteger;
import java.util.*;

public class TaskC1 {
    private static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<BigInteger, String> map = new TreeMap<BigInteger, String>();
        Random random = new Random();
        while (true) {
            String text = scanner.next();
            if (text.equals("end")) {
                break;
            }
            map.put(BigInteger.valueOf(hash(text.hashCode()) + random.nextInt(100000)
                    + System.nanoTime()), text);
        }
        Set<String> unique = new HashSet<>(map.size());
        map.values().removeIf(s -> !unique.add(s));


//        Map<String, BigInteger> containerModified = new LinkedHashMap<>();
//        Set<Map.Entry<BigInteger, String>> entries = containerUnmodified.entrySet();
//        for (Map.Entry<BigInteger, String> entry : entries) {
//            containerModified.putIfAbsent(entry.getValue(), entry.getKey());
//        }
//        for (Map.Entry<String, BigInteger> entry : containerModified.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//        sort(list, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
    }
}
