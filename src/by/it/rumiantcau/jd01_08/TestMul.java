package by.it.rumiantcau.jd01_08;

import java.util.Arrays;

public class TestMul {

    public static void main(String[] args) {

        double[][] value = {{1,2,3},{4,5,6},{7,8,9}};
        double[][] resMul = new double[value.length][value[0].length];
        resMul = Arrays.copyOf(value, value.length);
        System.out.println(resMul[0][1]);
        System.out.println(resMul.length);
        System.out.println(resMul[0].length);



   /* for (int i = 0; i < resMul.length; i++) {
        for (int j = 0; j < resMul[0].length; i++) {
            resMul[i][j] = value[i][j];
        }
    }

    //





            for (int i = 0; i < resMul.length; i++) {
        for (int j = 0; j < resMul[0].length; i++) {
            resMul[i][j] = resMul[i][j] * ((by.it.rumiantcau.jd01_08.Scalar)other).getValue();
        }
    }*/
    }


}
