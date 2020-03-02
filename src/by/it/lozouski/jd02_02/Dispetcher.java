package by.it.lozouski.jd02_02;

class Dispetcher {
    private static final Object monitor = new Object();
    private static final int BUYERS_PLAN = 100;
    static final int SPEED_K = 1000;

    private static int buyersEnterCounter = 0;
    private static int buyersCounter = 0;


    static boolean marketOpened() {
        synchronized (monitor) {
            return buyersEnterCounter < BUYERS_PLAN;
        }
    }

    static boolean marketClosed() {
        synchronized (monitor) {
            return buyersEnterCounter == BUYERS_PLAN && buyersCounter == 0;
        }
    }

    static void buyerEnteredMarket() {
        synchronized (monitor) {
            buyersEnterCounter++;
            buyersCounter++;
        }
    }

    static void buyerLeftMarket() {
        synchronized (monitor) {
            buyersCounter--;
        }
    }
}
