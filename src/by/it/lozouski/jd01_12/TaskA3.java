package by.it.lozouski.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int zero = 0;
        while (true) {
            String words = sc1.next();
            if (words.equals("end"))break;
            Integer num = Integer.valueOf(words);
            if (num < 0) numbers.add(num);
            else if (num == 0) numbers.add(zero, num);
            else numbers.add(zero++, num);
        }
        System.out.println(numbers);
    }

}

