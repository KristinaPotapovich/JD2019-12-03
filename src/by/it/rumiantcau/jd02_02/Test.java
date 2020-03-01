package by.it.rumiantcau.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        double sum = 0;
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "  кефир за 150, молоко за 200, хлеб за 100, сало за 300 ,");
        String[] goodsString = map.get(1).split(",");

        for (String s : goodsString) {
            System.out.println("qqq "+Double.valueOf(s.replaceAll("[A-Za-zА-Яа-я]", "").
                    replace(" ", "")));
        }

        /*
        for (int i = 1; i < goodsString.length; i++) {
            sum+=Double.parseDouble(goodsString[i].replaceAll("[A-Za-zА-Яа-я]", "").
                    replace("  ", ""));
        }

        for (String s : goodsString) {
            sum+=Double.parseDouble(s.replaceAll("[A-Za-zА-Яа-я]", "").
                    replace("  ", ""));
        }
        System.out.println("summa" + sum);;




        System.out.println(Basket.basket);*/


    }

}
