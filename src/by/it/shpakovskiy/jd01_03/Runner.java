package by.it.shpakovskiy.jd01_03;

class Runner {
    public static void main(String[] args) {
        double[] array = InOut.getArray("-1 2 3 4 567 567 4 3 2 -1 4 4");
        InOut.printArray(array);
        InOut.printArray(array, "a", 3);
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);
        InOut.printArray(array);
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        double[] vector = {1, 2, 3};
        double[] result1 = Helper.mul(matrix, vector);
        InOut.printArray(result1);
        double[][] left = {{1, 2, 3}, {4, 5, 6}};
        double[][] right = {{1, 2}, {3, 4}, {5, 6}};
        double[][] result2 = Helper.mul(left, right);
        for (double[] doubles : result2) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }
}
