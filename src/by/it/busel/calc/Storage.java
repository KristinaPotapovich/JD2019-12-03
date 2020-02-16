package by.it.busel.calc;

import java.util.*;

class Storage {
    private static Map<String, Var> map = new HashMap<>();

    static void putMapElement(String key, Var value) {
        map.put(key, value);
    }

    static void printvar() {
        Set<Map.Entry<String, Var>> entries = map.entrySet();
        Iterator<Map.Entry<String, Var>> iterator = entries.iterator();
        StringBuilder text = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, Var> me = iterator.next();
            text.append(me.getKey()).append("=").append(me.getValue().toString()).append("\n");
        }
        System.out.print(text.toString());

    }

    static void sortvar() {
        TreeMap<String, Var> treeMap = new TreeMap<>(map);
        Set<Map.Entry<String, Var>> entriesOfTryMap = treeMap.entrySet();
        Iterator<Map.Entry<String, Var>> iterator = entriesOfTryMap.iterator();
        StringBuilder text = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, Var> singleton = iterator.next();
            text.append(singleton.getKey()).append("=").append(singleton.getValue().toString()).append("\n");
        }
        System.out.print(text.toString());
    }

    static Var getVar(String key) {
        return map.get(key);
    }

    static boolean containsKey(String key) {
        return map.containsKey(key);
    }

    void clear() {
        map.clear();
    }
}
