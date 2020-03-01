package by.it.filipovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {
        System.out.println("Market has opened!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Thread> threads = new ArrayList<>(1000);
        int number=0;

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Dispatcher.marketIsOpened()) {
            int count = Helper.random(0, 2);
            for (int i = 1; i <= count; i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(++number);
                    threads.add(buyer);
                    buyer.start();
                }
            }
            Helper.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOPS");
            }
        }
        System.out.println("Market closed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
