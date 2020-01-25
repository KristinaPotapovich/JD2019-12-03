package by.it.rumiantcau.jd01_04;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;

        for (double element : arr) {
            if (min > element) min = element;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (max < element) max = element;
        }
        return max;
    }



 static void sort(double[] arr){
//double a;
//boolean sort = false;
     System.out.println("Сортировка массива пузырьком");

/*while (!sort){
    sort = true;
     for (int i = 0; i > arr.length-1; i++) {
 if (arr[i] > arr[i+1]) {
     a = arr[i];
     arr[i] = arr[i+1];
     arr[i+1] = a;
     sort = false;
 }
     }
} */
Arrays.sort(arr);
     System.out.println();
}


static double[] mul(double[ ][ ] matrix, double[ ] vector) {
    System.out.println("Умножение двумерного массива на вектор");
 double[] x_mull = new double[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < vector.length; j++) {
            x_mull[i] = x_mull[i] + matrix[i][j]*vector[j];
        }
    }
    return x_mull;

}

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        System.out.println("Умножение двумерных массивов");

        double[][] x_mull = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    x_mull[i][j] = x_mull[i][j] + matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return x_mull;
    }

}
