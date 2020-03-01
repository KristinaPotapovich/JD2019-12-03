package by.it.popkov.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

class BuyerQueue {
    private final BlockingDeque<Buyer> buyerQueue = new LinkedBlockingDeque<>(30);

    private final ConcurrentLinkedDeque<Buyer> pensionerQueue = new ConcurrentLinkedDeque<>();

    public void addToQueue(Buyer buyer) {
        buyerQueue.addLast(buyer);
    }

    public Buyer getFirstBuyer() {
        return buyerQueue.pollFirst();
    }

    public void addToPensionerQueue(Buyer buyer) {
        pensionerQueue.addLast(buyer);
    }

    public Buyer getFirstPensioner() {
        return pensionerQueue.pollFirst();
    }

    public int getBuyerQueueSize() {
        return buyerQueue.size();
    }

    public int getPensionerQueueSize() {
        return pensionerQueue.size();
    }
}
