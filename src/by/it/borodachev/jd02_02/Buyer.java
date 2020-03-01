package by.it.borodachev.jd02_02;

import static java.lang.Thread.State.WAITING;

class Buyer extends Thread implements IBuyer{
    public Buyer(int number) {
        super("Buyer №"+number+" ");
        Dispatcher.buyerIN();
    }

    @Override
    public void add2Queue()  {
        System.out.println(this+" Ожидание очереди");
        synchronized (Dispatcher.sunc) {
          Dispatcher.buyer2Cash.add(this);
          // если кто-то спит разбудим
            for (Cashier cashier : Dispatcher.cashiers) {
                if (cashier.getState()==WAITING)
                    synchronized (cashier) {cashier.notify();}
            }
        }

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
    }
    @Override
    public void pay(int numCash) {
         return ;
     }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        add2Queue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" Вошел в Магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" Выбор товара");
        int timeout= Helper.random(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+" Товар выбран");

    }

    @Override
    public void goOut() {
        System.out.println(this+" Вышел из магазина");
        Dispatcher.buyerOUT();
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
