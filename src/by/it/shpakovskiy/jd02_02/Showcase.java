package by.it.shpakovskiy.jd02_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Showcase {
    private Map<Product, Double> goods;

    public Showcase() {
        this.goods = new HashMap<>();
        goods.put(new Product("meat"), 15.80);
        goods.put(new Product("lard"), 10.38);
        goods.put(new Product("sausage"), 7.62);
        goods.put(new Product("mayonnaise"), 2.25);
        goods.put(new Product("bread"), 1.13);
        goods.put(new Product("milk"), 2.10);
        goods.put(new Product("potatoes"), 5.0);
        goods.put(new Product("draniki"), 8.50);
        goods.put(new Product("fried potatoes"), 5.20);
        goods.put(new Product("bananas"), 2.15);
        goods.put(new Product("apples"), 1.90);
        goods.put(new Product("persimmons"), 2.87);
    }

    public Product getSomeProduct(){
        int num = Helper.getRandom(0, goods.size() - 1);
        Iterator<Product> it = goods.keySet().iterator();
        for (int i = 0; i < num; i++) {
            it.next();
        }
        return it.next();
    }

    public double getPrice(Product product){
        for (Map.Entry<Product,Double> entry:goods.entrySet()){
            if (entry.getKey().equals(product)){
                return entry.getValue();
            }
        }
        return 0;
    }
}
