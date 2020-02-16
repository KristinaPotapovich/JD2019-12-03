package by.it.kuzmichalex.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> map = new TreeMap<>();
        int iCount = 1;
        Random rnd = new Random();
        while (true) {
            String inputString = scanner.next();
            if (inputString.toLowerCase().equals("end")) break;
            map.put((iCount << 16) + rnd.nextInt(65536), inputString);
            iCount++;
        }
        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println(integerStringEntry.getValue() + " : " + integerStringEntry.getKey());
        }
        //remove duplicates
        Set<String> uniqueNames = new HashSet<>();
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        entrySet.removeIf(next -> !uniqueNames.add(next.getValue()));   //Крики благодарности в адрес Idea!

        System.out.println("Compressed by name:");
        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println(integerStringEntry.getValue() + " : " + integerStringEntry.getKey());
        }

    }
}
