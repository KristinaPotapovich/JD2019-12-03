package by.it.samuseva.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            int a = scan.nextInt();
            array[i] = a;
        }
        step1(array);
        step2(array);
        step3(array);
    }
    private static void step1(int[] array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            if (array[i]<min) min = array[i];
            if (array[i]>max) max = array[i];
        }
        System.out.print(min + " " + max);
        System.out.println();
    }
            

    private static void step2(int[] array){
        int sum = 0;
        for (int i = 0; i < 10 ; i++) {
        sum+=array[i];
        }
        double dsum = (double) sum / array.length;
        for (int i = 0; i < 10 ; i++) {
            if (array[i]<dsum) System.out.print(array[i] + " ");

        }
        System.out.println();

    }
    private static void step3(int[] array){
        int min = 1000;
        for (int i = 0; i < 10; i++) {
            if (array[i]<min) min = array[i];
        }
        for (int i = array.length-1; i >= 0; i--)
            if (min == array[i]) System.out.print(i + " ");
        System.out.println();
    }
}
