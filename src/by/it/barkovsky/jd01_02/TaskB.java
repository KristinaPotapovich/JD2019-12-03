package by.it.barkovsky.jd01_02;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month;
        double a;
        double b;
        double c;
        month = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        step1();
        step2(month);
        step3(a,b,c);
    }

    private static void step1() {
        int n = 5;
        for (int i = 1; i <= 25; i++) {
            if (i % 5 != 0) {
                System.out.print(i + " ");
            } else {
                System.out.println(i + " ");
            }
        }
    }

    private static void step2(int month) {
        String monthStr = null;
        switch (month) {
            case 1:
                monthStr = "январь";
                break;
            case 2:
                monthStr = "февраль";
                break;
            case 3:
                monthStr = "март";
                break;
            case 4:
                monthStr = "апрель";
                break;
            case 5:
                monthStr = "май";
                break;
            case 6:
                monthStr = "июнь";
                break;
            case 7:
                monthStr = "июль";
                break;
            case 8:
                monthStr = "август";
                break;
            case 9:
                monthStr = "сентябрь";
                break;
            case 10:
                monthStr = "октябрь";
                break;
            case 11:
                monthStr = "ноябрь";
                break;
            case 12:
                monthStr = "декабрь";
                break;
            default:
                monthStr = "нет такого месяца";
        }
        System.out.print(monthStr);
    }

    private static void step3(double a, double b, double c) {
        double res = b * b - 4 * a * c;
        if (res < 0)
            System.out.println("корней нет");
        else if (res == 0) {
            double x = -b / (2 * a);
            System.out.print(x);
        } else {
            double x1 = (-b + Math.sqrt(res)) / (2 * a);
            double x2 = (-b - Math.sqrt(res)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }
}