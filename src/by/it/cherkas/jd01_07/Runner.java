package by.it.cherkas.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var var1= new Scalar(3.1415);
        System.out.println(var1.toString());
        Var var2= new Vector(new double[]{1,2,4});
        System.out.println(var2.toString());
    }
}
