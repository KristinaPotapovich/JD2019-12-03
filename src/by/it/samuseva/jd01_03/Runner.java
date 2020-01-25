package by.it.samuseva.jd01_03;

public class Runner {
    public static void main(String[] args) {
        double[] array = InOut.getArray(" 17 25 84 86 52 74");
        InOut.printArray(array);
        InOut.printArray(array, "array", 3);
       // System.out.println(Helper.findMin(array));
       // System.out.println(Helper.findMax(array));
        Helper.sort(array);

       // double[] mul = Helper.mul(matrix, vector);
       // double[][] mul = Helper.mul(matrix, vector);

    }
}
