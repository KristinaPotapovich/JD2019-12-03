package by.it.shpakovskiy.jd02_01;

import java.util.LinkedList;

class Basket {
    private LinkedList<String> goods;

    public Basket() {
        goods = new LinkedList<>();
    }

    public void putGoodsToTheBasket(String product) {
        goods.add(product);
    }

    public void clearBasket(){
        goods.clear();
    }

    public int getSize() {
        return goods.size();
    }
}
