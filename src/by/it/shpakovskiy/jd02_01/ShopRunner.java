package by.it.shpakovskiy.jd02_01;

import java.util.LinkedList;

class ShopRunner {
    private static int countBuyers = 0;

    public static void main(String[] args) {
        LinkedList<Buyer> buyers = new LinkedList<>();
        BulbaStore store = new BulbaStore(20);//ENTER THE NUMBER OF BASKETS
        System.out.println("########################## Hello! BulbaStore opened! ##########################");
        for (int second = 0; second < 120; second++) {
            System.out.println("************ " + second + " ************ Buyers count: " + store.buyersCount());
            int c = getMaxBuyersCount(second);
            while (store.buyersCount() < c && store.isBasket()) {
                buyers.add(new Buyer(++countBuyers, store));
            }
            Helper.sleep(1000);
        }
        buyers.forEach(buyer -> {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("########################## BulbaStore closed! Buy ##########################");
    }

    private static int getMaxBuyersCount(int second) {
        int h = second / 60;
        int s = second - h * 60;
        if (s <= 30) return s + 10;
        else return 40 + (30 - s);
    }
}
