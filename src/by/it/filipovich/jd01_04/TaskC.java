package by.it.filipovich.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("1 3 4 6 3 11 6 3 7 8 2");

    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        int indexFirst;
        int indexLast;
        Arrays.sort(array);
        InOut.printArray(array, "V", 5);

        indexFirst = binarySearch(array, first);
        indexLast = binarySearch(array, last);

        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }

    /**
     * @param array входной массив для поиска элемента
     * @param value искомый ээлемент
     * @return возвращает искомый элемент
     */
    private static int binarySearch(double[] array, double value) {
        int low = 0;
        int end = array.length - 1;
        int mid = (low + end) / 2;
        while (array[mid] != value) {
            if (array[mid] > value)
                end = mid - 1;
            else if (value > array[mid]) {
                low = mid + 1;
            }
            mid = (low + end) / 2;
        }
        return mid;
    }

    /**
     * @param array начальный входной массив для сортировки
     */
    private static void mergeSort(double[] array) {
        System.out.println("Массив до сортировки:");
        InOut.printArray(array, "V", 4);
        mergeSort(array, 0, array.length - 1);
        System.out.println("Массив после сортировки:");
        InOut.printArray(array, "V", 4);
    }

    /**
     * @param array входной массив для разбиения
     * @param left  индекс начального элемента разбиваемого отрезка
     * @param right индекс конечного элемента разбиваемого отрезка
     */
    private static void mergeSort(double[] array, int left, int right) {
        if (left >= right)
            return;

        int pivotIndex = partition(array, left, right);
        mergeSort(array, left, pivotIndex - 1);
        mergeSort(array, pivotIndex + 1, right);
    }
        private static int partition(double[] array, int left, int right){
            int pivotIndex = (left + right) / 2;
            swap(array, pivotIndex, right);
            int start = left;
            pivotIndex = right;
            for (int i = left; i <= right - 1; i++) {
                if (array[i] <= array[pivotIndex]) {
                    swap(array, i, start);
                    start++;
                }
            }

            swap(array, start, pivotIndex);
            pivotIndex = start;
            return pivotIndex;
        }

        private static void swap(double[] array, int x, int y){
            double temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }

