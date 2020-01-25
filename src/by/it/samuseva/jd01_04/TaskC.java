package by.it.samuseva.jd01_04;

public class TaskC {
    public static void main(String[] args) {

        String array = "-5 9 -6 0 -1 8 -3 2 6 -8 5 -9 3";
        buildOneDimArray(array);

    }
    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length-1];
        InOut.printArray( array,"V", 5);
       // Helper.sort(array);
        mergeSort(array);
        InOut.printArray( array,"V", 4);
        System.out.printf("Index of first element=%d%n", binarySearch(array, firstElement));
        System.out.printf("Index of last element=%d%n", binarySearch(array, lastElement));
    }

    /**
     * в методе реализован метод сортировки quick sort
     */
    private static void mergeSort(double[] array) {
        int left = 0;
        int right = array.length-1;
        int midle =  left  + (right-left)/2;
        double supporting = array[midle];
        while (left<=right) {
            while (array[left] < supporting)  left++;
            while (array[right] > supporting) right--;

            if (left<=right) {
                double bufer = array[left];
                array[left] = array[right];
                array[right] = bufer;
                left++;
                right--;
            }
        }
        left = 0;
        right = array.length-1;
        mergeSort(array, left, midle );
        mergeSort(array, midle, right);

    }
    private static void mergeSort(double[] array, int left, int right) {
        if (array.length == 0) return;
        if (left>=right) return;
        int midle = left  + (right-left)/2;
        double supporting = array[midle];
        int i = left;
        int j = right;
        while (i<=j) {
            while (array[i]<supporting)  i++;
            while (array[j]>supporting) j--;
            if (i<=j) {
                double bufer = array[i];
                array[i] = array[j];
                array[j] = bufer;
                i++;
                j--;
            }
        }
        if (left < j) mergeSort(array, left, j);
        if (right > i) mergeSort(array, i, right);
    }

    private static int binarySearch(double[] array, double element) {
        int rezult = 0;
        int left = 0;
        int rigth = array.length-1;
        int mid = (rigth+left)/2;
        while (rigth>=left) {
            if (array[mid] == element) {
                rezult = mid;
                break;
            } else if (element < array[mid]) {
                rigth = mid - 1;
                mid = (rigth+left)/2;
            } else {
                left = mid + 1;
                mid = (rigth+left)/2;
            }
        }

        return rezult;
    }

}
