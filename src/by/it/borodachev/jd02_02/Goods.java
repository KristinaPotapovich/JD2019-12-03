package by.it.borodachev.jd02_02;

import java.util.HashMap;

class Goods {
    static HashMap<String,Double> goods=new HashMap<>();
    static {
        for (int i = 0; i <100; i++) {
            goods.put("good "+i, Helper.randomPrice(100)) ;
        }
    }
}
