package by.it.samuseva.jd01_04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int namberPersons = scan.nextInt();
        String[] listPeople = new String[namberPersons];
        int[][] salary = new int[namberPersons][4];
        int[] sumSalaryPersons = new int[4];
        int sum = 0;
        for (int i = 0; i < namberPersons ; i++) {
            listPeople[i] = scan.next();
            if (i==3) break;
        }
        for (int i = 0; i < namberPersons; i++) {
          //  System.out.println("Введите зарплату для " + listPeople[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scan.nextInt();
                sumSalaryPersons[i] += salary[i][j];
                sum += salary[i][j];
            }
        }
        System.out.printf("----------------------------------------------------------------------------------%n");
        System.out.printf("%10s   %8s   %8s   %8s   %8s   %5s%n", "Фамилия", "Квартал1", "Квартал2", "Кавртал3", "Квартал4", "Итого");
        System.out.printf("-----------------------------------------------------------------------------------%n");
        for (int i = 0; i < namberPersons; i++) {
            System.out.printf("%10s:   ", listPeople[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-8d   ", salary[i][j]);
            }
            System.out.printf("   %-5d%n", sumSalaryPersons[i]);
        }
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("%-10s   %-8d%n", "Итого", sum);
        System.out.printf("%-10s   %-8.4f%n", "Средняя", (sum/4.0/namberPersons));
    }
}
