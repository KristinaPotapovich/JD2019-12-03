package by.it.kuzmichalex.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Goods {
    static private HashMap<String, Integer> mapOfGoods = new HashMap<>();
    static private List<String> listOfGoods = new ArrayList<>();
    static {
        //public Goods() {
        mapOfGoods.put("Bread", 125);
        mapOfGoods.put("Butter", 223);
        mapOfGoods.put("Sugar", 555);
        mapOfGoods.put("Juice", 97);
        mapOfGoods.put("Fish", 532);
        mapOfGoods.put("Meat", 456);
        mapOfGoods.put("Potato", 100);
        mapOfGoods.put("Tomato", 57);
        mapOfGoods.put("Pineapple", 177);
        mapOfGoods.put("Sausage", 312);
        mapOfGoods.put("Toast", 37);
        mapOfGoods.put("Blackberry", 723);
        mapOfGoods.put("Apple", 97);
        mapOfGoods.put("Mushroom", 275);
        mapOfGoods.put("Milk", 111);
        mapOfGoods.put("Chocolate", 233);
        mapOfGoods.put("Tortilla", 143);
        mapOfGoods.put("Honey", 774);
        mapOfGoods.put("Tea", 150);
        mapOfGoods.put("Coffee", 230);
        mapOfGoods.put("Water", 50);
        mapOfGoods.put("Chips", 75);
        mapOfGoods.put("Pizza", 335);
        mapOfGoods.put("Banana", 15);
        mapOfGoods.put("Chicken", 20);

        listOfGoods = new ArrayList<>(mapOfGoods.keySet());
    }
 //   }

  /*  static int getCount(){
        return mapOfGoods.size();
    }*/

    static String getSomeGood(){
        if(listOfGoods.size()==0) return "нет продуктов :(";
        return listOfGoods.get(TimeHelper.getRandom(0,listOfGoods.size()-1));
    }


    public static int getPrice(String nameOfGoods) {
        return mapOfGoods.get(nameOfGoods);
    }
}
