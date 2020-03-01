package by.it.rumiantcau.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        int[][] mas;
        mas = step1(n);
       // step2(mas);


        System.out.println("проверка перезаписи мас2 "+mas[0][0]);

    }

//Задание С1
    public static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        int randomNumber;
        boolean nPlus = true;
        boolean nMinus = true;
        do {

                for (int i = 0; i < mas.length-1; i++) {
                    for (int i1 = 0; i1 < mas.length-1; i1++) {
                    randomNumber =  (int) Math.round((Math.random()*2*n) - n);
                    //условие наличия N и -N в матрице
                       if (mas[i][i1] == n) {nPlus = false;}
                        else if (mas[i][i1] == -n) {nMinus = false;}
                            else mas[i][i1] = (int)randomNumber;
                    }
                }
        } while (nPlus || nMinus);

                for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                System.out.print(mas[i][i1]+" ");
            }
            System.out.println();
        }

return mas;


}






}
