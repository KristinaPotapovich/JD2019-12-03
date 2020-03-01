package by.it.shpakovskiy.jd02_03;

import java.util.LinkedList;

class ShopRunner {
    static final int MAX_COUNT = 100;
    // Output to table?
    static final boolean IN_A_TABLE = true;
    // how many characters is the width of the column when outputting to the column?
    static final int CHAR_IN_COLUMN = 23;
    static final String EMPTY_COL = "                                           ".substring(0, CHAR_IN_COLUMN);

    public static void main(String[] args) {
        int countBuyers = 0;
        LinkedList<Buyer> buyers = new LinkedList<>();
        System.out.println("########################## Hello! BulbaStore opened! ##########################");
        BulbaStore store = new BulbaStore(50);//ENTER THE NUMBER OF BASKETS
        for (int second = 1; countBuyers < MAX_COUNT; second++) {
            if (!IN_A_TABLE)
                System.out.println("************ " + second + " ************ Buyers count: " + store.buyersCount());
            int c = getMaxBuyersCount(second);
            while (store.buyersCount() < c && store.isBasket() && countBuyers < MAX_COUNT) {
                buyers.add(new Buyer(++countBuyers, store));
            }
            Helper.sleep(1000);
        }
        buyers.forEach(buyer -> {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        });
    }

    private static int getMaxBuyersCount(int second) {
        int h = second / 60;
        int s = second - h * 60;
        if (s <= 30) return Helper.getRandom(1, 9);
        else return Helper.getRandom(30, 40);
    }

}
