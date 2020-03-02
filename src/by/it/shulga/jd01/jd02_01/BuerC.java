package by.it.shulga.jd01.jd02_01;

class BuyerC extends BuyerB{
    boolean pensioner=false;
    public BuyerC(int number) {
        super(number);
        if (Helper.random(1,4)==1)
        {
            pensioner=true;
            setName(getName()+"pensioner ");
        }
    }
    @Override
    public void chooseGoods() {
        int countGoods = Helper.random(1,4);

        System.out.println(this + "started choosing by goods");
        for (int i = 1; i <= countGoods; i++) {
            int timeout;
            if (pensioner) timeout= Helper.random(650, 3000);
            else  timeout= Helper.random(500, 2000);

            Helper.sleep(timeout);
            putGoodsToBacket();
        }
        System.out.println(this + "finshed choosing by goods");
    }
}