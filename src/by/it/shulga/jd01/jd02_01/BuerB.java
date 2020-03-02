package by.it.shulga.jd01.jd02_01;

import java.util.HashMap;

class BuyerB extends Buyer implements IUseBacket{
    HashMap<String,Double> good=new HashMap<>(4);
    public BuyerB(int number) {
        super(number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    @Override
    public void chooseGoods() {
        int countGoods = Helper.random(1,4);
        System.out.println(this + "started choosing by goods");
        for (int i = 1; i <= countGoods; i++) {
            int timeout = Helper.random(500, 2000);
            Helper.sleep(timeout);
            putGoodsToBacket();
        }
        System.out.println(this + "finshed choosing by goods");
    }


    @Override
    public void takeBacket()  {
        System.out.println(this+"take Backet");
    }

    @Override
    public void putGoodsToBacket() {
        String randomGoodName = "good "+Helper.random(0,Dispatcher.goods.size()-1);
        Double goodPrice = Dispatcher.goods.get(randomGoodName);
        good.put(randomGoodName, goodPrice);
        System.out.println(this+"put Goods To Backet "+randomGoodName+" Price "+goodPrice);
    }
}