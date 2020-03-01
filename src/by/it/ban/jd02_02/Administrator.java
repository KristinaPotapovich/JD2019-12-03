package by.it.ban.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Administrator implements Runnable{

    private String name;

    public Administrator() {
        name="Администратор ";
    }

    @Override
    public void run() {
        List<Thread> threads = new ArrayList<>(5);
        System.out.println(this+"пришел на работу");
        Helper.sleep(1000);
        while (!Dispatcher.marketClosed()) {
            int length = QueueBuyer.getLength()+QueuePensioneer.getLength();
            int openedCashiers=Dispatcher.getCashCount();
            if (openedCashiers < length / 5 && openedCashiers < Dispatcher.ALL_CASHIERS) {
                Cashier cashier = new Cashier(++openedCashiers);
                Thread thread = new Thread(cashier);
                threads.add(thread);
                thread.start();
            } else if (openedCashiers > length / 5) {
                threads.get(--openedCashiers).interrupt();
            }else{
            Helper.sleep(1);
            }
        }
        for (Thread thread1 : threads) {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+"закрывает магазин");
    }

    @Override
    public String toString() {
        return name;
    }
}
