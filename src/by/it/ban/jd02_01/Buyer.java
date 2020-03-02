package by.it.ban.jd02_01;

import java.util.*;
import java.util.Map.Entry;

class Buyer extends Thread implements IBuyer, IUseBacket {
    boolean pensioner;
    double speed;
    Map<String, Double> backet = new HashMap<>();

    public Buyer(int number) {
        super("Покупатель N"+number+" ");
        Dispatcher.countBuyer++;
    }

    public Buyer(int number, boolean pensioner) {
        super("Покупатель N"+number+" ");
        this.pensioner=pensioner;
        if(pensioner)
            this.speed=1.5;
        else
            this.speed=1.0;
//        System.out.println("pens="+this.pensioner+" speed="+this.speed);
        Dispatcher.countBuyer++;
    }

    @Override
    public void run() {
        enterTheMarket();
        takeBacket();
        for (int i = 1; i <=Helper.random(4) ; i++) {
            putGoodsToBacket();
        }
        chooseGoods();
        exitTheMarket();
    }

    @Override
    public void enterTheMarket() {
        if (this.pensioner)
            System.out.println(this+"вошел в магазин (Пенсионер)");
        else
            System.out.println(this+"вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"приступил к выбору товара");
        Helper.sleep((int) (Helper.random(500,2000)*this.speed));
        System.out.println(this+"окончил выбор товара");
    }

    @Override
    public void exitTheMarket() {
        System.out.println(this+"вышел из магазина");
        Dispatcher.countBuyer--;
    }


    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        System.out.println(this+"взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep((int) (Helper.random(500,2000)*this.speed));
        int numberOfGoods = Helper.random(1, 4);

        Map<String, Double> listOfGoods = Good.getListOfGoods();
        Set<String> keySets = listOfGoods.keySet();

        ArrayList<String> listOfKeys = new ArrayList<>(keySets);

        for (int i = 0; i < numberOfGoods; i++) {
            int indexRandom = Helper.random(0, listOfKeys.size() - 1);
            String chosenGood = listOfKeys.remove(indexRandom);
            Double prise = listOfGoods.get(chosenGood);
            this.backet.put(chosenGood, prise);
            System.out.println(this +"положил в корзину: " + chosenGood + " " + prise);
        }
    }
}
