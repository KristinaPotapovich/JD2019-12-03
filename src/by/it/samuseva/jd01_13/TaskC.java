package by.it.samuseva.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    private static int count = 0;
    private static double[] mas = new double[1];
    private static int k = 0;
    private static double d = 0.0;
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        scanner = scan;
        readData();
    }
    private static void readData1(Scanner scan){
            while (true) {
                String line = scan.nextLine();
                if (d <= Double.parseDouble(line)){
                    mas[k++] = Double.parseDouble(line);
                    mas = Arrays.copyOf(mas, mas.length+1);
                }
            }

    }

    private static void readData() throws InterruptedException {
        while (count < 5){
            try {
                readData1(scanner);
            }catch (NumberFormatException e){
                  if (count == 4) {
                      mas = Arrays.copyOf(mas, mas.length-1);
                      for (int i = mas.length - 1; i >= 0; i--) {
                          System.out.print(" " + mas[i]);
                      }
                      System.out.println();
                      return;
                  }
                  else   {
                      Thread.sleep(100);
                      count++;
                  }
            }
        }
       // for (int i = mas.length-1; i <=0; i--)  System.out.print(mas[i]);

    }
}
