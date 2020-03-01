package by.it.borodachev.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.State.WAITING;

class Buyer extends Thread implements IBuyer {
    AtomicBoolean waitNextOperation=new AtomicBoolean(false);
    public Buyer(int number) {
        super("Buyer №"+number+" ");
        Dispatcher.buyerEnter();
    }

    @Override
    public void add2Queue()  {
        System.out.println(this+" Ожидание очереди");
        waitNextOperation.set(true);
        try {
              Dispatcher.buyer2Cash.put(this);}
              catch (InterruptedException e) {
                  System.out.println(" Error:"+this+e.toString());
              }
        System.out.println(this+" Стоит в очереди");
          // если кто-то спит разбудим
            for (Cashier cashier : Dispatcher.cashiers) {
                if (cashier.getState()==WAITING) {
                    System.out.println(cashier+" будим");
                    synchronized (cashier) {
                        cashier.notify();
                    }
                }
            }
            synchronized (this) {
           while (this.waitNextOperation.get()) {
               try {
                   this.wait();
               } catch (InterruptedException e) {
                   System.out.println(" Error:" + this + e.toString());
               }
           }
           }
    }
    @Override
    public void pay(int numCash) {
        waitNextOperation.set(false);
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
        Dispatcher.buyerLeave();
        System.out.println(this+" Вышел из магазина");

    }


    @Override
    public String toString() {
        return this.getName();
    }
}
