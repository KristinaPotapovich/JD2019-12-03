package by.it.kuzmichalex.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;

class Cashier implements Runnable {
    private String cashierName;
    private int cashierNumber;

    private final AtomicBoolean toStop = new AtomicBoolean(true);
    private final AtomicBoolean isStopped = new AtomicBoolean(true);
    volatile String state;

    public Cashier(int n) {
        cashierName = "Cashier " + n + " ";
        cashierNumber = n;
        Logger.addToLog(this + "created", cashierNumber);
    }

    @Override
    public void run() {
        while (Dispatcher.isPlanNotExecuted()) {
            if (toStop.get()) {
                Logger.addToLog("......." + this + ".......\n.... PAUSED wait(); ....\n........................", cashierNumber);
                synchronized (this) {
                    try {
                        isStopped.getAndSet(true);
                        state="stopped";
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //getBuyerFromQueue синхронизирован монитором очереди. поэтому этот buyer - только этого потока
            Buyer buyer = BuyerQueue.getBuyerFromQueue();
            if (buyer != null) {
                Logger.addToLog("-------------------------\n" + this + "started serving\n" + buyer + "\n-------------------------", cashierNumber);
                state = "serving "+buyer + "...";
                TimeHelper.sleep(TimeHelper.getRandom(2000, 5000));
                Logger.addToLog(buyer.getCheck(), cashierNumber);
                Dispatcher.addMarketAmount(buyer.getBuyerTotalAmount());
                state = "awaiting buyer";
                synchronized (buyer) {    //buyer-ы в очереди wait, поэтому делаем им notify
                    buyer.notify();
                }
            } //else goWait(" himself");
        }
        state="finished";
        isStopped.getAndSet(true);
        Logger.addToLog(this + "finished ", cashierNumber);
    }

    public String toString() {
        return cashierName;
    }

    public void goWait(String reason) {
        if (cashierNumber == 0) return;     //Этот кассир невезучий. он не может быть на перекуре
        if (!toStop.get()) {
            Logger.addToLog(".. " + this + " ..\n.. TO PAUSE by" + reason, cashierNumber);
            state="stopping";
            toStop.getAndSet(true);
        }
    }

    public void goNotify() {
        if (isStopped.get()) {
            Logger.addToLog(this + "RESUME notify();", cashierNumber);
            synchronized (this) {
                isStopped.getAndSet(false);
                toStop.getAndSet(false);
                this.notify();
            }
        }
    }

    public String getState() {
        return state;
    }

    public boolean isStopped(){return isStopped.get(); }

}
