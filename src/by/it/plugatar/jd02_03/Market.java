package by.it.plugatar.jd02_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    private static LinkedList<Integer> numberOfBuyers = new LinkedList<>();
    private static LinkedList<Integer> enteredBuyers = new LinkedList<>();
    private static List<Buyer> listOfBuyers = new ArrayList<>();
    private static int number = 1;

    public static void main(String[] args){
        Goods.loadPriceList();
        workingMarket();
        marketStatistics();
    }
    private static void marketStatistics() {
        System.out.println("Buyers in Market Statistics:");
        System.out.printf("Total buyers: %d, retired buyers: %d\n", Dispatcher.totalBuyersCount, Dispatcher.totalRetiredCount);
        System.out.println("-------------------------------------------------------------------------------------");
        int n = numberOfBuyers.size();
        System.out.print("entry № | number of buyers in the market | entered buyers | total number of buyers (in the market + entered) |\n");
        for (int i = 1; i <= n; i++) {
            int n1, n2;
            Integer nu1 = numberOfBuyers.pollLast();
            Integer nu2 = enteredBuyers.pollLast();
            if (nu1 != null) n1 = nu1; else throw new NullPointerException();
            if (nu2 != null) n2 = nu2; else throw new NullPointerException();
            System.out.printf("%6d   |%28d    |%12d    |%46d    |\n", i, nu1, nu2, n1 + n2);
        }
    }
    private static void enteringBuyers(int max_entries, int i) {
        int sec = i % 60;
        int num = -1;
        if (sec <= 30) {
            if (Dispatcher.buyersCount < 10 + sec) {
                num = (sec + 10 - Dispatcher.buyersCount) > max_entries ? max_entries :
                        (RandomHelper.random(sec + 10 - Dispatcher.buyersCount, max_entries));
            }
        } else {
            if (Dispatcher.buyersCount > 40 + 30 - sec)
                num = 0;
        }
        if (num == -1) num = RandomHelper.random(0, max_entries);
        numberOfBuyers.offerFirst(Dispatcher.buyersCount);
        enteredBuyers.offerFirst(num);
        for (int j = 0; j < num; j++) {
            Buyer buyer = new Buyer(number++);
            listOfBuyers.add(buyer);
            buyer.start();
        }
        RandomHelper.sleep(1000);
    }


    private static void workingMarket(){
        System.out.println("-----------Market opened");
        List<Buyer> buyers = new ArrayList<>(1000);
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(5);
        for (int time = 0; time <= 120; time++) {
            int countBuyer= RandomHelper.random(0,2);
            Cashier cashier = new Cashier(i);
            fixedThreadPool.execute(cashier);
        }
        fixedThreadPool.shutdown();

        for (int i = 1; i < 120; i++) {
            Buyer buyer = new Buyer(i);
            buyers.add(buyer);
            buyer.start();
        }
        for (Buyer byuer:buyers){
            try{
                byuer.join();
            }
            catch (InterruptedException e){
                System.out.println("Uncorrected join");
            }
        }
        System.out.println("-----------Market closed");
    }
    //while (fixedThreadPool.awaitTermination)
}
