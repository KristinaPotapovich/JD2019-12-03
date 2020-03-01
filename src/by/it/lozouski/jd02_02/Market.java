package by.it.lozouski.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        System.out.println("------------------МАГАЗИН ОТКРЫЛСЯ.-------------------");
        GoodsInThisMarket.productListInThisMarket(); //заполнил магазин товарами
        List<Thread> threads = new ArrayList<>(1000);
        for (int id = 1; id <= 5; id++) {
            Cashier cashier = new Cashier(id);
            Thread cashierThread = new Thread(cashier);
            threads.add(cashierThread);
            cashierThread.start();
        }
        ControllerCashiers controllerCashiers = new ControllerCashiers();
        controllerCashiers.start();

        int buyerId = 1;
        while (Dispetcher.marketOpened()){
            int count = Help.randomGenerate(0,2);
            for (int i = 1; i <= count; i++) {
                if (Dispetcher.marketOpened()){
                    Buyer currentBuyer;
                    if (buyerId % 4 == 0) currentBuyer = new Buyer(buyerId++,true);
                    else currentBuyer = new Buyer(buyerId++,false);
                    threads.add(currentBuyer);
                    currentBuyer.start();
                }
            }
            Help.sleep(1000);
        }


        for (Thread thisThread : threads) {
            try {
                thisThread.join();
            } catch (InterruptedException e) {
                System.out.println("TEST ERROR2!");
            }
        }
        System.out.println("------------------МАГАЗИН ЗАКРЫЛСЯ.-------------------");
    }
}
