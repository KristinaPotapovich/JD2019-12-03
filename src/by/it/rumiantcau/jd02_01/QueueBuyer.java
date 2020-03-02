package by.it.rumiantcau.jd02_01;


import java.util.ArrayDeque;

class QueueBuyer{

    private static ArrayDeque<Buyer> queue=new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        queue.addLast(buyer);
    }

    static synchronized Buyer extract(){
        return queue.pollFirst();
    }





}
