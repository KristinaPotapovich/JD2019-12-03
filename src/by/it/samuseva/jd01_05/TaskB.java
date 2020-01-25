package by.it.samuseva.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step1() {
        double a = 0;
        int j = 0;
        double[] y = new double[(int) (2/0.2+1)];
         while (a<=2){
             double sum = 0;
             for (int i = 0; i <=6 ; i++) {
                 sum = sum+ pow(7, a)-cos(i);
             }
             y[j] = sum;
             System.out.printf(" При a = %-3.2f  y = %g %n",a,y[j]);
             a=a+0.2;
             j++;
         }
    }

    private static void step2() {
        double x = -6;
        double alfa=0;
        double beta=0;
        while (x<2){
            if (x==-6) {
                x=x+0.5;
            }
            if (((x>-6)&&(x/2<=-2))||(x/2>0.2)&&(x<2)){
                System.out.println("При х/2 = " + x/2 + "   вычесления не определены");
            }
            if ((x/2>-2)&&(x/2<=-1)) {
                beta = sin(x*x);
                alfa = log10(abs(beta+2.74));
                System.out.printf("При х/2 = %3.2f   a = %-8f %n", x/2, alfa);
            }
            if ((x/2>-1)&&(x/2<0.2)) {
                beta = cos(x*x);
                alfa = log10(abs(beta)+2.74);
                System.out.printf("При х/2 = %3.2f   a = %-8f %n", x/2, alfa);
             //   x=x+0.5;
            }
            if ((x/2==0.2)) {
                beta = 1/tan(x*x);
                alfa = log10(abs(beta +2.74));
                System.out.printf("При х/2 = %3.2f   a = %-8f %n", x/2, alfa);
             //   x=x+0.5;

            }
           /* if (x<0.2) {
                System.out.println("При х/2 = " + x/2 + "   вычесления не определены");
              //  x=x+0.5;

            }*/
            x=x+0.5;
        }

    }
}
