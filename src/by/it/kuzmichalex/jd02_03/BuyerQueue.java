package by.it.kuzmichalex.jd02_03;

import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class BuyerQueue {
    //private static final Object monitorQueue = new Object();
    //private static volatile Deque <Buyer> queueOfBuyers= new ArrayDeque<>();
    private static BlockingDeque<Buyer> queueOfBuyers = new LinkedBlockingDeque<>(Dispatcher.MAX_BUYERS_IN_QUEUE);

    private static AtomicInteger queueSize = new AtomicInteger(0);
    private static CashierManager manager;

    BuyerQueue(CashierManager m) {
        System.out.println("Queue initialized");
        manager = m;
    }

    static void addBuyerToQueue(Buyer buyer) {
        int attempts = 1000;
        boolean success;
        do {
            success = true;
            try {
                queueOfBuyers.addLast(buyer);
            } catch (Exception e) {
                success = false;
                attempts--;
                TimeHelper.sleep(TimeHelper.getRandom(100, 1000));
            }
        }
        while (!success && attempts > 0);
        if (attempts == 0) {
            throw new IllegalStateException();
        }
        queueSize.getAndIncrement();
        manager.doManaging("add");
    }

    /**
     * Очередь у нас будет одна. Но очень вежливая и покупатели пропустят пенсионеров сами.
     * Конечно, это неприлично увеличит размер критической сесии. Зато это проще всего.
     */
    static Buyer getBuyerFromQueue() {
        Iterator<Buyer> iterator = queueOfBuyers.iterator();
        while (iterator.hasNext()) {
            Buyer buyer = iterator.next();
            if (buyer.isPensioner()) {
                iterator.remove();
                queueSize.getAndDecrement();
                manager.doManaging("remove");
                return buyer;
            }
        }
        Buyer buyer = queueOfBuyers.pollFirst();
        if (buyer != null) {
            queueSize.getAndDecrement();
            manager.doManaging("remove");
        }
        return buyer;
    }

    static int getQueueSize() {
        return queueOfBuyers.size();
    }


}
