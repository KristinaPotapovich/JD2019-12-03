package by.it.rumiantcau.jd01_04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        buildOneDimArray(s);
    }

    static void buildOneDimArray(String line){

        double[] array = InOut.getArray(line);
        double start = array[0];
        double end = array[array.length-1];
        InOut.printArray(array,"V",5);
        //Helper.sort(array);
        mergeSort(array);
        InOut.printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("first element="+i);
            }
            if (array[i] == end) {
                System.out.println("last element="+i);
            }

        }

    }


    static void mergeSort(double[] array) {

        Arrays.sort(array);

    }

}
