package by.it.lozouski.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar a1 = new Scalar(3.1415);
        Var a2 = new Scalar(a1);
        Var a3 = new Scalar("3.1415");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        Vector b1 = new Vector(new double[]{1.0, 2.0, 4.0});
        Var b2 = new Vector(b1);
        Var b3 = new Vector("{1,2,4}");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        Matrix c1 = new Matrix(new double[][]{{5, 2, 9, 7, 4}, {2, 4, 1, 9}});
        Var c2 = new Matrix(c1);
        Var c3 = new Matrix("{{5,2,9,7,4},{2,4,1,9}}");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
