package by.it.borodachev.jd02_02;

import java.util.*;

class Dispatcher {
    static final int K_SPEED=10000;
    static int countCashier=0;
    static int countBuyer=0;
    static Double sumBuyers=Double.valueOf(0);
    static final Integer sunc=0;
    static PriorityQueue<IBuyer> buyer2Cash;
    static void initQueue (Comparator T) {buyer2Cash=new PriorityQueue<>(T);}
    static synchronized  void cashierStart() {countCashier++;}
    static synchronized  void cashierStop() {countCashier--;}
    static synchronized  int cashierCount() {return countCashier;}
    static List <Cashier> cashiers=new ArrayList<>();
    static synchronized  void buyerIN() {countBuyer++;}
    static synchronized  void buyerOUT() {countBuyer--;}
    static synchronized  int buyerCount() {return countBuyer;}
    static synchronized  void addsumBuyers(Double paySum) {sumBuyers+=paySum;}
    static synchronized  Double getsumBuyers() {return sumBuyers;}

}
