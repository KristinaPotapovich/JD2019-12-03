package by.it.ban.jd02_02;

class Dispatcher {
    static final int K_SPEED=100;
    static final int ALL_CASHIERS=5;
    private static final Object monitor = new Object();
    private static final Object cashMon = new Object();
    private static final Object allCashMon = new Object();
    private static final int PLAN = 100;


    private static int enterBuyer = 0;
    private static int countBuyer = 0;
    private static int cashCount = 0;
    private static double allCash = 0;


    static boolean marketOpened() {
        synchronized (monitor) {
            return enterBuyer < PLAN;
        }
    }

    static boolean marketClosed() {
        synchronized (monitor) {
            return countBuyer == 0;
        }
    }

    static void buyerEnter() {
        synchronized (monitor) {
            enterBuyer++;
            countBuyer++;
        }
    }

    static void buyerLeave() {
        synchronized (monitor) {
            countBuyer--;
        }
    }

    static int getCountBuyer() {
        synchronized (monitor) {
            return countBuyer;
        }
    }
    static void cashOpen() {
        synchronized (cashMon) {
            cashCount++;
        }
    }

    static void cashClose() {
        synchronized (cashMon) {
            cashCount--;
        }
    }

    static int getCashCount() {
        synchronized (cashMon) {
            return cashCount;
        }

    }
    static void addAllCash(double sum) {
        synchronized (allCashMon) {
            allCash+=sum;
        }

    }

    public static double getAllCash() {
        synchronized (allCashMon) {
            return allCash;
        }
    }
}
