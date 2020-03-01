package by.it.busel.jd02_02;

import java.util.ArrayList;
import java.util.List;

//todo maybe replace with  AtomicInteger
class Dispatcher extends Thread {
    static final int SPEED_COEFFICIENT = 100;
    private static final int MAX_DAILY_BUYERS_NUMBER = 100;
    private static final int CASHIER_COUNTERS_AVAILABLE = 5;

    private static final Object buyersMonitor = new Object();

    private static int counterOfBuyersServedToday = 0;
    private static int counterOfBuyersInside = 0;

    static boolean shopDoorsAreStillOpened() {
        synchronized (buyersMonitor) {
            return counterOfBuyersServedToday < MAX_DAILY_BUYERS_NUMBER;
        }
    }

    static boolean shopCanBeClosed() {
        synchronized (buyersMonitor) {
            return counterOfBuyersServedToday == MAX_DAILY_BUYERS_NUMBER && counterOfBuyersInside == 0;
        }
    }

    static int getBuyersNumberInside() {
        synchronized (buyersMonitor) {
            return counterOfBuyersInside;
        }
    }

    static void buyerEntered() {
        synchronized (buyersMonitor) {
            counterOfBuyersServedToday++;
            counterOfBuyersInside++;
        }
    }

    static void buyerLeft() {
        synchronized (buyersMonitor) {
            counterOfBuyersInside--;
        }
    }

    private static int counterOfOpenedCashiers = 0;

    private static final Object cashiersMonitor = new Object();

    private static boolean needsCashierToOpenTheCounter() {
        synchronized (cashiersMonitor) {
            synchronized (SoleQueue.class) {
                int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
                switch (counterOfOpenedCashiers) {
                    case 0:
                        return quantityOfBuyersInAQueue > 0;
                    case 1:
                        return quantityOfBuyersInAQueue > 5;
                    case 2:
                        return quantityOfBuyersInAQueue > 10;
                    case 3:
                        return quantityOfBuyersInAQueue > 15;
                    case 4:
                        return quantityOfBuyersInAQueue > 20;
                    case 5:
                        return false;
                }
            }
        }
        return false;
    }

    static boolean saysCashierToCloseTheCounter() {
        synchronized (cashiersMonitor) {
            synchronized (SoleQueue.queueMonitor) {
                int quantityOfBuyersInAQueue = SoleQueue.getBuyersQuantity();
                switch (counterOfOpenedCashiers) {
                    case 1:
                        return quantityOfBuyersInAQueue == 0;
                    case 2:
                        return quantityOfBuyersInAQueue <= 5;
                    case 3:
                        return quantityOfBuyersInAQueue <= 10;
                    case 4:
                        return quantityOfBuyersInAQueue <= 15;
                    case 5:
                        return quantityOfBuyersInAQueue <= 20;
                    default:
                        return false;
                }
//                if (counterOfOpenedCashiers == 1) {
//                    return false;
//                } else if (counterOfOpenedCashiers == 2 && quantityOfBuyersInAQueue <= 5) {
//                    return true;
//                } else if (counterOfOpenedCashiers == 3 && quantityOfBuyersInAQueue <= 10) {
//                    return true;
//                } else if (counterOfOpenedCashiers == 4 && quantityOfBuyersInAQueue <= 15) {
//                    return true;
//                } else return counterOfOpenedCashiers == 5 && quantityOfBuyersInAQueue <= 20;
            }
        }
    }

//    static int getCashiersNumberWorking() {
//        synchronized (cashiersMonitor) {
//            return counterOfOpenedCashiers;
//        }
//    }

    static void cashierOpensTheCounter() {
        synchronized (cashiersMonitor) {
            counterOfOpenedCashiers++;
        }
    }

    static void cashierClosesTheCounter() {
        synchronized (cashiersMonitor) {
            counterOfOpenedCashiers--;
        }
    }

    private static int cashierId = 0;

    private static List<Cashier> cashiersThreads = new ArrayList<>(5);

    private static void addCashiers() {
        for (int i = 1; i <= 2; i++) {
            cashierId = i;
            Cashier cashier = new Cashier(cashierId);
            cashiersThreads.add(cashier);
            cashier.start();
        }
    }

    @SuppressWarnings("all")
    private static void makeCashierWork() {
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
            Cashier cashier = new Cashier(++cashierId);
            cashiersThreads.add(cashier);
            cashier.start();
        }
    }

    @SuppressWarnings("all")
    private static void checkIfCasiersStillAtWorkAndSendThemHome() {
        for (Cashier cashier : cashiersThreads) {
            if (!cashier.getState().name().equals("TERMINATED")) {
                synchronized (cashier) {
                    cashier.interrupt();
                }
            }
        }
    }

    private static void executeUntilAllCashiersFinished() {
        for (Cashier cashier : cashiersThreads) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        addCashiers();
        while (!Dispatcher.shopCanBeClosed())
            while (Dispatcher.needsCashierToOpenTheCounter()) {
                makeCashierWork();
            }
        checkIfCasiersStillAtWorkAndSendThemHome();
        executeUntilAllCashiersFinished();
    }
}
