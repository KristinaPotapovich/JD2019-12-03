package by.it.busel.jd02_02;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {
    boolean isPensioner;

    private double cognitiveDelay;

    private Backet personalBacket = new Backet();

    Buyer(int id) {
        if (id % 4 != 0) this.setName("Buyer №" + id);
        else {
            this.setName("Buyer №" + id + " (a retiree)");
            isPensioner = true;
        }
        cognitiveDelay = !isPensioner ? 1 : 1.5;
        Dispatcher.buyerEntered();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        int numberOfGoodsNeeded = Helper.getRandomIntValue(1, 4);
        for (int i = 0; i < numberOfGoodsNeeded; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " has entered the store.");
    }

    @Override
    public void takeBacket() {
        int millis = (int) (Helper.getRandomIntValue(500, 2000) * cognitiveDelay);
        Helper.sleep(millis);
        System.out.println(this + " has taken a backet.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " has started to choose an item of goods.");
        int millis = (int) (Helper.getRandomIntValue(500, 2000) * cognitiveDelay);
        Helper.sleep(millis);
        Map.Entry<String, Double> itemInHands = personalBacket.chooseAnItemOfGoods();
        System.out.println(this + " has chosen an item of goods \"" + itemInHands.getKey() + "\", which costs "
                + itemInHands.getValue() + " BYN.");
    }

    @Override
    public void putGoodsToBacket() {
        int millis = (int) (Helper.getRandomIntValue(500, 2000) * cognitiveDelay);
        Helper.sleep(millis);
        Map.Entry<String, Double> lastInputtedItem = personalBacket.putChosenItem();
        System.out.println(this + " has put a chosen item of goods \"" + lastInputtedItem.getKey() + "\", which costs "
                + lastInputtedItem.getValue() + " BYN, to the backet.");

    }

    @Override
    public void goToQueue() {
        System.out.println(this + " has made for the sole queue in the shop.");
        SoleQueue.add(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " has made for the shop-exit and has gone out.");
        Dispatcher.buyerLeft();
    }

    Map<String, Double> payOff() {
        return personalBacket.getPersonalGoods();
//        StringBuilder sb = new StringBuilder("\n");
//        sb.append("Goods of ").append(this).append('\n');
//        sb.append(String.format("%2s %-11s %5s%n", "№№", "item", "price"));
//        for (Map.Entry<String, Double> item : personalGoods.entrySet()) {
//            sb.append(String.format("%2d ", ++index)).append(String.format("%-12s", item.getKey()))
//                    .append(String.format("%-5.2f BYN", item.getValue())).append('\n');
//            total = total + item.getValue();
//        }
//        sb.append(String.format("%14s %-5.2f %s%n", "Total:", total, "BYN"));
//        System.out.println(sb.toString());
    }
}
