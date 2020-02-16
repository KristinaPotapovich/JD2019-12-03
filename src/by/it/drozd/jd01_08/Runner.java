package by.it.drozd.jd01_08;

class Runner {
    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        System.out.println(s.add(s));
        System.out.println(s.sub(s));
        System.out.println(s.mul(s));
        System.out.println(s.div(s));
    }


}
