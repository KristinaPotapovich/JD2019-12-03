package by.it.ban.jd01_10;

public class Bean {

    @Param(a=2,b=2)
    double sum(int a, int b){
        return a+b;
    }

    @Param(a=40,b=50)
    double max(int a, int b){
        return a>b?a:b;
    }

    @Param(a=44,b=55)
    static double min(int a, int b){
        return a<b?a:b;
    }

    static double avg(int a, int b){
        return (a+b)/2.0;
    }



}
