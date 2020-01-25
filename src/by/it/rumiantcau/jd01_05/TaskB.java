package by.it.rumiantcau.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
         step1();
        step2();
    }

      private static void step1() {
    double a = 0;
    double x = 0;
    double y = 0;

    while ((a >= 0) && (a <= 2)){
        y = 0;
        for (x = 1; x <= 6; x++) {
            y += (pow(7, a) - cos(x));
        }
        System.out.println("pri a = " + a + " y = " + y);
        a+=0.2;
    }
    }
    private static void step2() {
        double x = -5.5;
        double x2;
        double a;
        double b = 0;
 //инкреминация икса до верхнего порога входа
        while (x / 2 <= -2) {
            System.out.println("x / 2 = " + x / 2 + " вычисления не определены ");
            x += 0.5;
        }
        while (x < 2) {
            x2 = x / 2;
            if((x2 > -2) && (x2 <= -1)) b = sin (x * x);
            if ((x2 > -1) && (x2 < 0.2)) b = cos(x * x);
            if (x2 == 0.2) b = 1 / tan(x * x);
            //вывод неопределенного значения после преодоления нижнего порога входа
            if (x2 > 0) System.out.println("x / 2 = " + x / 2 + " вычисления не определены ");
            else {
            a = log10(abs(b+2.74));
            System.out.println("x / 2 = " + x2 + " | a = " + a);}
            x +=0.5;
        }












    }


}
