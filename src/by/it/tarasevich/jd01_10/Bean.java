package by.it.tarasevich.jd01_10;

public class Bean {
    @Param(a = 2, b = 5)
    public static double sum (int a, int b){
        double sum = a + b;
      return sum;
    }
    @Param(a = 2, b = 5)
    public double max (int a, int b){
        double max = a > b ? a : b;
        return max;
    }
    @Param(a = 2, b = 5)
    public double min (int a, int b){
        double min = a < b ? a : b;
        return min;
    }
    public static double avg (int a, int b){
        double avg = (a + b)/2.0;
        return avg;
    }

}
