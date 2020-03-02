package by.it.shpakovskiy.jd02_03;

import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyer {

    private LinkedBlockingDeque<Buyer> allBuyers;
    private LinkedBlockingDeque<Buyer> old;
    private static final Buyer pensioner = new Buyer();

    QueueBuyer(int size) {
        allBuyers = new LinkedBlockingDeque<>(size);
        old = new LinkedBlockingDeque<>();
    }

    int addBuyer(Buyer buyer) {
        try {
            if (buyer.isPensioner()) {
                old.addLast(buyer);
                allBuyers.putFirst(pensioner);
            } else allBuyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allBuyers.size();
    }

    Buyer next() {
        Buyer buyer = allBuyers.pollFirst();
        if (buyer == pensioner) return old.pollFirst();
        return buyer;
    }

    int length() {
        return allBuyers.size();
    }

//    boolean isBuyer() {
//        return !young.isEmpty();
//    }
}
