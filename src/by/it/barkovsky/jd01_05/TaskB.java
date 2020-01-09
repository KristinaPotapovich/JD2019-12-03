package by.it.barkovsky.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        double a;
        for (a = 0; a <= 2 ; a+=0.2) {
            double y=0;
            for (int x = 1; x <=6 ; x++) {
                y=y+(pow(7,a)-cos(x));
            }
            System.out.println(y);
        }
    }

    private static void step5() {
        double a=0;
        boolean no;
        for (double x= -5.5; x < 2; x+=0.5) {
            no=true;
            if((x/2>-2.0) && (x/2)<=-1.0){
                a= log10(abs(sin(x*x)+2.74));
                no=false;
            }
            else if ((x/2>-1.0) && (x/2)<0.2){
                a= log10(abs(cos(x*x)+2.74));
                no=false;
            }
            else if(x/2==0.2){
                a= log10(abs(1/tan(x*x)+2.74));
                no=false;
            }
            if (!no){
                System.out.println("При x/2="+(x/2.0)+" a = "+a);
            } else {
                System.out.println("При x/2="+(x/2.0)+" вычисления не определены");
            }
        }
    }
}