package by.it.busel.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Shop {

    private static List<Buyer> buyersThreads = new ArrayList<>(1000);
    private static int buyerId = 0;

    private static void informAboutOpening(String mainThreadName) {
        System.out.println("<<<<< The \"" + mainThreadName + "\" has opened >>>>>");
    }

    private static int getNumberOfBuyersToEnter(int second, int currentBuyersNumber) {
        int numberOfBuyersToEnter;
        int simplifiedTimeUnit = second % 60;
        if (simplifiedTimeUnit < 30) {
            numberOfBuyersToEnter = simplifiedTimeUnit + 9 - currentBuyersNumber;
        } else {
            numberOfBuyersToEnter = 40 + (23 - simplifiedTimeUnit) - currentBuyersNumber;
        }
        if (numberOfBuyersToEnter < 0) numberOfBuyersToEnter = 0;
        return numberOfBuyersToEnter;
    }

    private static void letBuyersGetIn(int numberOfBuyersToEnter) {
        for (int i = 0; i < numberOfBuyersToEnter; i++) {
            if (Dispatcher.shopDoorsAreStillOpened()) {
                Buyer buyer = new Buyer(++buyerId);
                buyersThreads.add(buyer);
                buyer.start();
            }
        }
    }

    private static void informAboutDoorsClosure(String mainThreadName) {
        System.out.println("===== The dispatcher of the \"" + mainThreadName + "\" has shut the doors =====");
        System.out.println("===== A number of Buyers remaining inside the store is " + Dispatcher.getBuyersNumberInside() + " ======");
    }

    private static void executeUntilAllBuyersFinished() {
        for (Buyer buyer : buyersThreads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void informAboutClosureOfStore(String mainThreadName) {
        System.out.println("<<<<< The \"" + mainThreadName + "\" has closed >>>>>");
        System.out.println("===== A number of Buyers remaining inside the store is " + Dispatcher.getBuyersNumberInside() + " ======");
    }

    public static void main(String[] args) {
        String mainThreadName = Shop.class.getSimpleName();
        informAboutOpening(mainThreadName);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.start();
        int second = 0;
        while (Dispatcher.shopDoorsAreStillOpened()) {
            int currentBuyersNumber = Dispatcher.getBuyersNumberInside();
            int numberOfBuyersToEnter = getNumberOfBuyersToEnter(second, currentBuyersNumber);
            System.out.println("Current second: " + second++ + "; Buyers inside the Shop: " + currentBuyersNumber
                    + "; Buyers to enter: " + numberOfBuyersToEnter);
            letBuyersGetIn(numberOfBuyersToEnter);
            Helper.sleep(1000);
        }
        informAboutDoorsClosure(mainThreadName);
        try {
            dispatcher.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executeUntilAllBuyersFinished();
        informAboutClosureOfStore(mainThreadName);
    }
}