package by.it.samuseva.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();

    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow(x*x+PI/6, 5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
        System.out.println("При а = 756.13 и х = 0.3 значение z = " + z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a+b, 2))-cbrt(a+1.5)+a*pow(b,5)-(b/log(a*a));
        System.out.println("При а = 1.21 и х = 0.371 значение y = " + y);
    }

    private static void step3() {
        double x = 12.1;
        double a = -5;
        int i = 0;
        double[] f = new double[(int) (18/3.75)];
        while (a <= 12) {
            f[i]=pow(E, a*x)-3.45*a;
            System.out.printf("При а = %-5.4f  f = %-10.4f %n", a, f[i]);
            i++;
            a=a+3.75;
        }

    }
}
