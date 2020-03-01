package by.it.kuzmichalex.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements iBuyer, iUseBucket {
    private static Semaphore buyersInHallSemaphore;
    private static Semaphore bucketSemaphore;
    private boolean bUseBucket;
    private boolean bPensioner;
    private List<String> items = new ArrayList<>();
    private int buyerTotalAmount = 0;

    /**
     * Конструктор. Присваиваем родительским методом потоку имя Buyer_ + номер
     * 1/4 покупателей - пенсионеры
     * Корзинные покупатели выбирают от 1 до 4 товаров
     */
    public Buyer(int nBuyer ,Semaphore inHall, Semaphore backets) {
        super(Integer.toString(nBuyer));
        buyersInHallSemaphore =inHall;
        bucketSemaphore = backets;
        bPensioner = (TimeHelper.getRandom(1, 4) == 4);
    }

    int getBuyerTotalAmount() {
        return buyerTotalAmount;
    }

    /**
     * Процесс совершения покупки
     */
    @Override
    public void run() {
        takeBucket();
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    /**
     * Заход покупателя в магазин. Только если там менее MAX_BUYERS_IN_HALL
     */
    @Override
    public void enterToMarket() {
        try {
            buyersInHallSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Dispatcher.incBuyersInMarket();
        Dispatcher.incBuyersInHall();
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
            putGoodsToBucket();
            sleep(500, 2000);
        }
    }

    @Override
    public void goToQueue() {
        BuyerQueue.addBuyerToQueue(this);
        Dispatcher.decBuyersInHall();
        buyersInHallSemaphore.release();
        //Будем ждать в очереди, пока не Cashier не устроит Notify
        //Монитором будет сам Buyer. Чтобы его никто не разбудил, пока он не заснул
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Выход из магазина. Мгновенно.
     */
    @Override
    public void goOut() {
        Dispatcher.decBuyersInMarket();
        Dispatcher.incBuyersDone();
        bucketSemaphore.release();
    }

    /**
     * Получение корзинки. Всего корзинок MAX_BUCKETS
     */
    @Override
    public void takeBucket() {
       try {
            bucketSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bUseBucket = true;
    }

    /**
     * Набор товаров в корзинку
     */
    @Override
    public void putGoodsToBucket() {
        if (!bUseBucket) return;
        String someGood = Goods.getSomeGood();
        items.add((someGood));
        buyerTotalAmount += Goods.getPrice(someGood);
    }

    @Override
    public String toString() {
        return (bPensioner ? "Buyer-P " :
                "Buyer ") + this.getName() + " ";
    }

    /**
     * засыпатель
     * Время сна для пенсионеров увеличивается в 1.5 раза.
     */
     void sleep(int nMinimum, int nMaximum) {
        int nTimeOut = TimeHelper.getRandom(nMinimum, nMaximum);
        if (bPensioner) {
            nTimeOut = (int) ((double) nTimeOut * TimeHelper.getSlowSpeed());
        }
        TimeHelper.sleep(nTimeOut);
    }

    boolean isPensioner() {
        return bPensioner;
    }

    /**
     * Проучить текст чека. да, от покупателя кассиру.
     */
    public String getCheck() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Cheque ").append(this).append("\n");
        for (String item : items) {
            sb.append(String.format("* %-15s:%7d *", item, Goods.getPrice(item))).append("\n");
        }
        sb.append(String.format("* %-15s:%7d *","Amount......", buyerTotalAmount)).append("\n");
        sb.append("***************************\n");
        return sb.toString();
    }
}