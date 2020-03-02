package by.it.popkov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {
        Helper.writeGoodsMap();
        System.out.println("****** Open shop ******");
        List<Buyer> buyerList = new ArrayList<>(1777);
        int counter = 1;
        int letIn = 0;
        for (int t = 0; t < 120; t++) {
            if (t == 0) letIn = 10;
            if (t > 0 && t < 30) letIn = (t + 10) / 6; //UP
            if (t >= 30 && t < 60) letIn = (40 + (30 - t)) / 6; //DOWN
            if (t >= 60 && t < 90) letIn = ((t - 60) + 10) / 6; //UP
            if (t >= 90) letIn = (40 + (90 - t)) / 6; //DOWN
//           letIn = Helper.randNumUntil(2);
            for (int j = 1; j <= letIn; j++) {
                Buyer buyer = new Buyer(counter++);
                buyer.start();
                buyerList.add(buyer);
            }
            try {
                Thread.sleep(1000 / Dispatcher.SPEED_BOOST);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("Sec = " + t + "Count = " + Dispatcher.buyerCounter);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("****** Close shop ******");

    }
}


//if (t == 0) letIn = 10;
//        if (t > 0 && t < 30) letIn = (t + 10)/6; //UP
//        if (t >= 30 && t < 60) letIn = (40 + (30 - t))/6; //DOWN
//        if (t >= 60 && t < 90) letIn = ((t - 60)  + 10)/6; //UP
//        if (t >= 90) letIn = (40 + (90 - t))/6; //DOWN


//if (Dispatcher.buyerCounter < t + 10 && t < 30) { //UP
////        letIn = 10;
////        }else if (Dispatcher.buyerCounter < t - 50 && (t > 60 && t < 90)) { //UP
////        letIn = 10;
////        }else if (Dispatcher.buyerCounter <= 40 + (30 - t) && (t >= 30 && t <= 60)) { //DOWN
////        letIn = 10;
////        }else if (Dispatcher.buyerCounter <= 40 + (90 - t) && (t >= 90)) { //DOWN
////        letIn = 10;
////        } else continue;