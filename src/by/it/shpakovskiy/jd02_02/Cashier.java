package by.it.shpakovskiy.jd02_02;

class Cashier implements Runnable {
    private BulbaStore shop;
    private Thread thread;
    private boolean endWork;
    private boolean isWaiting;
    private int number;

    Cashier(int number, BulbaStore shop) {
        this.shop = shop;
        this.number = number;
        thread = new Thread(this, "Cashier-" + number);
        thread.start();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        while (!endWork) {
            Buyer buyer = shop.getBuyer();
            if (buyer != null) {
                service(buyer, shop.queueLength());
            } else {
                if (!ShopRunner.IN_A_TABLE) System.out.println(this + " closed.");
                pause();
            }
        }
    }

    private void service(Buyer buyer, int lineLength) {
        if (!ShopRunner.IN_A_TABLE) System.out.println(this + " serves " + buyer.getShortName());
        shop.check(buyer, this, lineLength);
        Helper.sleepRandom(2000, 5000);
        synchronized (buyer) {
            buyer.notify();
        }
    }

    @Override
    public String toString() {
        return "   " + thread.getName();
    }

    synchronized void endOfWorkingDay() {
        endWork = true;
        wakeAndClose();
    }


    private synchronized void pause() {
        isWaiting = true;
        while (isWaiting) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        }
    }

    synchronized boolean wakeUp() {
        if (isWaiting) {
            isWaiting = false;
            notify();
            if (!ShopRunner.IN_A_TABLE) System.out.println(this + "  began to work!");
            return true;
        } else return false;
    }

    private synchronized void wakeAndClose() {
        isWaiting = false;
        notify();
    }

    synchronized boolean isWaiting() {
        return isWaiting;
    }

    Thread getThread() {
        return thread;
    }
}
