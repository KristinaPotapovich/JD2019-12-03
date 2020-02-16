package by.it.tarasevich.jd01_07;

public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.14);
        Var v = new Vector("{1,2,4}");
        System.out.println(v);
       // Var v3 = new Vector("1, 2, 3");
        //   Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");


    }
}