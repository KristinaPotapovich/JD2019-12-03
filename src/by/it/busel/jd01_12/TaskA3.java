package by.it.busel.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrList = new ArrayList<Integer>();
        int positionOfZero = 0;
        while (true) {
            String wordFromConsole = scanner.next();
            if (wordFromConsole.equals("end")) {
                break;
            }
            Integer integer = Integer.valueOf(wordFromConsole);
            if (integer < 0) {
                arrList.add(integer);
            } else if (integer == 0) {
                arrList.add(positionOfZero, integer);
            } else {
                arrList.add(positionOfZero++, integer);
            }
        }
        System.out.println(arrList.toString());

    }
}
