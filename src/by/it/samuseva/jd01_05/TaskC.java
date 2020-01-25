package by.it.samuseva.jd01_05;

import java.util.Arrays;
import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double[] arrayA = new double[(int) ((random()*21)+20)];
        double step = (9 - 5.33) / (arrayA.length);
        double x = 5.33;
        int index = 0;
        int cols = 0;
        double[] arrayB = new double[1];
        double multiplication  = 1;
        System.out.println("Массив A[]");
        for (int i = 0; i < arrayA.length; i++) {
            if ((x>=5.33)&(x<=9)){
                arrayA[i] = cbrt(x*x+4.5);
                System.out.printf("%s[%3d] = %6.5f    ", "A", i,arrayA[i]);
                x = x+step;
                cols++;
            }
            if (cols%5 == 0) System.out.println();
            if (arrayA[i]>3.5){
                arrayB[index]=arrayA[i];
                multiplication  = multiplication  * arrayB[index];
                if (i<arrayA.length-1) {
                    arrayB = Arrays.copyOf(arrayB, (arrayB.length+1));
                    index++;
                }
            }
        }
        System.out.println();
        System.out.println("Массив B[] из элементов массива A > 3.5");
        cols=0;
        for (int i = 0; i < arrayB.length; i++) {
            System.out.printf("%s[%3d] = %6.5f   ", "B", i, arrayB[i]);
            cols++;
            if (cols%5 == 0) System.out.println();

        }
        System.out.println();
        System.out.printf("%s = %6.4f\n", "Среднеe геометрическое знчение", pow(multiplication , 1.0/index));
    }

    private static void step2() {
        int[] arrayA = new int[31];
        int[] arrayB = new int[1];
        int index = 0;
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) ((random()*348)+103);
            if ((arrayA[i] * 0.1) > i) {
                arrayB[index]=arrayA[i];
                if (i<arrayA.length-1) {
                    arrayB = Arrays.copyOf(arrayB, (arrayB.length + 1));
                }
                index++;
            }
        }
        Arrays.sort(arrayB);
        System.out.println("Массив А (индекс по строкам)");
        printArrayA(arrayA);
        System.out.println("Массив В (индекс по столбцам)");
        printArrayB(arrayB);

    }

    private static void printArrayA(int[] arrayA) {
        int cols = 0;
        System.out.print ("\u2554");
        for (int i = 1; i < 55; i++) {
            System.out.print ("\u2550");
            if (i%11==0) System.out.print ("\u2566");
        }
        System.out.println ("\u2557");

        // основной вывод массива
        for (int i = 0; i < arrayA.length; i++) {
            System.out.printf("\u2551 %s[%2d]=%3d ", "A", i, arrayA[i]);
            cols++;
            if (cols%5 == 0) {
                System.out.print ("\u2551\n");
                System.out.print ("\u2560");
                for (int j = 1; j < 55; j++) {
                    System.out.print ("\u2550");
                    if (j%11==0) System.out.print ("\u256C");
                }
                System.out.println ("\u2563");
            }
            if ((i==arrayA.length-1)&(arrayA.length-1%5!=0)) {
                for (int j = 0; j < 5-((arrayA.length)%5); j++) {
                    System.out.printf("\u2551           ");
                }
                System.out.printf ("\u2551\n");
            }
        }
        System.out.print ("\u255A");
        for (int i = 1; i < 55; i++) {
            System.out.print ("\u2550");
            if (i%11==0) System.out.print ("\u2569");
        }
        System.out.println ("\u255D");
    }

    private static void printArrayB(int[] arrayB) {
        int rows = round(arrayB.length/5);
        if (arrayB.length%5<5) rows++;

        System.out.print ("\u2554");
        for (int i = 1; i < 55; i++) {
            System.out.print ("\u2550");
            if (i%11==0) System.out.print ("\u2566");
        }
        System.out.println ("\u2557");


        // основной вывод массива
        for (int i = 0; i <= rows; i++) {
            int cols = 0;
            for (int j = i;  j< arrayB.length; j=j+rows) {
                System.out.printf("\u2551 %s[%2d]=%3d ", "B", j, arrayB[j]);
                cols++;
                if (((j+rows)>arrayB.length-1)&(cols == 4)) {
                    System.out.printf("\u2551           ");
                    cols++;
                }
                if (cols == 5) {
                    System.out.println("\u2551");
                    if (i!=rows) {
                        System.out.print ("\u2560");
                        for (int k = 1; k < 55; k++) {
                            System.out.print ("\u2550");
                            if (k%11==0) System.out.print ("\u256C");
                        }
                        System.out.println ("\u2563");
                    }
                    break;
                }
            }
        }
        System.out.print ("\u255A");
        for (int i = 1; i < 55; i++) {
            System.out.print ("\u2550");
            if (i%11==0) System.out.print ("\u2569");
        }
        System.out.println ("\u255D");


    }

}
