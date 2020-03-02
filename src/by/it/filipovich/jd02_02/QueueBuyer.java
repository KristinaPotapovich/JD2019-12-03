package by.it.filipovich.jd02_02;

import java.util.ArrayDeque;

public class QueueBuyer {

    private final static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static synchronized void addBuyer(Buyer buyer){
        queue.addLast(buyer);
    }

    static synchronized Buyer extract(){
        return queue.pollFirst();
    }

}
