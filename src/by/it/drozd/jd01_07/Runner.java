package by.it.drozd.jd01_07;

class Runner {
    public static void main(String[] args) {
        Var v1=new Scalar(3.1415);
        Var v2=new Vector(new double[]{1,2,3});
        Var v3=new Matrix(new double[][]{{1,2},{3,4}});
        System.out.println(v3);
        System.out.println();

    }
}
