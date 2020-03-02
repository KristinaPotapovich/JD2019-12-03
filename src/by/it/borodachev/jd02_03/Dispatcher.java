package by.it.borodachev.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class Dispatcher {
    static final int K_SPEED=10000;
    static final int PLAN = 100;
    static final int maxChooseBuyers =20;
    static AtomicInteger countCashier=new AtomicInteger(0);
    static AtomicInteger inBuyer=new AtomicInteger(0);
    static AtomicInteger outBuyer=new AtomicInteger(0);
    static AtomicLong sumBuyers=new AtomicLong(0);
    static boolean marketOpened() {
        return inBuyer.get() < PLAN;
    }
    static boolean marketClosed() {
        return inBuyer.get() == outBuyer.get() && outBuyer.get() >= PLAN;
    }
    static void buyerEnter() {inBuyer.getAndIncrement(); }
    static void buyerLeave() {
         outBuyer.getAndIncrement();
    }
    static List <Cashier> cashiers=new ArrayList<>();
    static void addsumBuyers(Double paySum) {sumBuyers.addAndGet(Math.round(paySum*100));}
    static Double getsumBuyers() {return sumBuyers.doubleValue()/100;}
    static BlockingQueue<Buyer> buyer2Cash;
    static void initQueue (BlockingQueue T) {buyer2Cash=T;}
    static Semaphore buyersinMaktetSize = new Semaphore(maxChooseBuyers);
    static ArrayBlockingQueue<Backet> bakets = new ArrayBlockingQueue<Backet>(30);
    static void setbakets ()
    {
    for (int i = 0; i < 30; i++) {
        try {
            Dispatcher.bakets.put(new Backet());
        }
        catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

}
}
