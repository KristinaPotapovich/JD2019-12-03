package by.it.samuseva.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>(1000);
        new Good();

        System.err.println("-----------THE MARKET HAS OPENED-----------");
        int state = 0;
        int number = 0;
        for (int time = 0; time <=120 ; time++) {
            // каждую секунду входит от 0 до 2 человек
            int count = Helper.random(0,2);
            for (int i = 1; i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispetcher.CountBuyer++;
                if (number%4 == 0) buyer.pensioneer = true;
                buyers.add(buyer);
                buyer.start();

            }
            Helper.sleep(1000);

        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("YPS !!!");
            }
        }
        System.err.println("-----------THE MARKET HAS CLOSED-----------");
    }
}
