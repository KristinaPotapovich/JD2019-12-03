package by.it.filipovich.jd02_03;

public interface IBuyer {
    void enterToMarket(); //вошел в магазин
    void chooseGoods();   // выбрал товар (от 0,5 до 2с)
    void goToQueue();     // отправился в очередь
    void goOut();         //отправился на выход(мгновенно)
}
