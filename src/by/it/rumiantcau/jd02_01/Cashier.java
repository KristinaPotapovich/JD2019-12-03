package by.it.rumiantcau.jd02_01;

public class Cashier implements Runnable{

    private String name;

    public Cashier(int number) {
        name="--Кассир № "+number+" ";
    }

    @Override
    public void run() {
        System.out.println(this+"открыта.");
        while (!Dispatcher.marketClosed()){
            Buyer buyer = QueueBuyer.extract();
            if (buyer!=null){
                System.out.println(this+"Начало обслуживания "+buyer);
                int timeout = Helper.random(2000, 5000);

                System.out.println("Все товары покупателя " + buyer + Basket.basket.get(buyer));
               // System.out.println("Сумма покупок покупателя " + buyer + Basket.sumBasket(buyer));
               double sum = 0;
                String[] goodsString = Basket.basket.get(buyer).split(",");
                for (int i = 0; i < goodsString.length - 1; i++) {
                    if(goodsString[i] != null && goodsString[i].length() > 0)
                        sum+=Double.valueOf(goodsString[i].replaceAll("[A-Za-zА-Яа-я]", "").
                                replace(" ", ""));
                }
                System.out.println("Сумма чека покупателя " + buyer + "составила " + sum);
                // System.out.println("summmmmmaaaaa " + sum);*/
                //         System.out.println("summmmmmaaaaa " + Basket.sumBasket(buyer, Buyer.basket));
                Helper.sleep(timeout);
                System.out.println(this+"Конец обслуживания "+buyer);


                synchronized (buyer){
                    buyer.notify();
                }
            } else {
                //wait for this??
                Helper.sleep(1);
            }
        }
        System.out.println(this+"closed.");

    }



    @Override
    public String toString() {
        return name;
    }
}
