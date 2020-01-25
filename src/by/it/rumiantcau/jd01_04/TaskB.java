package by.it.rumiantcau.jd01_04;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        int itogo = 0;

        Scanner sc = new Scanner(System.in);
        int kvar_number = 4;
       int[] salory = new int[kvar_number];

       System.out.println("Введите количество сотрудников");
      int n = sc.nextInt();


       String[] fam = new String[n]; //массив фамилий
       int[][] mas_zp = new int[n][kvar_number]; //массив зарплат

        System.out.println("Введите фамилии сотрудников через Enter");
        for (int i = 0; i < n; i++) {
            fam[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату сотрудника " + fam[i] + " через пробел");
            for (int j = 0; j < kvar_number; j++) {
                mas_zp[i][j] = sc.nextInt();
                itogo = itogo+mas_zp[i][j];
            }
        }

        saloryTable(fam, mas_zp, itogo);


    }
  /*  public static int[] saloryToInt()
    {
        Scanner sc = new Scanner(System.in);
        String scString = sc.nextLine();
        String[] scStrings = scString.split(" ");
        int[] scNumbers = new int[scStrings.length];
        for (int i = 0; i < scNumbers.length; i++) {
            scNumbers[i] = Integer.valueOf(scStrings[i]);
        }

      return scNumbers;
    } */

    public static void saloryTable (String[] fam, int[][] mas_zp, int itogo){
        double sredArirmet = 0;

        System.out.print("Фамилия "+"\t"+"Квартал1 "+"\t"+"Квартал2 "+"\t"+"Квартал3 "+"\t"+"Квартал4 "+"\t"+"Итого"+"\n");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (int i = 0; i < mas_zp.length; i++) {
            int zp_Kvartal=0;
            System.out.print(fam[i]+"\t");
            for (int j = 0; j < mas_zp[0].length; j++) {
                System.out.print("       "+mas_zp[i][j]+"      ");
                zp_Kvartal = zp_Kvartal + mas_zp[i][j];

                           }
            System.out.print(zp_Kvartal+"\t");
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.print("Итого "+"\t"+itogo+"\n");
        sredArirmet = itogo/12.0;

        System.out.print("Средняя ЗП"+"\t"+sredArirmet+"\n");
        System.out.println("Конец программы");





        //System.out.printf(mas_zp[1][1]);



}
}







