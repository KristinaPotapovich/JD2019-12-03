package by.it.filipovich.jd01_10;

public class Bean {

    @Param(a=3, b=5)
    public static double sum(int a, int b){
        return (a+b)*1.0;
    }
    @Param(a=4, b=6)
    public static double max(int a, int b){
        return (Math.max(a,b))*1.0;
    }
    @Param(a=5, b=4)
    public double min(int a, int b){
        return (Math.min(a,b))*1.0;
    }

    public double avg(int a, int b){
        return (a+b)/2.0;
    }
}
