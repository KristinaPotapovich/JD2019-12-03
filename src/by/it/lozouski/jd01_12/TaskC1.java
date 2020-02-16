package by.it.lozouski.jd01_12;

import java.util.*;

class TaskC1 {

    static Scanner sc1;
    static TreeMap<Integer, String> c1 = new TreeMap<>();
    static HashMap<String, Integer> tempMap = new HashMap<>();
    static Random uniqueId;

    public static void main(String[] args) {
        sc1 = new Scanner(System.in); //сканер
        uniqueId = new Random(); //генерируем рандомный шифр

        //Метод для заполнения списка парой: уникальный ключ - значение(Строка)
        readData();

        //Метод перекидывает Пары из TreeMap c1 в HashMap tempMap
        //Таким образом Уникальными ключами там будут уже Строки
        //соответственно одинаковые строки "отсеятся"
        createHashMapWithUniqueValues();

        c1.clear(); //почистим коллекцию, под заполнение новыми данными

        //метод перекидывает пары из HashMap обратно в TreeSet
        //и снова ключом будет шифр, а значением строка
        putToC1MapUniqueValues();

        //распечатка Мапы в произвольном виде
        printCompressedMapC1(c1);
    }

    static void putToC1MapUniqueValues() {
        Set<Map.Entry<String, Integer>> newSet = tempMap.entrySet();
        for (Map.Entry<String, Integer> entry : newSet) {
            c1.put(entry.getValue(), entry.getKey());
        }
    }

    static void createHashMapWithUniqueValues() {
        Set<Map.Entry<Integer, String>> entries = c1.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            tempMap.put(entry.getValue(), entry.getKey());
        }
    }

    static void readData() {
        while (true) {
            String inputString = sc1.next();
            if (!inputString.equals("end")) {
                int uniqueIdValue = uniqueId.nextInt();
                c1.put(uniqueIdValue, inputString);
            } else break;
        }
    }

    static void printCompressedMapC1(TreeMap<Integer, String> nameMap) {
        int numEntry = 0;
        for (Map.Entry<Integer, String> integerStringEntry : nameMap.entrySet()) {
            System.out.printf(++numEntry + ". Уникальный шифр =% 11d, Значение = %s\n",
                    integerStringEntry.getKey(), integerStringEntry.getValue());
        }
    }
}
