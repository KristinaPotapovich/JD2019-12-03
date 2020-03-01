package by.it.shpakovskiy.jd02_03;

class Cashier implements Runnable {
    private String name;
    private BulbaStore shop;
    private boolean endWork;
    private boolean isWaiting;
    private int number;

    Cashier(int number, BulbaStore shop) {
        this.shop = shop;
        this.number = number;
        name = "Cashier-" + number;
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
        buyer.lock.lock();
        try {
            if (!ShopRunner.IN_A_TABLE) System.out.println(this + " serves " + buyer.getShortName());
            shop.check(buyer, this, lineLength);
            Helper.sleepRandom(2000, 5000);
            buyer.setStayingInQueue(false);
            buyer.servedByCashier.signal();
        }finally {
            buyer.lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "   " + name;
    }

    synchronized void endOfWorkingDay() {
        endWork = true;
        isWaiting = false;
        notify();
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

    synchronized boolean isWaiting() {
        return isWaiting;
    }
}
