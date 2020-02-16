package by.it.cherkas.jd01_03;

import java.util.Scanner;

class Runner {

     static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        double[] array=InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);

    }
}
