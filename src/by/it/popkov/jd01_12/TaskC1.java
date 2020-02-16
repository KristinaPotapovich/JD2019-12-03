package by.it.popkov.jd01_12;


import java.util.*;

class TaskC1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> mapC1 = new TreeMap<>();
        HashMap<String, Integer> sort = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            String row = scanner.next();
            if (row.equals("end")) break;
            row = row.replaceAll("[—/!?:;,.)]+", "");
            int code = random.nextInt();
            while (mapC1.containsKey(code)) code = random.nextInt();
            mapC1.put(code, row);
        }
        //Меняем местами значения и ключи, что бы удалить дубликаты
        Set<Map.Entry<Integer, String>> entries = mapC1.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            sort.put(entry.getValue(), entry.getKey());
        }
        mapC1.clear();
        //Возвражаем назад
        Set<Map.Entry<String, Integer>> entries2 = sort.entrySet();
        for (Map.Entry<String, Integer> entry : entries2) {
            mapC1.put(entry.getValue(), entry.getKey());
        }
        System.out.println(mapC1);

    }
}
