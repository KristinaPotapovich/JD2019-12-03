package by.it.filipovich.jd02_01;

public interface IBuyer {
    void enterToMarket(); //вошел в магазин
    void chooseGoods();   // выбрал товар (от 0,5 до 2с)
    void goOut();         //отправился на выход(мгновенно)
}
