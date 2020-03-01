package by.it.busel.jd02_03;

import java.util.*;

class Backet {
    private static Map<String, Double> goodsNomenclature = new HashMap<>();

    static {
        goodsNomenclature.put("Bread", 0.99);
        goodsNomenclature.put("Vegetables", 3.74);
        goodsNomenclature.put("Milk", 1.59);
        goodsNomenclature.put("Poultry", 12.69);
        goodsNomenclature.put("Fish", 17.99);
        goodsNomenclature.put("Chocolate", 2.29);
        goodsNomenclature.put("Protein", 23.99);
        goodsNomenclature.put("Water", 0.99);
        goodsNomenclature.put("Juice", 3.75);
        goodsNomenclature.put("Coffee", 6.79);
        goodsNomenclature.put("Tea", 3.09);
        goodsNomenclature.put("Toothpaste", 5.49);
        goodsNomenclature.put("Pen", 3.00);
    }


    private Map<String, Double> personalGoods = new HashMap<>();

    private Map.Entry<String, Double> lastChosenItem;

    Map.Entry<String, Double> chooseAnItemOfGoods() {
        List<String> keys = new ArrayList<>(goodsNomenclature.keySet());
        Collections.shuffle(keys);
        int randomKey = Helper.getRandomIntValue(0, keys.size() - 1);
        String randomItemName = keys.get(randomKey);
        Double randomItemPrice = goodsNomenclature.get(randomItemName);
        lastChosenItem = new AbstractMap.SimpleEntry<>
                (randomItemName, randomItemPrice);
        return lastChosenItem;
    }

    Map.Entry<String, Double> putChosenItem() {
        personalGoods.merge(lastChosenItem.getKey(), lastChosenItem.getValue(), Double::sum);
        return lastChosenItem;
    }

    Map<String, Double> getPersonalGoods() {
        return personalGoods;
    }

    void emptyBacket() {
        personalGoods = new HashMap<>();
        lastChosenItem = null;
    }
}
