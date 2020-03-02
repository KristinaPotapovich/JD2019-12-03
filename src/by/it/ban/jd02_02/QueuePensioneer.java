package by.it.ban.jd02_02;

import java.util.ArrayDeque;

public class QueuePensioneer {
    private static ArrayDeque<Buyer> queue=new ArrayDeque<>();


    static synchronized void add(Buyer buyer){
        queue.addLast(buyer);
    }

    static synchronized Buyer extract(){
        return queue.pollFirst();
    }

    static int getLength(){
        return queue.size();
    }
}
