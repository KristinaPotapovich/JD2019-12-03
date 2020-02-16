package by.it.samuseva.jd01_10;

public class Bean {
    @Param(a = 5, b =3)
    public static double sum (int a, int b){
        return a + b;
    }

    @Param(a = 515, b = 623)
    public static double max (int a, int b){
        return (a>=b)?a:b;
    }

    public double min (int a, int b){
        return (a<=b)?a:b;
    }

    @Param(a = 56, b = 38)
    public double avg (int a, int b){
        return (a + b)/2.0;
    }

}
