package by.it.kuzmichalex.jd02_01;

class Dispatcher {
    static int nCountOfBuyers = 0;
    static final int MIN_BUYERS = 10;
    static final int MAX_BUYERS = 35;

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
}
