package by.it.borodachev.jd02_02;

public class Cashier extends Thread{
    private int numCash;
    public Cashier (int numCashier) {

        super ("Cashier "+numCashier);
        numCash=numCashier;
    }
    @Override
    public void run() {
        IBuyer b;
        while (true) {
 //           System.out.println(this+" Work");
            synchronized (Dispatcher.sunc) {
                b=Dispatcher.buyer2Cash.poll();
            }
            if (b == null) {
 //               System.out.println(this+" Close");
                synchronized (this) {
                    try {
                        Dispatcher.cashierStop();
                        this.wait();
                    } catch (InterruptedException e) {
                    }
                    Dispatcher.cashierStart();
                }
            }
             else {
                System.out.println(b + " в кассе");
                // обслуживаем
                int timeout = Helper.random(2000, 5000);
                synchronized (b) {
                    Helper.sleep(timeout);
                    b.pay(numCash);
                    b.notify();
                }
            }
    }
    }
}
