package by.it.busel.jd02_03;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

class SoleQueue {
    private static final LinkedBlockingDeque<Buyer> queue = new LinkedBlockingDeque<>();

    static final Object queueMonitor = new Object();

//    private static ArrayDeque<Buyer> lowPriorityQueue = new ArrayDeque<>();
//    private static ArrayDeque<Buyer> highPriorityQueue = new ArrayDeque<>();


    static void add(Buyer buyer) {
        if (buyer.isPensioner) {
            queue.addFirst(buyer);
        } else {
            queue.addLast(buyer);
        }
//        synchronized (queueMonitor) {
//            if (buyer.isPensioner) {
//                highPriorityQueue.addLast(buyer);
//            } else {
//                lowPriorityQueue.addLast(buyer);
//            }
//        }
    }

    static Buyer extract() {
        Iterator<Buyer> buyerIterator = queue.descendingIterator();
        while (buyerIterator.hasNext()) {
            Buyer next = buyerIterator.next();
            if (next.isPensioner) {
                buyerIterator.remove();
                return next;
            }
        }
        return queue.pollFirst();
//        synchronized (queueMonitor) {
//            if (!highPriorityQueue.isEmpty()) {
//                return highPriorityQueue.pollFirst();
//            } else {
//                return lowPriorityQueue.pollFirst();
//            }
//        }
    }

    static int getBuyersQuantity() {
        return queue.size();
//        synchronized (queueMonitor) {
//            return highPriorityQueue.size() + lowPriorityQueue.size();
//        }
    }

}
