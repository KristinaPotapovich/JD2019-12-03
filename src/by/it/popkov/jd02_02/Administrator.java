package by.it.popkov.jd02_02;

/**
 * class Administrator control number of opened Cashier.
 * Notify extra Cashier, when queueSize / onlineCashier > 5
 **/
class Administrator extends Thread {
    private BuyerQueue buyerQueue;
    private final Object monitorCashier;
    private Dispatcher dispatcher;

    public Administrator(BuyerQueue buyerQueue, Object monitorCashier, Dispatcher dispatcher) {
        this.buyerQueue = buyerQueue;
        this.monitorCashier = monitorCashier;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        while (!dispatcher.marketIsClosed()) {
            Helper.delay(1000);
            double queueSize = buyerQueue.getBuyerQueueSize() + buyerQueue.getPensionerQueueSize();
            double onlineCashier = dispatcher.getOnlineCashier();
            if (onlineCashier == 0) {
                if (queueSize > 0) {
                    synchronized (monitorCashier) {
                        monitorCashier.notify();
                    }
                }
            } else if (queueSize / onlineCashier > 5) {
                synchronized (monitorCashier) {
                    monitorCashier.notify();
                }
            }
        }
        synchronized (monitorCashier) {//after market closet restart work and let go home all Cashier
            monitorCashier.notifyAll();
        }
    }
}
