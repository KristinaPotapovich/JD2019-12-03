package by.it.lozouski.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        System.out.println("------------------МАГАЗИН ОТКРЫЛСЯ.-------------------");
        GoodsInThisMarket.productListInThisMarket(); //заполнил магазин товарами
        List<Buyer> buyersInMarket = new ArrayList<>(1000);
        int buyerId = 1;

        for (int minutes = 1; minutes <= 2; minutes++) {
            for (int sec = 0; sec < 30; sec++) {
                Buyer currentBuyer;
                int needCountBuyers = sec + 10;
                for (int personNum = 1; personNum <= needCountBuyers; personNum++) {
                    if (buyerId % 4 == 0) currentBuyer = new Buyer(buyerId++, true);
                    else currentBuyer = new Buyer(buyerId++, false);
                    buyersInMarket.add(currentBuyer);
                    currentBuyer.start();
                }
                Help.sleep(1000);
            }
            for (int sec = 30; sec <= 60; sec++) {
                Buyer currentBuyer;
                int needCountBuyers = 40 + (30 - sec);
                if(Dispetcher.buyerCounter > needCountBuyers) {
                    Help.sleep(1000);
                    continue;
                }
                for (int personNum = 1; personNum <= needCountBuyers; personNum++) {
                    if (buyerId % 4 != 0) currentBuyer = new Buyer(buyerId++, false);
                    else currentBuyer = new Buyer(buyerId++, true);
                    buyersInMarket.add(currentBuyer);
                    currentBuyer.start();
                }
                Help.sleep(1000);
            }
        }

        for (Buyer thisBuyer : buyersInMarket) {
            try {
                thisBuyer.join();
            } catch (InterruptedException e) {
                System.out.println("TEST ERROR2!");
            }
        }
        System.out.println("------------------МАГАЗИН ЗАКРЫЛСЯ.-------------------");
    }
}
