package by.it.plugatar.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static final int K_SPEED=100;
    private final static AtomicInteger buyersCount = new AtomicInteger(0);
    static int totalBuyersCount;
    static int totalRetiredCount;

    static boolean marketClosed(){
            return false;
    }
}
