package by.it.samuseva.jd01_08.oop;

import javax.xml.crypto.Data;

class Comedy extends DomesticFilm  {
    private String name;
    public Comedy() {
    }

    public Comedy(String name) {
        super(name);
    }

    public Comedy(String name, int data) {
        super(name, data);
    }

    @Override
    public void ScreenTime () {
        System.out.println("Полнометражный фильм");
    }
}

