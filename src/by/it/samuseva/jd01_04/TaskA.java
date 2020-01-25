package by.it.samuseva.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        buildOneDimArray(line);
    }

    public static void printMulTable(){
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 2; j <= 9 ; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length-1];
        InOut.printArray( array,"V", 5);
        Helper.sort(array);
        InOut.printArray( array,"V", 4);
        System.out.printf("Index of first element=%d%n", Arrays.binarySearch(array, firstElement));
        System.out.printf("Index of last element=%d%n", Arrays.binarySearch(array, lastElement));
    }

}
