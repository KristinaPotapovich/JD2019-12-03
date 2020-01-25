package by.it.samuseva.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] array = {{1, -2, -2, 6},{-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};

       // step1(n);
       // step2(step1(5));
        step3(array);
    }


    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * (n+n+1))-n;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    private static int step2(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            int index1 = 0 , index2 = 0;
            for (int j = 0; j < array[0].length; j++) {
                if (array [i][j]>=0) {
                    count++;
                }
                if ((count == 1) && (array[i][j]>0)) index1 = j;
                if (count == 2) {
                    index2=j;
                    break;
                }
            }
            for (int j = index1 +1; j < index2; j++) {
                sum = sum + array[i][j];
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] array) {
        boolean[] rows = new boolean[array.length];
        boolean[] cols = new boolean[array[0].length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length ; j++) {
                if (array[i][j] > max) max = array[i][j];
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == max) {
                    rows [i] = true;
                    cols [j] = true;
                }
            }
        }
        int row = 0;
        int col = 0;
        for (boolean elem : rows) {
            if (!elem) row++;
        }
        for (boolean elem : cols) {
            if (!elem) col++;
        }
        int[][] rezult = new int[row][col];
        int irez = 0;
        for (int i = 0; i < array.length; i++) {
            if (!rows[i]){
                int jrez = 0;
                for (int j = 0; j < array[0].length; j++) {
                    if (!cols[j]){
                        rezult[irez][jrez] = array [i][j];
                        System.out.print(rezult[irez][jrez] + " ");
                        jrez++;
                        }
                    }
                irez++;
            }
                System.out.println();
        }
        return rezult;
    }
}
