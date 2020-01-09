package by.it.barkovsky.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line;
        line=sc.nextLine();
        buildOneDimArray(line);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ",i,j,(i*j));
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line) {
        double[] result;
        double firstElement, lastElement;
        String[] lineArr;
        lineArr=line.trim().split(" ");
        result=new double[lineArr.length];
        for (int i = 0; i < lineArr.length; i++) {
            result[i]=Double.parseDouble(lineArr[i]);
        }
        printArray(result,"V",5);
        firstElement=result[0];
        lastElement=result[result.length-1];
        sort(result);
        printArray(result,"V",4);
        for (int i = 0; i < result.length; i++) {
            if(result[i]==firstElement) {
                System.out.println("Index of first element="+i);
                break;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if(result[i]==lastElement){
                System.out.println("Index of last element="+i);
                break;
            }
        }
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%d]=%1.3f ",name,i,arr[i]);
            if((i+1)%columnCount ==0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    static void sort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    double el=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=el;
                }
            }
        }
    }


}