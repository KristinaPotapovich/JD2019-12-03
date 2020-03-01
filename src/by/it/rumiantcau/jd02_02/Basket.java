package by.it.rumiantcau.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    //в этой хашмапе будет хранится товары, купленые покупателем, где Кей - номер покупатиля, Валью - стринг с
    //купленными товарами
    static Map<Buyer, String> basket = new HashMap<>();
    static double sumBasket (Buyer buyerID){
        double sum = 0;
        String[] goodsString = basket.get(buyerID).split(",");
        for (int i = 0; i < goodsString.length; i++) {
            sum+=Double.valueOf(goodsString[i].replaceAll("[A-Za-zА-Яа-я]", "").
                    replace("  ", ""));
        }

        return sum;
    }







}
