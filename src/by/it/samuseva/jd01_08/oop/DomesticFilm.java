package by.it.samuseva.jd01_08.oop;

import javax.xml.crypto.Data;

public abstract class DomesticFilm implements Film {

    private String name;
    private int data;


    public DomesticFilm() {
        System.out.println("Страна производитель и год съемки: неизвестены");
    }

    public DomesticFilm(String name) {
        this.name = name;
        System.out.println("Страна производитель: " + this.name + " Год съемки: неизвестен");
    }


    public DomesticFilm(String name, int data) {
        this.name = name;
        this.data = data;
        System.out.println("Страна производитель: " + this.name + " Год съемки: " + data);
    }
    public abstract void ScreenTime();

}
