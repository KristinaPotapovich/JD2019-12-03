package by.it.tarasevich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        try{
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
