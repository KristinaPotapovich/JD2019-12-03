package by.it.shpakovskiy.jd02_03;

import java.util.LinkedList;

class Basket {
    private LinkedList<Product> goods;

    public Basket() {
        goods = new LinkedList<>();
    }

    public void putGoodsToTheBasket(Product product) {
        goods.add(product);
    }

    public Product getProduct() {
        return goods.pollLast();
    }

    public int getSize() {
        return goods.size();
    }
}
