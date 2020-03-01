package by.it.kuzmichalex.jd02_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Market {
    public static void main(String[] args) {
        Semaphore inHallSemaphore = new Semaphore(Dispatcher.MAX_BUYERS_IN_HALL);
        Semaphore bucketSemaphore = new Semaphore(Dispatcher.MAX_BUCKETS);

        Goods goods = new Goods();
        PseudoGraph graph = new PseudoGraph();
        CashierManager manager = new CashierManager();
        BuyerQueue queue = new BuyerQueue(manager);
        List<Buyer> listBuyers = new ArrayList<>(100);

        // System.out.println("=====MARKET OPENED=====");
        int nSeconds = 0;
        while (Dispatcher.isPlanNotExecuted()) {
            int newComers = Dispatcher.getBuyersNeed(nSeconds) - Dispatcher.getBuyersInMarket();
            if (newComers > 0) {
                if ((Dispatcher.getBuyersCreated() + newComers) > (Dispatcher.PLAN - 1))
                    newComers = ((Dispatcher.PLAN) - Dispatcher.getBuyersCreated());
                //Запуск берлаг
                // System.out.println("!!!!!!!!!!!!! newcopmers " + newComers);
                while (newComers > 0) {
                    Buyer buyer = new Buyer(Dispatcher.incBuyersCreated(), inHallSemaphore, bucketSemaphore);
                    listBuyers.add(buyer);
                    buyer.start();
                    newComers--;
                }
            }
            graph.add(Dispatcher.getBuyersInMarket(), Dispatcher.getBuyersCreated() >= 100);
            TimeHelper.sleep(TimeHelper.getRandom(1000, 1000));
            nSeconds++;
        }

        manager.stopManaging();

        System.out.println("======MARKET CLOSED======");
        System.out.println(graph);
        System.out.println("Покупатели в магазине по времени. Все, кроме без скорзинных ");
        System.out.println("Серый - это после прекращения создания покупателей ");
        System.out.println("Фактор ускорения просмотра TimeHelper.SUPER_SPEED: " + TimeHelper.getSuperSpeed());
        System.out.println("Фактор замедления пенсионера TimeHelper.SLOW_SPEED: " + TimeHelper.getSlowSpeed());
        System.out.println("Все константы по очередям, корзинам и тд в Dispatcher");



    }
}
