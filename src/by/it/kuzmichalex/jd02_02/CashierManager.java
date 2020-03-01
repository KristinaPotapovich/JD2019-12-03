package by.it.kuzmichalex.jd02_02;

import java.util.*;

public class CashierManager {
    //private static Map<Cashier, Thread> mapCashiers = new HashMap<>();
    private static List<Cashier> listCashiers = new ArrayList<>();
    private static List<Thread> listThreads = new ArrayList<>();

    CashierManager() {
        //Менеджер мейкинг дэйли аджайл митинг
        for (int i = 0; i < Dispatcher.MAX_CASHIERS; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            listCashiers.add(cashier);
            listThreads.add(thread);
            //mapCashiers.put(cashier, thread);
            thread.start();
        }
    }

    public static String getCashierState(int x) {
        if (x > listThreads.size()) return " void ";
        return listThreads.get(x).getState().toString();
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
            else {
                if (listThreads.get(idx).getState() == Thread.State.WAITING) listCashiers.get(idx).goNotify();
            }
        }
       /* Iterator<Map.Entry<Cashier, Thread>> iterator = mapCashiers.entrySet().iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            Map.Entry<Cashier, Thread> next = iterator.next();
            if (idx > cashiersNeed) next.getKey().goWait("Manager");
            else if (next.getValue().getState() == Thread.State.WAITING) next.getKey().goNotify();
            idx++;
        }*/
    }

    /**
     * Получить количество работающих кассиров.
     * Работаючщи считается любой не WAITING и не TERMINATED
     */
    static int getCountCashiersWorks() {
        int result = 0;
        for (Thread listThread : listThreads) {
            Thread.State state = listThread.getState();
            if (state != Thread.State.WAITING && state != Thread.State.TERMINATED) result++;
        }
        return result;
    }

    /**
     * Подъём всех кассиров для завершения кассы
     */
    void stopManaging() {
        for (int idx = 0; idx < Dispatcher.MAX_CASHIERS; idx++) {
            //Всех кассиров вернём из курилок, чтобы завершили кассы
            if (listThreads.get(idx).getState() == Thread.State.WAITING) listCashiers.get(idx).goNotify();
            //присоединимся ко всем процессам и дождёся их завершения
            try {
                listThreads.get(idx).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Logger.printAndFlush();
        listThreads.clear();
        listCashiers.clear();

      /*  Iterator<Map.Entry<Cashier, Thread>> iterator = mapCashiers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Cashier, Thread> next = iterator.next();
            if (next.getValue().getState() == Thread.State.WAITING) next.getKey().goNotify();
            //Всех кассиров вернули из курилок, чтобы завершили кассы
            //присоединимся ко всем процессам и дождёся их завершения
            try {
                next.getValue().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //   mapCashiers.clear();
        // Logger.addToLog(" ", 0);
        //System.out.println("Manager Done");
    }
}
