package by.it.busel.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher extends Thread {
    static final int SPEED_COEFFICIENT = 100;
    private static final int MAX_DAILY_BUYERS_NUMBER = 100;
    private static final int CASHIER_COUNTERS_AVAILABLE = 5;
    static final int NUMBER_OF_BACKETS = 50;

    private static AtomicInteger counterOfBuyersServedToday = new AtomicInteger(0);
    private static AtomicInteger counterOfBuyersInside = new AtomicInteger(0);

    static boolean shopDoorsAreStillOpened() {
        return counterOfBuyersServedToday.get() < MAX_DAILY_BUYERS_NUMBER;
    }

    static boolean shopCanBeClosed() {
        return counterOfBuyersServedToday.get() == MAX_DAILY_BUYERS_NUMBER
                && counterOfBuyersInside.get() == 0;
    }

    static int getBuyersNumberInside() {
        return counterOfBuyersInside.get();
    }

    static void buyerEntered() {
        counterOfBuyersServedToday.getAndIncrement();
        counterOfBuyersInside.getAndIncrement();
    }

    static void buyerLeft() {
        counterOfBuyersInside.getAndDecrement();
    }

    private static AtomicInteger counterOfOpenedCashiers = new AtomicInteger(0);

    private static final Object cashiersMonitor = new Object();

    private static boolean needsCashierToOpenTheCounter() {
//        int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
        switch (counterOfOpenedCashiers.get()) {
            case 0:
                return SoleQueue.getBuyersQuantity() > 0;
            case 1:
                return SoleQueue.getBuyersQuantity() > 4;
            case 2:
                return SoleQueue.getBuyersQuantity() > 9;
            case 3:
                return SoleQueue.getBuyersQuantity() > 14;
            case 4:
                return SoleQueue.getBuyersQuantity() > 19;
            case 5:
                return false;
        }
        return false;
    }

    static boolean saysCashierToCloseTheCounter() {
//        int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
        switch (counterOfOpenedCashiers.get()) {
            case 1:
                return SoleQueue.getBuyersQuantity() == 0;
            case 2:
                return SoleQueue.getBuyersQuantity() <= 4;
            case 3:
                return SoleQueue.getBuyersQuantity() <= 9;
            case 4:
                return SoleQueue.getBuyersQuantity() <= 14;
            case 5:
                return SoleQueue.getBuyersQuantity() <= 19;
            default:
                return false;
        }
    }

    static int getCashiersNumberWorking() {
        return counterOfOpenedCashiers.get();
    }

    static void cashierOpensTheCounter() {
        counterOfOpenedCashiers.getAndIncrement();
    }

    static void cashierClosesTheCounter() {
        counterOfOpenedCashiers.getAndDecrement();
    }

    private static int cashierId = 0;

    private static List<Cashier> cashiersThreads = new ArrayList<>(CASHIER_COUNTERS_AVAILABLE);

    static {
        for (int i = 1; i < 2; i++) {
            cashierId = i;
            cashiersThreads.add(new Cashier(cashierId));
        }
    }

    @SuppressWarnings("all")
    private static void makeCashierWork(ExecutorService executorService) {
        boolean hasWaiting = false;
        for (Cashier cashier : cashiersThreads) {
            if (cashier.getState().name().equals("WAITING")) {
                synchronized (cashier) {
                    cashier.notify();
                    hasWaiting = true;
                    break;
                }
            }
        }
        if (cashiersThreads.size() < Dispatcher.CASHIER_COUNTERS_AVAILABLE && !hasWaiting) {
            cashiersThreads.add(new Cashier(++cashierId));
            executorService.execute(cashiersThreads.get(cashierId - 1));
        }
    }

    @Override
    public void run() {
        ExecutorService executorServiceOfCashiers = Executors.newFixedThreadPool(CASHIER_COUNTERS_AVAILABLE);
        for (Cashier cashier : cashiersThreads) {
            executorServiceOfCashiers.execute(cashier);
        }
        while (!Dispatcher.shopCanBeClosed())
            while (Dispatcher.needsCashierToOpenTheCounter()) {
                makeCashierWork(executorServiceOfCashiers);
            }
        executorServiceOfCashiers.shutdownNow();
    }
}
