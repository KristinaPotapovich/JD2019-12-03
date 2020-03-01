package by.it.borodachev.jd02_02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Market {

    public static void main(String[] args) {
        System.out.println("---------- Market opened");
        List <Buyer> buyers=new ArrayList<>(1000);

        Comparator<Buyer> comp = new Comparator<Buyer>() {
            public int compare(Buyer o1, Buyer o2) {
                return 0;
            }
        };
        Dispatcher.initQueue(comp);

        for (int i = 0; i <=1 ; i++) {
          Dispatcher.cashiers.add(new Cashier(i+1));
        }
        for (Cashier cashier : Dispatcher.cashiers) {
            cashier.setDaemon(true);
            Dispatcher.cashierStart();
            cashier.start();
        }

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
        while (Dispatcher.buyerCount()!=0) {
           Helper.sleep(100);
        }
        for (Buyer buyer : buyers) {
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    System.out.println("WOW2");
                }
            }

        System.out.println("--------- Market closed");
    }

}
