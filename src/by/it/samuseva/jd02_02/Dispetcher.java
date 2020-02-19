package by.it.samuseva.jd02_02;

class Dispetcher {
    static  final  int K_SPEED = 100;


    private static final Object monitor = new Object();

    private static final int PLAN = 20;
    private static final int countCasher = 2;

    private static int countBuyer = 0;
    private static int enterBayer = 0;

    public static int getCountCasher() {
        return countCasher;
    }

    static void enterBayer(){
        synchronized (monitor){
            enterBayer++;
            countBuyer++;
        }
    }
    static void leftBayer(){
        synchronized (monitor){
            countBuyer--;
        }
    }

    static boolean marketOpened(){
        synchronized (monitor) {
            return enterBayer < PLAN;
        }
    }
    static boolean marketClosed(){
        synchronized (monitor) {
            return PLAN == enterBayer && countBuyer == 0;
        }
    }


}
