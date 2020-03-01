package by.it.potapovich.jd02_01;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class Market {
    private static int countBuyers = 0;


    public static void main(String[] args) throws InterruptedException {
        Good toiletPaper = new Good("Туалетная бумага");
        Good cucumber = new Good("Овощи");
        Good bread = new Good("Хлеб");
        Good fruits = new Good("Фрукты");
        Good salt = new Good("Соль");
        Good sugar = new Good("Сахар");
        Good potato = new Good("Булочки");
        Good tomato = new Good("Кетчуп");
        Good cheese = new Good("Сыр");
        Good chicken = new Good("Мясо");

        Map<Good,Integer> goods = new LinkedHashMap<>();
        goods.put(toiletPaper,5);
        goods.put(cucumber,2);
        goods.put(bread,1);
        goods.put(fruits,15);
        goods.put(salt,1);
        goods.put(sugar,2);
        goods.put(potato,3);
        goods.put(tomato,2);
        goods.put(cheese,4);
        goods.put(chicken,25);
        Backet backet = new Backet();



        System.out.println("---------- Market opened");
        Queue <Buyer> queue = new ArrayDeque<>();
        while (countBuyers <= 120){
            Thread.sleep(1000);
            int count = Helper.random(0,2);
            for (int i =0; i <= count; i ++){
                countBuyers++;
                if (countBuyers < 120){
                    Buyer buyer = new Buyer(countBuyers,  goods, backet);
                    queue.add(buyer);

                }
            }for (Buyer buyer: queue) {
                buyer.join();
            }
        }System.out.println("--------- Market closed");
    }

}
