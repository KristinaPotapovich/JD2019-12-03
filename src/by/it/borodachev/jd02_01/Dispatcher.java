package by.it.borodachev.jd02_01;

import java.util.HashMap;

class Dispatcher {

    static final int K_SPEED=10000;
    static int countBuyer=0;
    static synchronized  void buyerIN() {countBuyer++;}
    static synchronized  void buyerOUT() {countBuyer--;}
    static synchronized  int buyerCount() {return countBuyer;}

}
