package by.it.filipovich.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double[] arr = functionSix();
        double[] newArr = functionSixWithNewArray(arr);
        System.out.println("Массив A:");
        OutputArray.printArray(arr,"A", 5);
        System.out.println("Массив A <с элементами > 3.5::");
        OutputArray.printArray(newArr,"A", 5);
        System.out.println("Среднее геометрическое элементов массива = "+ AverageCalculation.geometricMean(newArr));

    }

    private static void functionSeven() {
        int [] arrayA = new int[31];
        int a = 103;
        int b = 450;
        for (int v : arrayA) {
            v = a+(int) (Math.random()*(b-a+1));
        }
        OutputArray.printArray(arrayA, "A", 5);

        functionSevenWithNewArray(arrayA);
    }

    private static void functionSevenWithNewArray(int[] arrayA) {
        int number = numberOfPercent10(arrayA);
        int[] arrayB = new int[number];
        int j = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (0.1 * arrayA[i] > (double) i) {
                arrayB[j] = arrayA[i];
                j++;
            }
        }
        Arrays.sort(arrayB);
        OutputArray.printArray(arrayB,"M",2);
    }

    private static int numberOfPercent10(int[] arrayA) {
        int count = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (0.1 * arrayA[i] > i)
                count++;
        }
        return count;
    }

    private static double[] functionSixWithNewArray(double[] array) {
        int number = numberOfElements(array);
        double[] newArray = new double[number];
        int j = 0;
        for (double v : array) {
            if (v > 3.5) {
                newArray[j] = v;
                j++;
            }
        }
        return newArray;
    }

    private static int numberOfElements(double[] array) {
        int number = 0;
        for (double v : array) {
            if (v > 3.5)
                number++;
        }
        return number;
    }

    private static double[] functionSix() {
        double leftOfX = 5.33;
        double rightOfX = 9;
        double delta = 0.12;
        int  sizeOfArray = (int) ((rightOfX-leftOfX)/delta);
        double[] array1 = new double[sizeOfArray+1];
        int indOfArray = 0;
        double x = leftOfX;
        while(indOfArray < array1.length && x <= rightOfX){
                array1[indOfArray] = methodZ(x);
                x = x + delta;
                indOfArray++;
        }
        return array1;
    }

    private static double methodZ(double x) {
        return cbrt(x*x + 4.5);
    }
}
