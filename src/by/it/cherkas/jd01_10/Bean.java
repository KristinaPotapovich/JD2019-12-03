package by.it.cherkas.jd01_10;

public class Bean {
    static double sum(int a, int b){
        return a+b;
    }
    @Param(a=13, b=15)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }
    @Param(a=5, b=25)
     double max(int a, int b){
        return a>b?a:b;
    }
    @Param(a=4, b=6)
     double min(int a, int b){
        return a<b?a:b;
    }

}
