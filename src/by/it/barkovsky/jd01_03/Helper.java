package by.it.barkovsky.jd01_03;

public class Helper {
    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }

        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];

                }

            }

        }
        return result;
    }

    /**
     * Функция поиска минимального значения в массиве
     *
     * @param arr
     * @return
     */
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double element : arr) {
            if (element < min) min = element;
        }
        return min;
    }

    /**
     * Функция поиска максимального значения в массиве
     *
     * @param arr
     * @return
     */
    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (element > max) max = element;
        }
        return max;
    }

    /**
     * функция сортировки массива по возрастанию рекурсивно
     *
     * @param arr
     */
    static void sort(double[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(double[] arr, int start, int stop) {
        if (arr.length == 0) return;
        if (start >= stop) return;
        // выбрать опорный элемент
        double opora = arr[(start + (stop - start) / 2)];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = start, j = stop;
        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }
            while (arr[j] > opora) {
                j--;
            }
            if (i <= j) {//меняем местами
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) quickSort(arr, start, j);
        if (stop > i) quickSort(arr, i, stop);

    }
}
