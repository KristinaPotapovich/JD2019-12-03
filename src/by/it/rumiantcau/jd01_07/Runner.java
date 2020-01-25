package by.it.rumiantcau.jd01_07;

public class Runner {
    public static void main(String[] args) {
        /*Var v1 = new Scalar(3.14);
        Var v2 = new Vector(new double[]{1.0,2.0,4.0});
        Var v3 = new Matrix(new double[][] {{1.0,2.0}, {3.0,4.0}});
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);*/

       // Var v4 = new Vector(new String("{1.0, 2.0, 6.0}"));
        Matrix mat = new Matrix("{{1, 2, 3}, {4, 5, 6}}");
        System.out.println(mat);
      //  System.out.println(v4);

    }
}
