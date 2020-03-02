package by.it.rumiantcau.jd02_02;

import java.util.ArrayList;
import java.util.Arrays;

public class Good {
    static final ArrayList<String> goodsRange = new ArrayList<>(Arrays.asList("хлеб за 100", "молоко за 200",
            "сало за 300", "яблоки за 400", "огурцы за 600", "шоколад за 500", "апельсины за 299", "кефир за 150"));
    static int goodsRangeCount = goodsRange.size() - 1;
    static int timeout= Helper.random(500,2000);
    static String putGoodToBacket(Buyer buyer){
            String s = Good.goodsRange.get(Helper.random(0, goodsRangeCount));
            System.out.print(buyer + "положил в корзину товар " + s + "\n");
            Helper.sleep(timeout);
            return s;
    }



}
