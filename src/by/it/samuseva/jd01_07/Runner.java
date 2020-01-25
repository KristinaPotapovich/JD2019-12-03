package by.it.samuseva.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar x = new Scalar(3.14);
        Scalar x1 = new Scalar(x);
        Scalar x2 = new Scalar("3.14");
        System.out.println(x + "\n" + x1 + "\n" + x2);

        double[] vector = {1.0, 2.0, 3.0, 4.0};
        Vector v = new Vector(vector);
        Vector v1 = new Vector(v);
        Vector v2 = new Vector("{1,2,3,4}");
        System.out.println(v + "\n" + v1 + "\n" + v2);

        double[][] matrix = {{1,2},{3,4}};
        Matrix m = new Matrix(matrix);
        Matrix m1 = new Matrix(m);
        Matrix m2 = new Matrix("{{1,2},{3,4}}");
        System.out.println(m + "\n" + m1 + "\n" + m2);

    }
}
