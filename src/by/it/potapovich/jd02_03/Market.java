package by.it.potapovich.jd02_03;

import by.it.samuseva.jd01_13.Help;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class Market {

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

        ConcurrentHashMap<Good, Integer> goods = new ConcurrentHashMap<>(15);
        goods.put(toiletPaper, 5);
        goods.put(cucumber, 2);
        goods.put(bread, 1);
        goods.put(fruits, 15);
        goods.put(salt, 1);
        goods.put(sugar, 2);
        goods.put(potato, 3);
        goods.put(tomato, 2);
        goods.put(cheese, 4);
        goods.put(chicken, 25);
        Backet backet = new Backet();


        System.out.println("---------- Market opened");
        CopyOnWriteArrayList <Thread> threads = new CopyOnWriteArrayList<Thread>();

        int number = 0;

        if (Dispatcher.marketOpened()) {
            Buyer buyer = new Buyer(++number, goods, backet);
            buyer.start();
        }

        int numberOfCashiers = 0;
        Cashier cashier = new Cashier(++numberOfCashiers);
        Thread thread = new Thread(cashier);
        threads.add(thread);
        thread.start();

        while (Dispatcher.marketOpened()) {
            Helper.sleep(10000000);
            int count = Helper.random(0, 2);
            for (int i = 0; i <= count; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(++number, goods, backet);
                    buyer.start();
                }
            }
            Helper.sleep(1000);
            Thread newCashier = null;
            if (number > 1 && number % 5 == 1 && numberOfCashiers < 5) {
                newCashier = new Thread(new Cashier(++numberOfCashiers));
                threads.add(newCashier);
                newCashier.start();
            }
            if (number != 1 && numberOfCashiers != 1 && ((numberOfCashiers * 5) - number == 1)) {
                Thread removedCashier = threads.remove(threads.size() - 1);
                if (!removedCashier.isInterrupted() && removedCashier.isAlive()) {
                    System.out.println("Касса № " + numberOfCashiers + " закрывается");
                    removedCashier.interrupt();
                }
                --numberOfCashiers;
            }

        }
        while (true) {
            if (Dispatcher.marketClosed()) {
                Helper.sleep(100000);
                System.out.println("--------- Market closed");
                break;
            }
        }
    }

}
