package by.it.barkovsky.jd01_07;

import by.it.barkovsky.jd01_07.Scalar;
import by.it.barkovsky.jd01_07.Var;
import by.it.barkovsky.jd01_07.Vector;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(7);
        Var var2 = new Scalar(scalar);
        Var var3 = new Scalar("123.456");
        System.out.println(scalar);
        System.out.println(var2);
        System.out.println(var3);

        Vector vec = new Vector(new double[]{1, 2, 3, 4});
        Var vec2 =new Vector(vec);
        Var vec3 = new Vector("{1.0,2.0,4.0,5.0}");
        System.out.println(vec);
        System.out.println(vec2);
        System.out.println(vec3);

        Matrix mat = new Matrix(new double[][]{{1,2},{3,4}});
        Var mat2 = new Matrix(mat);
        Var mat3 = new Matrix("{{1,2},{3,4}}");
        System.out.println(mat);
        System.out.println(mat2);
        System.out.println(mat3);
    }
}