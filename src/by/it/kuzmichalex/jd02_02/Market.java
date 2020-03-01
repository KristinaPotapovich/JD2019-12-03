package by.it.kuzmichalex.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        Goods goods = new Goods();
       PseudoGraph graph = new PseudoGraph();
        CashierManager manager = new CashierManager();
        BuyerQueue queue = new BuyerQueue(manager);
        List<Buyer> listBuyers = new ArrayList<>(100);

       // System.out.println("=====MARKET OPENED=====");
        int nSeconds = 0;
        int buyersCreated = 0;
        while (buyersCreated != Dispatcher.PLAN) {
            int newComers = Dispatcher.getBuyersNeed(nSeconds) - Dispatcher.getCountBuyersInside();
            if (newComers > 0) {
                if ((buyersCreated + newComers) > (Dispatcher.PLAN-1)) newComers = ((Dispatcher.PLAN) - buyersCreated);
                //Запуск берлаг
                while (newComers > 0) {
                    Buyer buyer = new Buyer(buyersCreated++);
                    listBuyers.add(buyer);
                    buyer.start();
                    newComers--;
                }
            }
            graph.add(Dispatcher.getCountBuyersInside());
            TimeHelper.sleep(TimeHelper.getRandom(1000, 1000));
            nSeconds++;
        }

    //    System.out.println("====NO ENTER=====");
        manager.stopManaging();

        System.out.println("======MARKET CLOSED======");
        System.out.println("Фактор ускорения просмотра TimeHelper.SUPER_SPEED: " + TimeHelper.getSuperSpeed());
        System.out.println("Фактор замедления пенсионера TimeHelper.SLOW_SPEED: " + TimeHelper.getSlowSpeed());
        System.out.println("Покупатели по времени: ");
        System.out.println(graph);


    }
}
