package by.it.filipovich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static final int K_SPEED=1000;
    private static final int PLAN=100;

    private final static AtomicInteger enterBuyer = new AtomicInteger(0);
    private final static AtomicInteger count = new AtomicInteger(0);


    static boolean marketIsOpened(){
            return enterBuyer.get() < PLAN;
    }

    static boolean marketIsClosed(){
            return enterBuyer.get() == PLAN && count.get()==0;
    }

    static void buyerEnter(){
            enterBuyer.getAndIncrement();
            count.getAndIncrement();
    }

    static void buyerLeave(){
            count.getAndDecrement();
    }
}
