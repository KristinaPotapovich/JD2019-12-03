package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Long, String> c1 = new TreeMap<>();
        while (true) {
            String line = scanner.next();
            if (line.equals("end")) {
                break;
            }
            c1.put(System.nanoTime(), line);
        }
        System.out.println(c1);
        Set<String> set=new HashSet<>(c1.size());
        c1.values().removeIf(v->!set.add(v));
        System.out.println("________________________________");
        System.out.println(c1);
    }
}
