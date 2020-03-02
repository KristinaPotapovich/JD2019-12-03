package by.it.filipovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        functionFour();
        functionFive();
    }

    private static void functionFive() {
        double beta;
        double delta = 0.5;
        double leftOfX = -6;
        double rightOfX = 2;
        double startX = leftOfX+delta;

        for (double x = startX; x < rightOfX; x = x + delta) {
            if(x/2 > -2 && x/2 < -1){
                beta = sin(x*x);
            printAlfa(beta, x);
            }
            else if (x/2 > -1 && x/2 < 0.2){
                beta = cos(x*x);
                printAlfa(beta, x);
            }
            else if (x/2 == 0.2){
                beta = 1/tan(x*x);
                printAlfa(beta,x);
            }
            else
                System.out.println("При х/2 = "+x/2+" функция не рассчитывается");

        }
    }

    private static void printAlfa(double beta, double x) {
        double alfa = log10(abs(beta + 2.74));
        System.out.println("При x/2 = "+ x/2 + ", alfa = " + alfa);
    }

    private static void functionFour() {
        double delta = 0.2;
        double y = 0;
        for (double a = 0; a <= 2; a = a + delta) {
            for(int x = 1; x <= 6; x++){
                y = y+pow(7,a) - cos(x);
            }
            System.out.println("При а ="+a+", у = "+ y);
            y = 0;
        }
    }
}
