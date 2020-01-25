package by.it.samuseva.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        DomesticFilm  film;
        DomesticFilm film1;
        film = new Comedy("Беларусь");
        film1 = new Comedy("Россия" , 2002);
        film1.ScreenTime();
    }
}
