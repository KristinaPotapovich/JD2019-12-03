package by.it.kuzmichalex.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CashierManager {
    private static List<Cashier> listCashiers = new ArrayList<>();
    private static ExecutorService cashierThreadPool;

    CashierManager() {
        //Менеджер мейкинг дэйли аджайл митинг
        cashierThreadPool=Executors.newFixedThreadPool(Dispatcher.MAX_CASHIERS);

        for (int i = 0; i < Dispatcher.MAX_CASHIERS; i++) {
            Cashier cashier = new Cashier(i);
            listCashiers.add(cashier);
            cashierThreadPool.execute(cashier);
        }
        cashierThreadPool.shutdown();
        System.out.println("-============================================================================");
    }

    /**
     * Управление всем этим колхозом.
     * Осуществляется из очереди при добавлении/доставании Buyer'a
     *
     * @param reason причина вызова менеджера (любое изменение очереди)
     */
    void doManaging(String reason) {
        int cashiersNeed = (BuyerQueue.getQueueSize() / 5);
        for (int idx = 0; idx < Dispatcher.MAX_CASHIERS; idx++) {
            if (idx > cashiersNeed) listCashiers.get(idx).goWait("Manager");
            else listCashiers.get(idx).goNotify();
        }
    }

    public static String getCashierState(int x) {
       return listCashiers.get(x).getState();
    }

    /**
     * Получить количество работающих кассиров.
     * Работаючщи считается любой не WAITING и не TERMINATED
     */
    static int getCountCashiersWorks() {
        int result = 0;
        for (Cashier listCashier : listCashiers) {
            if(!listCashier.isStopped())result++;
        }
        return result;
    }

    /**
     * Подъём всех кассиров для завершения кассы
     */
    void stopManaging() {
        for (Cashier listCashier : listCashiers) {
            listCashier.goNotify();
        }
        //cashierThreadPool.shutdown();
        try {
            cashierThreadPool.awaitTermination(10, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.printAndFlush();
        listCashiers.clear();
    }
}
