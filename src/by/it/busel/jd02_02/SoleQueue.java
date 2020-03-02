package by.it.busel.jd02_02;

import java.util.ArrayDeque;

class SoleQueue {

    static final Object queueMonitor = new Object();

    private static ArrayDeque<Buyer> lowPriorityQueue = new ArrayDeque<>();
    private static ArrayDeque<Buyer> highPriorityQueue = new ArrayDeque<>();


    static void add(Buyer buyer) {
        synchronized (queueMonitor) {
            if (buyer.isPensioner) {
                highPriorityQueue.addLast(buyer);
            } else {
                lowPriorityQueue.addLast(buyer);
            }
        }
    }

    static Buyer extract() {
        synchronized (queueMonitor) {
            if (!highPriorityQueue.isEmpty()) {
                return highPriorityQueue.pollFirst();
            } else {
                return lowPriorityQueue.pollFirst();
            }
        }
    }

    static int getBuyersQuantity() {
        synchronized (queueMonitor) {
            return highPriorityQueue.size() + lowPriorityQueue.size();
        }
    }

}
