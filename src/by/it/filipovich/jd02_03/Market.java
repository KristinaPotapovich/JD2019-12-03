package by.it.filipovich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Market {

    public static void main(String[] args) {
        System.out.println("Market has opened!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        int number=0;

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            fixedThreadPool.execute(cashier);
        }
        fixedThreadPool.shutdown();

        while (Dispatcher.marketIsOpened()) {
            int count = Helper.random(0, 2);
            for (int i = 1; i <= count; i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(++number);
                    buyer.start();
                }
            }
            Helper.sleep(1000);
        }

        try {
            while (!fixedThreadPool.awaitTermination(1000, TimeUnit.MILLISECONDS));
            System.out.println("Market closed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
