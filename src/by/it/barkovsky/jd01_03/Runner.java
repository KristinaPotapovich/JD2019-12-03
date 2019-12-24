package by.it.barkovsky.jd01_03;

public class Runner {
    public static void main(String[] args) {
        double[] d;

        d = InOut.getArray("1 2 3 6 4 5");
        InOut.printArray(d);
        InOut.printArray(d, "v", 4);
        double max, min;
        min = Helper.findMin(d);
        max = Helper.findMax(d);
        Helper.sort(d);

        double[][] m1, m2, r1;
        double[] v, r2;
        m1 = new double[3][4];
        m2 = new double[3][4];
        v = new double[4];

        r2 = Helper.mul(m1, v);
        r1 = Helper.mul(m1, m2);
    }
}

