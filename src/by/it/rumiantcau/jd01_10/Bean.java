package by.it.rumiantcau.jd01_10;

public class Bean {
    public static double sum(int a, int b){
    return a + b;
    }
    @Param(a=234, b=555)
    public double avg(int a, int b){
        return (a+b) / 2.0;
    }
    @Param(a=25, b=26)
    public double max(int a, int b){
        return a > b ? a : b;
    }
    @Param(a=2, b=5)
       public static double min(int a, int b){
           return a > b ? b : a;
    }




  /*  public void main(String[] args) {
    int a = 6, b =4;
        System.out.println(sum(a,b));
        System.out.println(min(a,b));
        System.out.println(max(a,b));
        System.out.println(avg(a,b));

    }*/
}
