package by.it.filipovich.jd01_04;

import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] surName = new String[n];
        for (int i = 0; i < surName.length; i++) {
            surName[i] = sc.next();
       }
        int[][] salary = new int[surName.length][4];
        for (int i = 0; i < surName.length; i++) {
            System.out.println("Введите зарплату для "+surName[i]);
            for (int j = 0; j < salary[0].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        outSalary(surName, salary);
    }

    /**
     * метод считает суммарную зарплату каждого работника за год,
     * выводит табличную форму для заполнения и заполняет талицу полученными данными,
     * после этого выводит общее количество денег и среднюю зарплату.
     *
     * @param surName массив фамилий работников
     * @param salary массив зарплат работников за 4 квартала
     */
    private static void outSalary(String[] surName, int[][] salary){
        int[] sum = new int[surName.length];

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < salary[0].length; j++) {
                sum[i] = sum[i]+salary[i][j];
            }
        }
        tableHeader();
        for (int i = 0; i < surName.length; i++) {
            System.out.printf("%10s ",surName[i]+":");
            for (int j = 0; j < salary[0].length; j++) {
                System.out.printf("%-10d",salary[i][j]);
            }
            System.out.printf("%-10d\n",sum[i]);
        }
        for(int i = 0;i < 60; i++){
            System.out.print("-");
        }
        System.out.println();
        middleOfSalarysAndSum(salary);

    }

    /**
     *
     * @param salary массив зарплат для расчета общей суммы и среднего значения.
     */
    private static void middleOfSalarysAndSum(int[][] salary){
        int sumFinal = 0;
        double middle;
        int numberOfSalarys = salary.length*salary[0].length;
        for (int[] ints : salary) {
            for (int j = 0; j < salary[0].length; j++) {
                sumFinal = sumFinal + ints[j];
            }
        }
        middle = (1.00*sumFinal)/numberOfSalarys;
        System.out.printf("%-10s %-10d\n","Итого", sumFinal);
        System.out.printf("%-10s %-10.4f","Средняя", middle);
    }

    /**
     * выводит шапку таблицы
     */
    private static void tableHeader(){
        for(int i = 0;i < 60; i++){
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%10s %-10s%-10s","Фамилия","Квартал1","Квартал2");
        System.out.printf("%-10s%-10s%-10s","Квартал3","Квартал4","Итого");
        System.out.println();
        for(int i = 0; i < 60; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
