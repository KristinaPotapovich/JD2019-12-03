package by.it.barkovsky.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    static String v = "║";
    static String h = "═";
    static String ct = "╦";
    static String cm = "╬";
    static String cb = "╩";
    static String lt = "╔";
    static String lb = "╚";
    static String rt = "╗";
    static String rb = "╝";
    static String lm = "╠";
    static String rm = "╣";

    public static void main(String[] args) {

        step6();
        step7();
    }

    private static void step6() {
        double[] z = new double[40];
        //double[] z1 = new double[40];
        double x, sum, sredgeo;
        int i = 0;
        int kolz, kolz1;
        for (x = 5.33; x <= 9; x += ((9 - 5.33) / 30)) {
            z[i++] = cbrt(x * x + 4.5);
            if (i >= 40) break;
        }
        kolz = i;
        printArray(z, "A", 6, kolz);
        i = 0;
        sum = 0;
        for (int j = 0; j < kolz; j++) {
            if (z[j] > 3.5) {
                //z1[i++] = z[j];
                i++;
                sum += z[j];
            }
        }
        kolz1 = i;
        sredgeo = pow(sum, (-kolz1));
        System.out.println(sredgeo);
    }

    static void printArray(double[] arr, String name, int columnCount, int arrlen) {
        for (int i = 0; i < arrlen; i++) {
            System.out.printf("%s[% -2d]=%1.5f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void step7() {
        double[] a = new double[31];
        int kol = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = round(random() * (450.0 - 103.0) + 103.0);
            if (a[i] * 0.1 > i) kol++;
        }
        double[] b = new double[kol];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] * 0.1 > i) b[j++] = a[i];
        }
        sort(b);
        boolean row;
        int colnum = 5;
        printTable(a, "A", colnum, true);
        printTable(b, "B", colnum-2, false);
    }

    static void sort(double[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(double[] arr, int start, int stop) {
        if (arr.length == 0) return;
        if (start >= stop) return;
        // выбрать опорный элемент
        double opora = arr[(start + (stop - start) / 2)];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = start, j = stop;
        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }
            while (arr[j] > opora) {
                j--;
            }
            if (i <= j) {//меняем местами
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) quickSort(arr, start, j);
        if (stop > i) quickSort(arr, i, stop);

    }

    static void printTable(double[] arr, String name, int columnCount, boolean row) {
        //System.out.println(arr.length);
        int width = 15;
        String st;
        printTR(columnCount, width);
        System.out.print(v);
        int i;
        if (row) {
            for (i = 0; i < arr.length; i++) {
                st = String.format("%s(%2d)=%1.0f ", name, i, arr[i]);
                System.out.print(st);
                for (int j = st.length(); j < width; j++) {
                    System.out.print(" ");
                }
                System.out.print(v);
                if ((i + 1) % columnCount == 0 && ((i+1)<arr.length)) {
                    System.out.println();
                    printMR(columnCount, width);
                    System.out.print(v);
                }

            }
            while ((i) % columnCount != 0) {
                for (int j = 0; j < width; j++) {
                    System.out.print(" ");
                }
                System.out.print(v);
                i++;
            }
            System.out.println();
        } else {
            int delta = (int) ceil((double) arr.length / (double) columnCount);
            //System.out.println("del="+delta);
            for (int j = 0; j < delta; j++) {
                for (i = 0; i < columnCount; i++) {
                    if (j + (i * delta) < arr.length) {
                        st = String.format("%s(%2d)=%1.0f ", name, (j + (i * delta)), arr[j + (i * delta)]);
                        System.out.print(st);
                        for (int k = st.length(); k < width; k++) {
                            System.out.print(" ");
                        }
                        System.out.print(v);
                    }

                    if ((i + 1) % columnCount == 0 ) {
                        if (j + (i * delta) >= arr.length) {
                            for (int k = 0; k < width; k++) {
                                System.out.print(" ");
                            }
                            System.out.print(v);
                        }
                        System.out.println();
                        if(j+1  < delta) {
                            printMR(columnCount, width);
                            System.out.print(v);
                        }
                    }
                }
            }

        }

        printBR(columnCount, width);
    }

    private static void printTR(int columnCount, int width) {
        System.out.print(lt);
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(h);
            }
            if (i == columnCount - 1) System.out.println(rt);
            else System.out.print(ct);
        }
    }

    private static void printBR(int columnCount, int width) {
        System.out.print(lb);
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(h);
            }
            if (i == columnCount - 1) System.out.println(rb);
            else System.out.print(cb);
        }
    }

    private static void printMR(int columnCount, int width) {
        System.out.print(lm);
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(h);
            }
            if (i == columnCount - 1) System.out.println(rm);
            else System.out.print(cm);
        }
    }
}
