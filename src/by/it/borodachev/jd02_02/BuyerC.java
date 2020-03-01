package by.it.borodachev.jd02_02;
import java.util.Comparator;
import java.util.Map;

class BuyerC extends BuyerB {
   static boolean pensioner=false;
    public BuyerC(int number) {
        super(number);
        if (Helper.random(1,4)==1)
        {
            pensioner=true;
            setName(getName()+"pensioner ");
        }
    }
    static boolean ispensioner() {return pensioner;}
    @Override
    public void chooseGoods() {
        int countGoods = Helper.random(1,4);

         System.out.println(this + " заполняет корзину");
        for (int i = 1; i <= countGoods; i++) {
            int timeout;
            if (pensioner) timeout= Helper.random(650, 3000);
            else  timeout= Helper.random(500, 2000);

            Helper.sleep(timeout);
            putGoodsToBacket();
        }
        System.out.println(this + " Закончил выбор товара");
    }
    @Override
    public void pay(int numCash) {
        StringBuilder checkStr =new StringBuilder();
        String spaceStr =String.format("%20s"," ");
   // длина колонки 20 символов
        Double sumCheck=Double.valueOf(0);
        for (int i = 1; i < numCash; i++) {
            checkStr.append(spaceStr);
        }
        checkStr.append(String.format("%20s",this));
        for (int i = numCash+1; i <=5; i++) {
            checkStr.append(spaceStr);
        }
        for (Map.Entry<String, Double> money : good.entrySet()) {
            checkStr.append("\n");
            for (int i = 1; i < numCash; i++) {
                checkStr.append(spaceStr);
            }
            checkStr.append(String.format("%20s",money.getKey()+" Цена "+money.getValue()));
            for (int i = numCash+1; i <=5; i++) {
                checkStr.append(spaceStr);
            }
            sumCheck=sumCheck+ money.getValue();
        }

        Dispatcher.addsumBuyers(sumCheck);
        checkStr.append(String.format("%10d", Dispatcher.buyerCount()));
        checkStr.append(String.format("%10.2f", Dispatcher.getsumBuyers()));
        checkStr.append("\n");
        System.out.println(checkStr);
        return ;
    }
}
