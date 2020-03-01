package by.it.plugatar.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {
    static Map<String, Double> priceList = new HashMap<>();

    static void loadPriceList() {
        priceList.put("батон", 1.0);
        priceList.put("кефир", 1.5);
        priceList.put("яйца", 2.1);
        priceList.put("сыр", 9.0);
        priceList.put("свинина", 8.1);
        priceList.put("сосиски", 7.1);
        priceList.put("помидоры", 4.5);
        priceList.put("огурцы", 7.5);
        priceList.put("паштет", 3.2);
        priceList.put("чай", 3.1);
        priceList.put("масло", 2.2);
    }
    //размера списка товаров магазина
    int getPriceListSize() {
        return priceList.size();
    }

    //цены товара из списка товаров магазина
    double getPrice(String goods) {
        if (priceList.containsKey(goods)){
           // System.out.printf("round(priceList.get(goods)*10/10.0 : %20d\n",Math.round(priceList.get(goods)*10/10.0) );
            return (int) Math.round(priceList.get(goods)*10/10.0);//Math.round(priceList.get(goods)*10)/10.0
        } else
            return 0.0;
    }
}
