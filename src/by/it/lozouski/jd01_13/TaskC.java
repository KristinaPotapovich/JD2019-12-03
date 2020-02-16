package by.it.lozouski.jd01_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TaskC {
    static ArrayList<Double> inputNumbers = new ArrayList<>();
    static Scanner sc1;

    public static void main(String[] args) throws InterruptedException {
        sc1 = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        int countErrors = 0; // счетчик ошибок
        int tryInput = 1000; //даем пользователю 1000 попыток :)
        for (int i = 0; i <= tryInput; i++) {
            try {
                String nextInputText = sc1.next();
                double resultNum = Double.parseDouble(nextInputText);
                inputNumbers.add(resultNum);
            } catch (NumberFormatException e) {
                countErrors++;
                if (countErrors >= 5) {
                    throw e;
                }
                Thread.sleep(100);
                Collections.reverse(inputNumbers); // реверсирует коллекцию
                for (Double inputNumber : inputNumbers) {
                    System.out.print(inputNumber + " ");
                }
                Collections.reverse(inputNumbers); // реверсируем обратно после вывода чисел
                System.out.println(); // перенос строки
            }
        }
    }
}
