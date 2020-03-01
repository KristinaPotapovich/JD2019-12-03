package by.it.kuzmichalex.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        Goods goods = new Goods();
        PseudoGraph graph = new PseudoGraph();
        List<Buyer> listBuyers = new ArrayList<>(1000);

        System.out.println("============================== MARKET OPENED ==============");
        int nBuyerNameCounter = 0;
        //Магазин работает 120 секунд. Хорошо, что покупатели проворные, как в чёрную пятницу!
        for (int nSeconds = 0; nSeconds < 120; nSeconds++) {
            int buyersNeed = Dispatcher.getBuyersNeed(nSeconds);
            int newComers = buyersNeed - Dispatcher.nCountOfBuyers;
            graph.add(Dispatcher.nCountOfBuyers);
            System.out.println("======= MARKET Works:" + nSeconds + "s. " +
                    ";   Byers:" + Dispatcher.nCountOfBuyers +
                    ";   Buyers need:" + buyersNeed +
                    ";   Newcomers:" + newComers);
            while (newComers-- > 0) {
                Buyer buyer = new Buyer(nBuyerNameCounter++);
                listBuyers.add(buyer);
                buyer.start();
            }
            TimeHelper.sleep(TimeHelper.getRandom(1000, 1000)); //Запускаем раз в секунду. Нуу примерно.
        }
        System.out.println("=========================== вход в MARKET закрыт==============================");
        System.out.println("Покупателей внутри осталось примерно: " + Dispatcher.nCountOfBuyers);

        //заджойнимся ко всем берлагам.
        for (Buyer buyerFromList : listBuyers) {
            try {
                buyerFromList.join();
            } catch (InterruptedException e) {
                System.out.println("Cannot join buyer :(");
            }
        }
        System.out.println("============================ MARKET точно пуст (join сработал) ================");
        System.out.println("А сейчас, если не сломается, нарисуем график посещения гастронома==============");
        System.out.println(graph);
        System.out.println("Эти точечки на самом деле гистрограмма распределения покупателей по времени :)");
        System.out.println("============================ Покупателей залипло в диспетчере: " + Dispatcher.nCountOfBuyers);
        System.out.println("Фактор ускорения просмотра TimeHelper.SUPER_SPEED: " + TimeHelper.getSuperSpeed());
        System.out.println("Фактор замедления пенсионера TimeHelper.SLOW_SPEED: " + TimeHelper.getSlowSpeed());

    }
}
