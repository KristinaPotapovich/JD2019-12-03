package by.it.kuzmichalex.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Goods {
    static private HashMap<String, Double> mapOfGoods = new HashMap<>();
    static private List<String> listOfGoods = new ArrayList<>();
    static {
        mapOfGoods.put("Bread",1.25);
        mapOfGoods.put("Butter",2.23);
        mapOfGoods.put("Sugar",5.55);
        mapOfGoods.put("Juice",0.97);
        mapOfGoods.put("Fish",5.32);
        mapOfGoods.put("Meat",4.56);
        mapOfGoods.put("Potato",1.00);
        mapOfGoods.put("Tomato",0.57);
        mapOfGoods.put("Pineapple",1.77);
        mapOfGoods.put("Sausage",3.12);
        mapOfGoods.put("Toast",0.37);
        mapOfGoods.put("Blackberry",7.23);
        mapOfGoods.put("Apple",0.97);
        mapOfGoods.put("Mushroom",2.75);
        mapOfGoods.put("Milk",1.11);
        mapOfGoods.put("Chocolate",2.33);
        mapOfGoods.put("Tortilla",1.43);
        mapOfGoods.put("Honey",7.74);
        mapOfGoods.put("Tea",1.50);
        mapOfGoods.put("Coffee",2.30);
        mapOfGoods.put("Water",0.50);
        mapOfGoods.put("Chips",0.75);
        mapOfGoods.put("Pizza",3.35);
        mapOfGoods.put("Banana",1.5);
        mapOfGoods.put("Chicken",2.0);

        listOfGoods = new ArrayList<String>(mapOfGoods.keySet());
    }

  /*  static int getCount(){
        return mapOfGoods.size();
    }*/

    static String getSomeGood(){
        if(listOfGoods.size()==0) return "нет продуктов :(";
        return listOfGoods.get(TimeHelper.getRandom(0,listOfGoods.size()-1));
    }


    public static double getPrice(String nameOfGoods) {
        return mapOfGoods.get(nameOfGoods);
    }
}
