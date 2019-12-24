package by.it.barkovsky.jd01_02;

import java.util.Scanner;
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int val : array) {
            if (min > val) min = val;
            if (max < val) max = val;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] array) {
        double avg = 0;
        for (int val : array) {
        avg = avg+val;
        }
        avg=avg/array.length;
        for (int val : array) {
            if (val<avg)
                System.out.print(val+ " ");
        }
        }

    private static void step3(int[] array) {
        int min = array[0];
        for (int val : array) {
            if (min > val) min = val;
        }
        for (int i = array.length-1; i >=0; i--) {
            if (array[i]==min)
                System.out.print(i+" ");
        }

    }


}