package by.it.filipovich.jd01_10;

public class Runner {
    public static void main(String[] args) {

    }

    @Param(a=5,b=6)
    public double avg(int a, int b){
        return (double) (a+b)/2;
    }
}
