package by.it.busel.jd02_03;

interface IBuyer {
    void enterToMarket(); // a Buyer has entered the store

    void chooseGoods(); // a Buyer has chosen an item of goods (it has taken him (her) from 500 to 2000 milliseconds

    void goToQueue(); // a Buyer has made for a queue

    void goOut(); // a Buyer has made for the shop-exit
}
