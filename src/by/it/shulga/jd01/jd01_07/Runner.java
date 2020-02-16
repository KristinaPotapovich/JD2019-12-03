package by.it.shulga.jd01.jd01_07;

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


    }
}
