package by.it.samuseva.jd01_02;

import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        step1();
        int x = scan.nextInt();
        step2(x);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        step3(a, b, c);

    }
    private static void step1() {
        int[][] array = new int[5][5];
        int a=1;
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print((array[i][j]=a) + " ");
                a=a+1;
            }
            System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month){
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double root1, root2;
        double D = (b * b) - (4 * a * c);
        if (D>=0) {
            root1 = (-b + Math.sqrt(D)) / 2 / a;
            root2 = (-b - Math.sqrt(D)) / 2 / a;
            if (D > 0) {
                System.out.println(root1 + " " + root2);
            } else System.out.println(root1);
        }
        else
            System.out.println("корней нет");
    }


}
