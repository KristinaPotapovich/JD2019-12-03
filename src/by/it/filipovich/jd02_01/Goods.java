package by.it.filipovich.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {
    private static Map<String,Double> listOfGoods;
    static {
        listOfGoods = new HashMap<>();
        listOfGoods.put("Sugar", 2.3);
        listOfGoods.put("Bred", 1.5);
        listOfGoods.put("Apple", 3.8);
        listOfGoods.put("Milk", 1.2);
        listOfGoods.put("Tea", 3.2);
        listOfGoods.put("Coffee", 6.6);
        listOfGoods.put("Sweets", 11.7);
        listOfGoods.put("Eggs", 2.26);
        listOfGoods.put("Groats", 2.35);
        listOfGoods.put("Vegetables", 4.92);
    }


    static Map<String, Double> getListOfGoods() {
        return listOfGoods;
    }
}
