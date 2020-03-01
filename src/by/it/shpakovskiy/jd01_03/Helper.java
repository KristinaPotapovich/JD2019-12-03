package by.it.shpakovskiy.jd01_03;

import java.util.Arrays;

class Helper {
    static double findMin(double[] arr) {
        return Arrays.stream(arr).min().getAsDouble();
    }

    static double findMax(double[] arr) {
        return Arrays.stream(arr).max().getAsDouble();
    }

    static void sort(double[] arr) {
        int k=arr.length/2;
        while (k > 0) {
            for (int i=0;i<arr.length-k;i++){
                int j=i;
                while (j>=0 && arr[j]>arr[j+k]){
                    double buf=arr[j];
                    arr[j]=arr[j+k];
                    arr[j+k]=buf;
                    j--;
                }
            }
            k=k/2;
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] result=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i]+=matrix[i][j]*vector[j];
            }
        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j]+=matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return result;
    }
}
