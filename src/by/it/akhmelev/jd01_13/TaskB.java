package by.it.akhmelev.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String strSome = scanner.next();
        try {
            double d=Double.parseDouble(strSome);
        }
        catch (NumberFormatException e){
            System.out.println("catch");
        }

    }
}
