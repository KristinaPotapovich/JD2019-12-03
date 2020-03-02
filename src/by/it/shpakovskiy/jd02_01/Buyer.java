package by.it.shpakovskiy.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean pensioner;

    private BulbaStore store;
    Basket basket;

    public Buyer(int number, BulbaStore store) {
        super("Buyer-" + number);
        this.store = store;
        pensioner = Math.random() < 0.25;
        start();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market. Count buyer: " + store.enter(this));
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " waits basket");
        while (true) {
            basket = store.getBasket();
            if (basket != null) {
                break;
            }
            yield();
        }
        System.out.println(this + " take basket");
        sleepBuyer(500, 2000);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing by goods");
        sleepBuyer(500, 2000);
        System.out.println(this + " finished choosing by goods");
    }

    @Override
    public void putGoodsToBasket() {
        int n = Helper.getRandom(1, 4);
        for (int i = 0; i < n; i++) {
            String goods = store.getSomeGoods();
            basket.putGoodsToTheBasket(goods);
            System.out.println(this + " put " + goods + " to the basket. Total goods count in basket: " + basket.getSize());
            sleepBuyer(125, 500);
        }
    }

    @Override
    public void goToOut() {
        basket.clearBasket();
        store.returnBasket(basket);
        System.out.println(this + " go out. Left: " + store.leave(this));
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOut();
    }

    @Override
    public String toString() {
        return (pensioner ? "P " : "  ") + this.getName();
    }

    private void sleepBuyer(int minMillis, int maxMillis) {
        int millis = Helper.getRandom(minMillis, maxMillis);
        if (pensioner) millis = (int) (millis * 1.5);
        Helper.sleep(millis);
    }
}
