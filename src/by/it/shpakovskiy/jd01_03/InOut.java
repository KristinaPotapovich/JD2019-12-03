package by.it.shpakovskiy.jd01_03;

class InOut {
    /**
     *Line conversion to numbers in array of double
     * @param line The string from which to get an array
     * @return an array of double
     */
    static double[] getArray(String line) {
        String[] arrayStrings = line.trim().split(" ");
        double[] array = new double[arrayStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(arrayStrings[i]);
        }
        return array;
    }

    /**
     * Array output(used print())
     * @param arr Array to be output
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     *Array output(used printf())
     * @param arr Array to be output
     * @param name Array name
     * @param columnCount
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0) System.out.println();
        }
        System.out.println();
    }
}
