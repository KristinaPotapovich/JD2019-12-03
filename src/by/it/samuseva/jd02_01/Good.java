package by.it.samuseva.jd02_01;

import java.util.*;

class Good {
    private static Map<String, Integer> goods = new HashMap<>();
    private static Set<Map.Entry<String, Integer>> entries = goods.entrySet();
    private static List<String> list = new ArrayList<String>(entries.size());

    public Good() {  /*}

    static void addGoods(){*/
        goods.put("Milk", 10);
        goods.put("Bread", 25);
        goods.put("Meat", 100);
        goods.put("Chicken", 55);
        goods.put("Banana", 7);
        goods.put("Orange", 4);
        goods.put("Appel", 8);
        goods.put("Lemon", 9);
        goods.put("Water", 1);
        goods.put("Ice cream", 6);
        goods.put("Juici", 5);
        goods.put("Cake", 2);
        goods.put("Yogurt", 3);
        goods.put("Jam", 15);
        for (Map.Entry<String, Integer> entry : entries) {
            list.add(entry.getKey()+ " " + entry.getValue());
        }
    }
    static int goodsLength(){
        return goods.size();
    }

    static String getGoods(int number) {
        return  list.get(number); //entries.toArray().toString();
    }
}
