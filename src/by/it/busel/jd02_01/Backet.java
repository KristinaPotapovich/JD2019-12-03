package by.it.busel.jd02_01;

import java.util.*;

class Backet {
    private static Map<String, Double> goodsNomenclature = new HashMap<>();

    static {
        goodsNomenclature.put("Bread", 0.99);
        goodsNomenclature.put("Vegetables", 3.74);
        goodsNomenclature.put("Milk", 1.59);
        goodsNomenclature.put("Poultry", 12.69);
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
}
