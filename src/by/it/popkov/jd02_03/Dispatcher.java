package by.it.popkov.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {


    final static int SPEED_BOOST = 100;
    final int cashierMax = 5;
    final int plan = 100;

    private final AtomicInteger buyerOnline = new AtomicInteger(0);
    private final AtomicInteger dayBuyerNum = new AtomicInteger(0);
    private final AtomicInteger dayProfit = new AtomicInteger(0);

    private final Map<String, Integer> goodsMap = new HashMap<>();

    private final AtomicInteger onlineCashier = new AtomicInteger(cashierMax);

    public Map<String, Integer> getGoodsMap() {
        return goodsMap;
    }

    public int getDayProfit() {
        return dayProfit.get();
    }

    public void plusDayProfit(Integer plus) {
        dayProfit.addAndGet(plus);
    }

    public void writeGoodsMap() {
        goodsMap.put("water", 1);
        goodsMap.put("bread", 2);
        goodsMap.put("apples", 3);
        goodsMap.put("milk", 4);
        goodsMap.put("eggs", 5);
        goodsMap.put("cake", 6);
        goodsMap.put("meat", 7);
    }

    public boolean planIsNotCompleted() {
        return dayBuyerNum.get() < plan;
    }

    public boolean marketIsClosed() {
        return dayBuyerNum.get() == plan && buyerOnline.get() == 0;
    }

    public void buyerComeIn() {
        buyerOnline.getAndIncrement();
        dayBuyerNum.getAndIncrement();
    }

    public int getBuyerOnline() {
        return buyerOnline.get();
    }

    public void buyerWentOut() {
        buyerOnline.getAndDecrement();
    }

    public void cashierClosed() {
        onlineCashier.getAndDecrement();
    }

    public void cashierOpened() {
        onlineCashier.getAndIncrement();
    }

    public int getOnlineCashier() {
        return onlineCashier.get();
    }
}
