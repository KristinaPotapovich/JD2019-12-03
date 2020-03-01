package by.it.filipovich.jd02_02;

public class Dispatcher {
    static final int K_SPEED=1000;
    static final int PLAN=100;

    private final static Object monitor = new Object();

    private volatile static int enterBuyer=0;
    private volatile static  int count=0;


    static boolean marketIsOpened(){
        synchronized (monitor) { //volatile ???
            return enterBuyer < PLAN;
        }
    }

    static boolean marketIsClosed(){
        synchronized (monitor) {
            return enterBuyer == PLAN && count==0;
        }
    }

    static void buyerEnter(){
        synchronized (monitor) {
            enterBuyer++;
            count++;
        }
    }

    static void buyerLeave(){
        synchronized (monitor) {
            count--;
        }
    }
}
