package by.it.filipovich.jd01_02;

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

    private static void step3(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        for(int i = (array.length-1); i>= 0; i--){
            if(min == array[i]){
                System.out.print(i+ " ");
            }
        }
    }

    private static void step2(int[] array) {
        int sum = 0;
        for (int value:array) {
            sum=sum+value;
        }
        double mean = sum/(array.length*1.0);
        for (int value : array) {
            if (value < mean)
                System.out.print(value + " ");
        }
        System.out.println(" ");
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int value : array) {
            if (min > value) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        System.out.print(min+" "+max);
        System.out.println();
    }

}


