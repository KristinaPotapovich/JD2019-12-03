package by.it.potapovich.jd02_01;

import java.util.LinkedHashMap;
import java.util.Map;

public class Good {
    private String nameGood;



    public Good (){

    }

    public Good(String nameGood) {
        this.nameGood = nameGood;
    }

    public String getNameGood() {
        return nameGood;
    }

    public void setNameGood(String nameGood) {
        this.nameGood = nameGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        return nameGood != null ? nameGood.equals(good.nameGood) : good.nameGood == null;
    }

    @Override
    public int hashCode() {
        return nameGood != null ? nameGood.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Товар " + nameGood + '\''
                ;
    }
}
