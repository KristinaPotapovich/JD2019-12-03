package by.it.borodachev.jd02_03;

interface IBuyer  {
    void enterToMarket();    //вошел в магазин (мгновенно)
    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)
    void add2Queue() ;        //в очередь к кассиру
    void pay(int numCash);  // оплатить
    void goOut();            //отправился на выход(мгновенно)

}
