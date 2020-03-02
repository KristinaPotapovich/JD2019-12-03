package by.it.plugatar.jd02_03;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyer {
    //private static BlockingQueue<Buyer> queue=new LinkedBlockingDeque<>(30);

    private static ArrayDeque<Buyer> queue= new ArrayDeque<>();
    static  synchronized void add(Buyer buyer){
        queue.addLast(buyer);
    }
    static synchronized Buyer extract(){
        return queue.pollFirst();
    }

}
