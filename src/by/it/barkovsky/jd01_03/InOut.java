package by.it.barkovsky.jd01_03;

public class InOut {
    /**
     * Функция получения массива чисел типа double из строки с разделителем пробелом
     * @param line
     * @return
     */
    static double[] getArray(String line) {
        double[] result;
        String[] lineArr;
        lineArr=line.trim().split(" ");
        result=new double[lineArr.length];
        for (int i = 0; i < lineArr.length; i++) {
            result[i]=Double.parseDouble(lineArr[i]);
        }
        return result;

    }

    /**
     * Процедура вывода на экран массива чисел типа double
     * @param arr
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    /**
     * Процедура форматированного вывода на экран массива чисел типа double в указанное количество столбцов
     * @param arr массив
     * @param name имя переменной массива для вывода на экран
     * @param columnCount количество столбцов вывода
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=% -6.2f ",name,i,arr[i]);
            if((i+1)%columnCount ==0) {
                System.out.println();
            }
        }
        System.out.println();
    }


}
