package by.it.borodachev.jd02_03;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.State.WAITING;

class Market {

    public static void main(String[] args) {
        System.out.println("---------- Market opened");
        Dispatcher.initQueue(new ArrayBlockingQueue<Buyer>(30));
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i <=1 ; i++) {
          Dispatcher.cashiers.add(new Cashier(i+1));
        }
        for (Cashier cashier : Dispatcher.cashiers) {
            cashier.setDaemon(true);
            Dispatcher.countCashier.incrementAndGet();
            fixedThreadPool.submit(cashier);
          cashier.start();
          }
         fixedThreadPool.shutdown();

        Helper.sleep(2000);
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
           Helper.sleep(1000);
        }

        for (Cashier cashier : Dispatcher.cashiers) {
           if (cashier.getState()==WAITING) {
                System.out.println(cashier+" будим");
                synchronized (cashier) {
                    cashier.notify();
                }
                try {
                    cashier.join();
                } catch (InterruptedException e) {
                    System.out.println("WOW2");
                }
            }
        }
        System.out.println("--------- Market closed");
    }

}
