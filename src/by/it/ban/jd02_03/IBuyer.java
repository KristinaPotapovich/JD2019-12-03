package by.it.ban.jd02_03;

interface IBuyer {

    void enterTheMarket();    //вошел в магазин (мгновенно)
    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)
    void goToQueue();        //отправился  очередь
    void exitTheMarket();            //отправился на выход(мгновенно)

}
