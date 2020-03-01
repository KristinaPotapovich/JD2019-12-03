package by.it.borodachev.jd02_03;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.State.WAITING;

class BuyerB extends Buyer implements IUseBacket {
   HashMap<String,Double> good=new HashMap<>(4);
   public BuyerB(int number) {
        super(number);
    }
    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        add2Queue();
        goOut();
    }

   @Override
    public void chooseGoods() {
       try {
           Dispatcher.buyersinMaktetSize.acquire();
       } catch (InterruptedException e) {}

       System.out.println(this+" Взял корзину");
        int countGoods = Helper.random(1,4);
        System.out.println(this + " заполняет корзину");
        for (int i = 1; i <= countGoods; i++) {
            int timeout = Helper.random(500, 2000);
            Helper.sleep(timeout);
            putGoodsToBacket();
        }
        System.out.println(this + "Закончил выбор товара");
    }


    @Override
    public void takeBacket()  {
        System.out.println(this+"Взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
      String randomGoodName = "good "+ Helper.random(0, Goods.goods.size()-1);
      Double goodPrice = Goods.goods.get(randomGoodName);
      good.put(randomGoodName, goodPrice);
      System.out.println(this+"Положил товар к корзину "+randomGoodName+" Цена "+goodPrice);
    }
    @Override
    public void add2Queue() {
        System.out.println(this + "Ожидание в очереди");
        try {
            Dispatcher.buyer2Cash.put(this);
        } catch (InterruptedException e) {
        }

        // если кто-то спит разбудим
        int needcashier = Dispatcher.buyer2Cash.size() / 5 + 1;
        if ((needcashier > Dispatcher.countCashier.get()) && (Dispatcher.countCashier.get() < 5)) {
            for (Cashier cashier : Dispatcher.cashiers) {
                if (cashier.getState() == WAITING) {
                    synchronized (cashier) {
                        cashier.notify();
                    }
                    break;
                }
            }
        }


        synchronized (this) {
            while (this.waitNextOperation.get()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println(" Error:" + this + e.toString());
                }
            }
        }
    }
    @Override
    public void pay(int numCash) {
        Double sumCheck=Double.valueOf(0);
        for (Map.Entry<String, Double> money : good.entrySet()) {
            sumCheck=sumCheck+ money.getValue();
        }
        System.out.println(this+" Сумма чека= "+String.format("%.2f", sumCheck));
        Dispatcher.buyersinMaktetSize.release();
        System.out.println(this+" Вернул корзину");
        waitNextOperation.set(false);
        return ;
    }
}
