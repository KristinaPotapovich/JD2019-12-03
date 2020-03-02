package by.it.shulga.jd01.jd02_01;

import java.util.HashMap;

class Dispatcher {

    static final int K_SPEED=10000;
    static int countBuyer=0;
    static  HashMap<String,Double> goods=new HashMap<>();
    static {
        for (int i = 0; i <100; i++) {
            goods.put("good "+i, Helper.randomPrice(100)) ;
        }
    }

}
