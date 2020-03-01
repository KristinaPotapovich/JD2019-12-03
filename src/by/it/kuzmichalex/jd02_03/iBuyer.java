package by.it.kuzmichalex.jd02_03;

interface iBuyer {
    void enterToMarket();    //вошел в магазин (мгновенно)
    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)
    void goToQueue();          //Отправился стоять в очередь
    void goOut();            //отправился на выход(мгновенно)
}
