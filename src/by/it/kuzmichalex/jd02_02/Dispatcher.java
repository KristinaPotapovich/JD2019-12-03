package by.it.kuzmichalex.jd02_02;

class Dispatcher {
    static final int MAX_CASHIERS = 5;
    static final int PLAN = 100;
    static final int MIN_BUYERS = 10;
    static final int MAX_BUYERS = 35;

    static final Object monitorBuyers = new Object();
    static volatile int countOfBuyers = 0;
    static volatile int countOfBuyersDone = 0;

    static final Object monitorTotalAmount = new Object();
    static volatile double marketTotalAmount = 0.0;



    /**
     * Получить количество требуемых покупателей в зависимости от времени.
     * MIN_BUYERS в начале минуты, MAX_BUYERS в середине минуты, примерно вот так:
     * ____/ \       /\
     * __/    \    /   \
     * /       \/       \
     * _______________________t
     *
     * @param nSecond секунда
     * @return требуемое количество покупателей
     */
    static int getBuyersNeed(int nSecond) {
        int nPeriod = nSecond % 60;
        if (nPeriod < 30) return MIN_BUYERS + (MAX_BUYERS - MIN_BUYERS) * nPeriod / 30;    //Восходящий полупериод
        return MAX_BUYERS - (MAX_BUYERS - MIN_BUYERS) * (nPeriod % 30) / 30;               //Нисходящий полупериод
    }

    static int getCountBuyersInside() {
        synchronized (monitorBuyers) {
            return countOfBuyers;
        }
    }



    static int getCountBuyersDone() {
        synchronized (monitorBuyers) {
            return countOfBuyersDone;
        }
    }

    static boolean isAllBuyersDone() {
        synchronized (monitorBuyers) {
            return countOfBuyersDone == PLAN;
        }
    }

    static void enterToMarket() {
        synchronized (monitorBuyers) {
            countOfBuyers++;
        }
    }

    static void goOut() {
        synchronized (monitorBuyers) {
            countOfBuyers--;
            countOfBuyersDone++;
        }
    }

    static void addMarketAmount(double amount){
        synchronized (monitorTotalAmount){
            marketTotalAmount+=amount;
        }
    }

    static double getMarketTotalAmount(){
        return marketTotalAmount;
    }

}
