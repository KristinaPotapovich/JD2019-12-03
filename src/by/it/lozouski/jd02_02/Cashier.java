package by.it.lozouski.jd02_02;

import java.util.Arrays;

class Cashier implements Runnable {
    static final Object monitorCashier = new Object();

    static volatile int pieceCashiers = 5;

    private String name;

    public Cashier(int idCashier) {
        name = "КАССИР №" + idCashier + " ";
    }


    @Override
    public void run() {
        System.out.println(this + "ОТКРЫЛСЯ!");
        while (!Dispetcher.marketClosed()) {
            Buyer buyer = QueueBuyer.extractBuyerFromQueue();
            if (buyer != null) {
                System.out.println(this + "НАЧАЛ ОБСЛУЖИВАНИЕ " + buyer);
                Help.sleep(Help.randomGenerate(2000, 5000));
                System.out.println(this + "Список товаров: " + buyer.toString()
                        + "--- " + Arrays.toString(buyer.getBacketWithBoughtGoods().keySet().toArray()));
                System.out.println(this + buyer.toString() + "-- Сумма чека = " + buyer.getAmountOfGoods() + "руб.");
                System.out.println(this + "ЗАКОНЧИЛ ОБСЛУЖИВАНИЕ " + buyer);
                synchronized (buyer){
                    buyer.notify();
                }
            } else {
                synchronized (monitorCashier) {
                    try {
                        pieceCashiers--;
                        monitorCashier.wait();
                        pieceCashiers++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(this + "ЗАКРЫЛСЯ!");
    }

    @Override
    public String toString() {
        return name;
    }
}
