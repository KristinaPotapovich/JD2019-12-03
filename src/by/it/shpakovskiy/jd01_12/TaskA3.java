package by.it.shpakovskiy.jd01_12;

import java.util.*;

class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int nullPosition = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                System.out.println("(ツ)");
                break;
            }
            int i = Integer.parseInt(line);
            if (i < 0) {
                list.add(i);
            } else if (i == 0) {
                list.add(nullPosition, i);
            } else {
                list.add(nullPosition++, i);
            }
        }
        System.out.println(list.toString());
    }
}
