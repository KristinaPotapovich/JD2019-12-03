package by.it.filipovich.jd02_03;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waitingFlag = false;

    void setWaitingFlag(boolean waitingFlag) {
        this.waitingFlag = waitingFlag;
    }

    Buyer(int number){
        super("Buyer № "+number);
        Dispatcher.buyerEnter();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose the goods");
        Helper.sleep(Helper.random(500, 2000));
        System.out.println(this + " finished choosing the goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to Queue");
        synchronized (this) {
            QueueBuyer.addBuyer(this);
            this.waitingFlag=true;
            while (this.waitingFlag)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }


    @Override
    public void goOut() {
        System.out.println(this + " went out from Market");
        Dispatcher.buyerLeave();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" take the basket.");
        Helper.sleep(Helper.random(500,2000));
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this+" put the Goods into the basket");
        synchronized (this) {
            putTo();
        }
        Helper.sleep(Helper.random(500,2000));

    }

    private void putTo() {
        int numberOfGoods = Helper.random(1,4);
        StringBuilder sb = new StringBuilder();
        List<String> namesOfGoods = new ArrayList<>(Goods.getListOfGoods().keySet());
        for (int i = 1; i <= numberOfGoods; i++) {
            String randomGood = namesOfGoods.get(new Random().nextInt(namesOfGoods.size()));
            Double priceOfGood = Goods.getListOfGoods().get(randomGood);
            sb.append(randomGood).append(" (").append(priceOfGood).append(" USD)");
            if(i == numberOfGoods)
                sb.append(".");
            else sb.append(",");
        }
        System.out.println(this + " bought the next goods:");
        System.out.println(sb.toString());
    }
}
