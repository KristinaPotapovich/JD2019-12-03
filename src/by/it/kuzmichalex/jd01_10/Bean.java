package by.it.kuzmichalex.jd01_10;

public class Bean {

    @Param(a=1,b=2)
    double sum(int a, int b){
        //System.out.println("sum" + a + " "+ b);
        return a+b;
    }

    @Param(a=3,b=4)
    double max(int a, int b){
        //System.out.println("max" + a + " "+ b);
        return a>b?a:b;
    }

    @Param(a=5,b=6)
    static double min(int a, int b){
        //System.out.println("min" + a + " "+ b);
        return a<b?a:b;
    }

    static double avg(int a, int b){
        //System.out.println("avg" + a + " "+ b);
        return (a+b)/2.0;
    }
}
