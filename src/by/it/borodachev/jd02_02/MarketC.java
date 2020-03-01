package by.it.borodachev.jd02_02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MarketC {

    public static void main(String[] args) {
        System.out.println("---------- Market opened");
        List<BuyerC> buyers=new ArrayList<>(1000);
        Comparator<BuyerC> comp = new Comparator<BuyerC>() {
            public int compare(BuyerC o1, BuyerC o2) {
                if (o1.ispensioner()&&!o2.ispensioner())
                    return -1;
                if (o2.ispensioner()&&!o1.ispensioner())
                    return 1;;
                 return 0;
            }
        };
        Dispatcher.initQueue(comp);
        for (int i = 0; i <=4 ; i++) {
            Dispatcher.cashiers.add(new Cashier(i+1));
        }
        // Запустим кассы и пока никого нет - сами закроются
        for (Cashier cashier : Dispatcher.cashiers) {
            cashier.setDaemon(true);
            Dispatcher.cashierStart();
            cashier.start();
        }
        int number=0;
        for (int time = 0; time <= 10; time++) {
            int count;
            if ((time/30)%2==0) // начало минуты
            {count=time%30+10- Dispatcher.buyerCount() ;}
            else // окончание минуты
            { count=40+(30-time%60)- Dispatcher.buyerCount() ;
            }
            if (count<0) count=0;
            for (int i = 1; i <= count; i++) {

                BuyerC buyer = new BuyerC(++number);
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        while (Dispatcher.buyerCount()!=0) {Helper.sleep(1000);}
        for (BuyerC buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("WOW2");
            }
        }
        System.out.println("--------- Market closed");
    }

}
