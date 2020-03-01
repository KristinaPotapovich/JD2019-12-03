package by.it.filipovich.jd01_02;

import java.util.Scanner;

public class TaskC {

       public static void main(String[] args) throws StackOverflowError {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] array = step1(n);
        System.out.println(step2(array));
           //step3(array)
       }

    private static int[][] step1(int n) {//
        int[][] arr = rand(n);
        int count1 = 0;
        int count2 =0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == n) {
                    count1++;
                    for (int x = 0; x < n; x++) {
                        for(int y = 0; y < n; y++) {
                            if (arr[x][y] == -n)
                                count2++;
                        }
                    }
                }
            }
        }
        if (count1 != 0 && count2 != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            return arr;
        } else
            return step1(n);
    }

           private static int[][] rand(int n){
            int[][] array = new int[n][n];
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = (int) (Math.random() * (2*n+1)) - n;
                }
            }
            return array;
    }


    private static int step2(int[][] array) {
        int sum = 0;
        int count = 0;
        int j1 = 0;
        int j2;
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > 0) {
                    count++;

                    if (count == 1) {
                        j1 = j;
                    }
                    if (count == 2) {
                        j2 = j;

                        if ((j2 - j1) > 1) {
                            for (int k = j1 + 1; k < j2; k++) {
                                sum = sum + ints[k];
                            }
                        }
                        break;
                    }
                }
            }
            count = 0;
        }
        System.out.println(sum);
        return sum;
    }

    /*
    private static int step3(int[][] array) {
           int max = maximum(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

            }
        }
        return max;
    }

    private static int maximum(int[][] array){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]>max)
                    max = array[i][j];
            }
        }
        return max;
    }


     */
}