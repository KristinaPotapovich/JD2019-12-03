package by.it.samuseva.jd01_03;

class InOut {
    static double[] getArray(String line) {

        line.trim();
        String[] str = line.split(" ");
        int length = str.length;
        double[] rezult = new double[length];
        for (int i = 0; i < rezult.length; i++) {
            rezult[i] = Double.parseDouble(str[i]);
        }
        return rezult;
    }

    static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int cols) {
        int count=0;
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("% -5.2f  %s    ", arr[i], name);
            count++;
            if (count == cols) {
                System.out.println();
                count=0;
            }

        }
    }
}
