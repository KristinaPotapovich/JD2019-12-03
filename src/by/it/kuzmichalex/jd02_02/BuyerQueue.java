package by.it.kuzmichalex.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class BuyerQueue {
    private static final Object monitorQueue = new Object();
    private static volatile Deque <Buyer> queueOfBuyers= new ArrayDeque<>();
    private static volatile int queueSize=0;
    private static CashierManager manager;

    BuyerQueue(CashierManager m)
    {
        System.out.println("Queue initialized");
        manager=m;
    }

    static void addBuyerToQueue(Buyer buyer){
        synchronized (monitorQueue){
            queueOfBuyers.addLast(buyer);
            queueSize++;
            manager.doManaging("add");
        }
    }
    /**
     * Очередь у нас будет одна. Но очень вежливая и покупатели пропустят пенсионеров сами.
     * Конечно, это неприлично увеличит размер критической сесии. Зато это проще всего.
     * */
    static Buyer getBuyerFromQueue(){
        synchronized (monitorQueue){
            Iterator<Buyer> iterator = queueOfBuyers.iterator();
            while(iterator.hasNext()){
                Buyer buyer = iterator.next();
                if(buyer.isPensioneer()){
                    iterator.remove();
                    queueSize--;
                    manager.doManaging("remove");
                    return buyer;
                }
            }
            Buyer buyer = queueOfBuyers.pollFirst();
            if(buyer!=null){
                queueSize--;
                manager.doManaging("remove");
            }
            return buyer;
        }
    }
    static int getQueueSize(){
     //   synchronized (monitorQueue){
            return queueOfBuyers.size();
      //  }
    }



}
