package by.it.borodachev.jd02_01;

import java.util.ArrayList;
import java.util.List;

class MarketC {

    public static void main(String[] args) {
        System.out.println("---------- Market opened");
        List<BuyerC> buyers=new ArrayList<>(1000);
        int number=0;
        for (int time = 0; time <= 120; time++) {
            int count;
            if ((time/30)%2==0) // начало минуты
            {count=time%30+10-Dispatcher.buyerCount() ;}
            else // окончание минуты
            { count=40+(30-time%60)-Dispatcher.buyerCount() ;
            }
            if (count<0) count=0;
            for (int i = 1; i <= count; i++) {

                BuyerC buyer = new BuyerC(++number);
                buyers.add(buyer);
                buyer.start();
            }
            Helper.sleep(1000);
        }

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
