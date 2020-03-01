package by.it.rumiantcau.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        System.out.println("####Открытие магазина####");
        List<Thread> threads = new ArrayList<>(1000);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        int number = 0;
        while (Dispatcher.marketOpened()) {
            int count = Helper.random(0, 2);
            for (int i = 1; i <= count; i++) {
                if (Dispatcher.marketOpened()) {
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
                System.out.println("WOW2");
            }
        }

 /*
       public static List<Buyer> buyers=new ArrayList<>(1000);
       int number=0;

        for (int time = 0; time <= 120; time++) {
            int count= Helper.random(0,2);
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("Неизвестная ошибка с покупателями");
            }
        }

*/
        System.out.println("####Закрытие магазина####");


 }


}
