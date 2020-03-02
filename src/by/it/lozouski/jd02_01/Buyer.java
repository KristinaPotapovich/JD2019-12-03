package by.it.lozouski.jd02_01;

import java.util.*;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private Map<String, Integer> backetWithBoughtGoods = new HashMap<>();
    private boolean pensioner;
    private double speedPerson;


    public Buyer(int idBuyer, boolean pensioner) {
        super("ID покупателя: " + idBuyer + " ");
        if (pensioner) {
            this.pensioner = true;
            this.speedPerson = 1.5;
        } else {
            this.pensioner = false;
            this.speedPerson = 1.0;
        }
        Dispetcher.buyerCounter++;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        if (pensioner) System.out.println(this + "вошел в магазин.");
        else System.out.println(this + "Вошел в магазин.");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "Взял корзинку для покупок.");
        Help.sleep((int) (Help.randomGenerate(500, 2000) * this.speedPerson));
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Начал выбирать товары.");
        Help.sleep((int) (Help.randomGenerate(500, 2000) * this.speedPerson));
    }

    @Override
    public void putGoodsToBacket() {
        Help.sleep((int) (Help.randomGenerate(500, 2000) * this.speedPerson));
        int setOfGoods = Help.randomGenerate(1, 4);
        Object[] keysArray = GoodsInThisMarket.productsForTheBuyer.keySet().toArray();

        for (int product = 1; product <= setOfGoods; product++) {
            Help.sleep((int) (Help.randomGenerate(500, 2000) * this.speedPerson));
            int randomIndex = new Random().nextInt(keysArray.length);
            Integer value = GoodsInThisMarket.productsForTheBuyer.get(keysArray[randomIndex].toString());
            backetWithBoughtGoods.put((String) keysArray[randomIndex], value);
            System.out.println(this + "Выбрал товар: " + keysArray[randomIndex] + " Цена: " + value + "p.");
        }
        System.out.println(this + "Закончил выбирать товары.");

    }

    @Override
    public void goToOut() {
        System.out.println(this + "Вышел из магазина.");
        Dispetcher.buyerCounter--;
    }

    @Override
    public String toString() {
        if (pensioner) return this.getName()+"Пенсионер ";
        else return this.getName();
    }
}
