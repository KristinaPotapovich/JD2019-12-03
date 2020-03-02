package by.it.kuzmichalex.jd02_01;

class Buyer extends Thread implements iBuyer, iUseBucket {
    private boolean bUseBucket;
    private boolean bPensioneer;

    /**
     * Конструктор. Присваиваем родительским методом потоку имя Buyer_ + номер
     * 1/4 покупателей - пенсионеры
     * Корзинные покупатели выбирают от 1 до 4 товаров
     */
    public Buyer(int nBuyer) {
        super(Integer.toString(nBuyer));
        bPensioneer = (TimeHelper.getRandom(1, 4) == 4);
    }

    /**
     * Процесс совершения покупки
     */
    @Override
    public void run() {
        Dispatcher.nCountOfBuyers++;
        enterToMarket();
        takeBucket();
        chooseGoods();
        goOut();
        Dispatcher.nCountOfBuyers--;
    }

    /**
     * Заход покупателя в магазин. Мгновенно
     */
    @Override
    public void enterToMarket() {
        System.out.println(this + "Enter");
    }

    /**
     * Выбор товара. От 0.5 до 2 секунд на один товар
     * Выбирается от 1 до 4 товаров
     */
    @Override
    public void chooseGoods() {
        if (!bUseBucket) return;
        int nOfGoods = TimeHelper.getRandom(1, 4);
        for (int i = 1; i <= nOfGoods; i++) {
            System.out.println(this + "choosing (" + i + "/" + nOfGoods + ")...");
            sleep(500, 2000);
            putGoodsToBucket();
        }
    }

    /**
     * Выход из магазина. Мгновенно.
     */
    @Override
    public void goOut() {
        System.out.println(this + "Leave");
    }

    /**
     * Использование корзинки
     */
    @Override
    public void takeBucket() {
        bUseBucket = true;
        sleep(0, 0);
        System.out.println(this + "take Bucket");
    }

    /**
     * Набор товаров в корзинку
     */
    @Override
    public void putGoodsToBucket() {
        if (!bUseBucket) return;
        System.out.println(this + "put " + Goods.getSomeGood() + " to Bucket ");
    }

    @Override
    public String toString() {
        return (bPensioneer ? "Buyer_P   " :
                "Buyer     ") + this.getName() + "     :";
    }

    /**
     * засыпатель
     * Время сна для пенсионеров увеличивается в 1.5 раза.
     */
    public void sleep(int nMinimum, int nMaximum) {
        int nTimeOut = TimeHelper.getRandom(nMinimum, nMaximum);
        if (bPensioneer) {
            nTimeOut = (int) ((double) nTimeOut * TimeHelper.getSlowSpeed());
        }
        TimeHelper.sleep(nTimeOut);
    }

}
