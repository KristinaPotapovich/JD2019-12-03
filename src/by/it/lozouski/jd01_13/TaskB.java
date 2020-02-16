package by.it.lozouski.jd01_13;

import java.util.Scanner;
//Пока тест не проходит...
class TaskB {
    public static void main(String[] args) {
        TaskB taskB = new TaskB();
        Scanner sc1 = new Scanner(System.in);
        double sum = 0;
        while (true) {
            try {
                String tempString = sc1.next().toUpperCase();
                if (tempString.equals("END")) break;
                double num = Double.parseDouble(tempString);
                sum += num;
                double resultSqrt = Math.sqrt(sum);
                if (Double.isNaN(resultSqrt)){
                    throw new ArithmeticException();
                }
                System.out.println(num);
                System.out.println(resultSqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                Exceptions.printException(e, taskB);
            }
        }
    }
}
