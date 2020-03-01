package by.it.ban.jd02_02;

import java.util.Formatter;
import java.util.Map;
import java.util.Random;

class Helper {

    private static Random generator=new Random(System.nanoTime());
    static final String SPACE_BUFFER="                   ";

    static void sleep(int timiout){

        try {
            Thread.sleep(timiout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    static void cashierSleep(int timiout) throws InterruptedException {

        Thread.sleep(timiout/ Dispatcher.K_SPEED);

    }

    static int random(int min, int max){
        return min+generator.nextInt(max-min+1);
    }

    static int random(int max){
        return generator.nextInt(max+1);
    }


    static void printChek(Cashier cashier, Buyer buyer) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <cashier.getNum() ; i++) {
            buffer.append(SPACE_BUFFER);
        }
        synchronized (System.out){
            System.out.println(new StringBuffer().append(buffer).append(cashier));
            double sum=0.0;
            for (Map.Entry<String, Double> entry : buyer.backet.entrySet()) {
                sum+=entry.getValue();
                System.out.println(new StringBuffer().append(buffer).append(String.format("%s %6.2f",entry.getKey(),entry.getValue())));
            }
            System.out.println(new StringBuffer().append(buffer).append(String.format("Сумма: %6.2f",Math.round(sum*100.0)/100.0)));
            printAllCash();
        }

    }

    private static void printAllCash() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <7 ; i++) {
            buffer.append(SPACE_BUFFER);
        }
        double sum=Dispatcher.getAllCash();
        System.out.println(new StringBuffer().append(buffer).append(String.format("Общая касса : %6.2f",sum)));
    }

    static void printQueue(){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <6 ; i++) {
            buffer.append(SPACE_BUFFER);
        }
        int countBuyer=QueueBuyer.getLength();
        int countPens=QueuePensioneer.getLength();
        System.out.println(buffer+"Покупателей в очереди: "+(countBuyer+countPens)+"("+countBuyer+"+"+countPens+")");
    }
}
