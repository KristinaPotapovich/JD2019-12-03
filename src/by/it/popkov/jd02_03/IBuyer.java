package by.it.popkov.jd02_03;

import java.util.Map;

interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goOut(); //отправился на выход(мгновенно)
    void goToQueue();
    Map<String, Integer> getBasket();
}
