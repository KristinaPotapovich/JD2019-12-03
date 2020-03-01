package by.it.borodachev.jd02_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

class MarketC {

    public static void main(String[] args) {
        System.out.println("---------- Market opened");
        Dispatcher.setbakets();
        Comparator comp = new Comparator<BuyerC>() {
            public int compare(BuyerC o1, BuyerC o2) {
                int ret=0;
                if (o1.ispensioner()&&!o2.ispensioner())
                    ret=-1;
                if (o2.ispensioner()&&!o1.ispensioner())
                    ret=1;
                 return ret;
            }
        };
       Dispatcher.initQueue((BlockingQueue) new PriorityBlockingQueue<BuyerC>(1,comp));
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i <=4 ; i++) {
            Dispatcher.cashiers.add(new Cashier(i+1));
        }
        for (Cashier cashier : Dispatcher.cashiers) {
            cashier.setDaemon(true);
            Dispatcher.countCashier.incrementAndGet();
            fixedThreadPool.execute(cashier);
        }
        fixedThreadPool.shutdown();

        int number=0;
        int time=0;
        while (Dispatcher.marketOpened()) {
            int count;
            if ((time/30)%2==0) // начало минуты
            {count=time%30+10- (Dispatcher.inBuyer.get()-Dispatcher.outBuyer.get()) ;}
            else // окончание минуты
            { count=40+(30-time%60)- (Dispatcher.inBuyer.get()-Dispatcher.outBuyer.get()) ;
            }
            if (count<0) count=0;
            for (int i = 1; i <= count; i++) {
                BuyerC buyer = new BuyerC(++number);
                buyer.start();
            }
            Helper.sleep(1000);
            time++;
        }

        while (!Dispatcher.marketClosed()) {  Helper.sleep(100);}

        System.out.println("--------- Market closed");
    }


}
