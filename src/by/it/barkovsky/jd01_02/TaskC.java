package by.it.barkovsky.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mas = new int[n][n];
        step1(mas, n);
        //step2(month);
        //step3(a,b,c);
    }

    private static void step1(int[][] mas, int n) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                do {
                    mas[i][j] = (int) (Math.random() * ((n * 2) + 1) - n);
                }
                while (mas[i][j] != n );
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void step2(int month) {

    }

    private static void step3(double a, double b, double c) {

    }
}