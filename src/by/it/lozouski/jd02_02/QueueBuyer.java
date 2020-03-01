package by.it.lozouski.jd02_02;

import java.util.ArrayDeque;

class QueueBuyer {
    private static volatile ArrayDeque<Buyer> buyersQueue = new ArrayDeque<>();

    public static ArrayDeque<Buyer> getBuyersQueue() {
        return buyersQueue;
    }

    static synchronized void addBuyerToQueue(Buyer currBuyer) {
        buyersQueue.add(currBuyer);
    }

    static synchronized Buyer extractBuyerFromQueue() {
        return buyersQueue.pollFirst();
    }
}
