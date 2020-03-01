package by.it.borodachev.jd02_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.State.WAITING;

class MarketB {

    public static void main(String[] args) {
        System.out.println("---------- Market opened");
        Dispatcher.initQueue(new ArrayBlockingQueue<BuyerB>(30));
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i <=1 ; i++) {
            Dispatcher.cashiers.add(new Cashier(i+1));
        }
        for (Cashier cashier : Dispatcher.cashiers) {
            cashier.setDaemon(true);
            Dispatcher.countCashier.incrementAndGet();
            fixedThreadPool.execute(cashier);
       }
        fixedThreadPool.shutdown();

        int number=0;
        while (Dispatcher.marketOpened()) {
            int count= Helper.random(0,2);
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        while (!Dispatcher.marketClosed()) {
            Helper.sleep(100);
        }

        System.out.println("--------- Market closed");
    }

}
