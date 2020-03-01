package by.it.shpakovskiy.jd02_02;

import java.util.LinkedList;

class QueueBuyer {

    private LinkedList<Buyer> young; // Обычные
    private LinkedList<Buyer> old; // Пенсионеры

    QueueBuyer() {
        young = new LinkedList<>();
        old = new LinkedList<>();
    }

    synchronized int addBuyer(Buyer buyer) {
        if (buyer.isPensioner()) {
            old.addLast(buyer);
        } else {
            young.addLast(buyer);
        }
        return young.size() + old.size();
    }

    synchronized Buyer next() {
        if (!old.isEmpty()) {
            return old.pollFirst();
        } else {
            return young.pollFirst();
        }
    }

    synchronized int length() {
        return young.size() + old.size();
    }

//    boolean isBuyer() {
//        return !young.isEmpty() || !old.isEmpty();
//    }
}
