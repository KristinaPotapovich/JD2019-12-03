package by.it.plugatar.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.14);
       // Var v2 = new Vector(6.28);
        System.out.println(v1);
       // System.out.println(v2);
        double[] vector = {1, 2, 3};
        Vector vec = new Vector(vector);
        System.out.println(vec);
        Vector vec2 = new Vector(new double[]{4,5,6});
        System.out.println(vec2);
        Vector vec3 = new Vector("{1.0, 2.0, 4.0");
        System.out.println(vec3);

        double[][] arr = {{1, 2}, {3,4}};
        Matrix mat = new Matrix(arr);
        System.out.println(mat);
        Matrix mat2 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        System.out.println(mat2);
        String str = "{{1.0, 2.0}, {3.0, 4.0}}";
        Matrix mat3 = new Matrix(str);
        System.out.println(mat3);
    }
}
