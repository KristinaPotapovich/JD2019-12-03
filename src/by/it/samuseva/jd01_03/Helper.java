package by.it.samuseva.jd01_03;

class Helper {

    static double findMin(double[] array) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i]<min) min=array[i];
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max) max=array[i];
        }
        return max;
    }

    static void sort(double[] array) {
        int length = array.length-1;
        int start = 0;
        for (int i = 0; i < length; i++) {
            double bufer;
            if (array[i] > array[i+1]) {
                bufer = array[i+1];
                array[i+1] = array[i];
                array[i] = bufer;
            }
            if (i == (length - 1))  {
                for (int j = length - 1; j > start; j--) {
                    double bufer1;
                    if (array[j]<array[j-1]) {
                        bufer1 = array[j-1];
                        array[j-1] = array[j];
                        array[j] = bufer1;
                    }
                    if (j == (start + 1)) {
                        start++;
                    }
                }
                length--;
                i=0;
            }
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] rezult = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rezult[i] = rezult[i] + (matrix[i][j] * vector[j]);
            }
        }
        return rezult;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] rezult = new double[matrixLeft.length][matrixRight[0].length];
        if (matrixLeft.length == matrixRight[0].length) {
             for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k < matrixRight.length; k++) {
                        rezult[i][j] = rezult[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                    }
                }
            }
        } else System.out.println("Матрицы не могут быть перемножены");

        return rezult;
    }
}
