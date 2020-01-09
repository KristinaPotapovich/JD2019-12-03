package by.it.barkovsky.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        String[] family = new String[n];
        for (int i = 0; i < n; i++) {
            family[i]=sc.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+family[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j]=sc.nextInt();
            }
        }
        printDashLine(60);
        System.out.printf("%-10s","Фамилия");
        for (int i = 0; i <4 ; i++) {
            System.out.printf("%-10s","Квартал"+(i+1));
        }
        System.out.printf("Итого");
        System.out.println();
        printDashLine(60);
        int sum,allsum;
        allsum=0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s:  ",family[i]);
            sum=0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d",salary[i][j]);
                sum+=salary[i][j];
            }
            allsum+=sum;
            System.out.printf("%-10d",sum);
            System.out.println();
        }
        printDashLine(60);
        System.out.printf("%-10s","Итого");
        System.out.println(allsum);
        double middle;
        middle=allsum/(4.0*n);
        System.out.printf("%-10s%-10.6f","Средняя",middle);
    }

    private static void printDashLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

