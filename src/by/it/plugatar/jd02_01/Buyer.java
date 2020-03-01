package by.it.plugatar.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean pensioneer = false;
    private Basket basket = new Basket();

    public Buyer(int number){
        super("Buyer №:"+number);
        Dispatcher.totalBuyersCount++;
        Dispatcher.buyersCount++;
        if (RandomHelper.random(1, 4) == 1) {
            this.pensioneer = true;
            Dispatcher.totalRetiredCount++;
            this.setName(this.getName() + " (pensioneer)");
        }
    }

    @Override
    public void run() {
        super.run();
        enterToMarket();
        takeBacket();
        int quantity = RandomHelper.random(1, 4);
        for (int i = 0; i < quantity; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        goOut();
        Dispatcher.buyersCount--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"Buyer enter to market");
        System.out.flush();
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"Started choosing goods");
        RandomHelper.sleep(500,2000);
        System.out.println(this+"Finished choosing goods");
        System.out.flush();
    }

    @Override
    public void goOut() {
        System.out.println(this+"Go out from the market");
        System.out.flush();
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " took basket");
        RandomHelper.sleep(500,2000);
        System.out.flush();
    }

    @Override
    public void putGoodsToBacket() {
        String goods = RandomHelper.getRandomGoods();
        System.out.println(this + " took " + goods);
        System.out.flush();
        RandomHelper.sleep(500,2000);
        double price = Goods.priceList.get(goods);
        this.basket.goods.put(goods, price);
    }
    /*
    @Override
    String ToString()

     */
}
