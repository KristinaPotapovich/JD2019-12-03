package by.it.shpakovskiy.jd02_03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean pensioner;
    private final BulbaStore store;
    private Basket basket;
    private Product product;
    private double check;
    Lock lock = new ReentrantLock();
    Condition servedByCashier = lock.newCondition();
    private boolean isStayingInQueue;

    Buyer(int num, BulbaStore store) {
        super("Buyer-" + num);
        this.store = store;
        pensioner = Math.random() < 0.25;
        start();
    }

    Buyer() {
        store = null;
        pensioner = true;
    }

    public void setCheck(double check) {
        this.check = check;
    }

    public double getCheck() {
        return check;
    }

    public void setStayingInQueue(boolean stayingInQueue) {
        isStayingInQueue = stayingInQueue;
    }

    @Override
    public boolean enterToMarket() {
        int c = store.enter(this);
        if (c >= 0) {
            if (!ShopRunner.IN_A_TABLE) System.out.println(this + " enter to the BulbaStore. Count buyer: " + c);
            yield();
            return true;
        } else {
            if (c == -1) if (!ShopRunner.IN_A_TABLE) System.err.println(this + " was not allowed into the store.");
            return false;
        }
    }

    @Override
    public void takeBasket() {
        if (!ShopRunner.IN_A_TABLE) System.out.println(this + " waits basket");
        while (true) {
            basket = store.getBasket();
            if (basket != null) {
                break;
            }
            yield();
        }
        if (!ShopRunner.IN_A_TABLE) System.out.println(this + " take basket");
        sleepBuyer(500, 2000);
    }

    private void enterTradeHall() {
        store.enterToTradeHall(this);
    }

    private void leaveTradeHall() {
        store.leaveTradeHall(this);
    }

    @Override
    public void chooseGoods() {
        if (!ShopRunner.IN_A_TABLE) System.out.println(this + " started choosing by goods");
        product = store.getAccessToTheShowcase().getSomeProduct();
        sleepBuyer(125, 500);
        if (!ShopRunner.IN_A_TABLE) System.out.println(this + " finished choosing by goods");

    }

    @Override
    public void putGoodsToBasket() {
        basket.putGoodsToTheBasket(product);
        if (!ShopRunner.IN_A_TABLE)
            System.out.println(this + " put " + product + " to the basket. Total goods count in basket: " + basket.getSize());
        sleepBuyer(125, 500);
    }

    private void getInQueue() {
        lock.lock();
        try {
            int size = store.addToQueue(this);
            if (!ShopRunner.IN_A_TABLE) System.out.println(this + " stay in queue. Buyers count in queue: " + size);
            isStayingInQueue = true;
            while (isStayingInQueue) {
                servedByCashier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    Basket getGoods() {
        return basket;
    }

    @Override
    public void goToOut() {
        store.returnBasket(basket);
        int count = store.leave(this);
        if (!ShopRunner.IN_A_TABLE)
            System.out.println(this + " go out. Your check:" + check + " Left: " + count);
    }

    @Override
    public void run() {
        if (enterToMarket()) {
            takeBasket();
            enterTradeHall();
            int random = Helper.getRandom(1, 4);
            for (int i = 0; i < random; i++) {
                chooseGoods();
                putGoodsToBasket();
            }
            leaveTradeHall();
            getInQueue();
            goToOut();
        }
    }

    @Override
    public String toString() {
        return (pensioner ? "P " : "  ") + this.getName();
    }

    String getShortName() {
        return this.getName();
    }

    private void sleepBuyer(int from, int to) {
        if (pensioner) to = (int) (to * 1.5);
        Helper.sleepRandom(from, to);
    }

    public boolean isPensioner() {
        return pensioner;
    }
}
