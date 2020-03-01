package by.it.filipovich.jd01_03;


public class Runner {
    public static void main(String[] args) {

        // TaskA
        double[] result = InOut.getArray("0.1 0.2 -0.2 -0.1 3 4 5 6 7 8 9 0 1");
        InOut.printArray(result);
        System.out.println();
        InOut.printArray(result, "mas", 4);
        System.out.println();

        //TaskB
        System.out.println(Helper.findMin(result));
        System.out.println(Helper.findMax(result));
        Helper.sort(result);

        //TaskC
        double[][] arrLeft = {
                {1, 2, 3, 5},
                {4, 6, -1, -5},
                {-11, 3, 6, 9}
        };
        double[][] arrRight = {
                {1, 2, 3, 5},
                {4, 6, -1, -5},
                {-11, 3, 6, 9},
                {-11, 5, 1, 0}
        };
        double[] vector = {3, 2, 1, 5};
        Helper.mul(arrLeft, vector);
        Helper.mul(arrLeft, arrRight);



    }
}
