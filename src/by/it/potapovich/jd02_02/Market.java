package by.it.potapovich.jd02_02;

import java.util.*;

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

        Map<Good, Integer> goods = new LinkedHashMap<>();
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
        List<Thread> threads = new ArrayList<>(1000);

        int numberOfCashiers = 0;
        Cashier cashier = new Cashier(++numberOfCashiers);
        Thread thread = new Thread(cashier);
        threads.add(thread);
        thread.start();

        while (countBuyers <= 100) {
            Thread.sleep(6000);
            int count = Helper.random(0, 2);
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                new Buyer(countBuyers, goods, backet);
            }
            Thread newCashier = null;
            if (countBuyers > 1 && countBuyers % 5 == 1 && numberOfCashiers < 5) {
                newCashier = new Thread(new Cashier(++numberOfCashiers));
                threads.add(newCashier);
                newCashier.start();
            }
            if (countBuyers != 1 && ((numberOfCashiers * 5) - countBuyers == 1)) {
                Thread removedCashier = threads.remove(threads.size() - 1);
                --numberOfCashiers;
                if (!removedCashier.isInterrupted()) {
                    removedCashier.interrupt();
                }
            }
        }
        System.out.println("--------- Market closed");
    }

}
