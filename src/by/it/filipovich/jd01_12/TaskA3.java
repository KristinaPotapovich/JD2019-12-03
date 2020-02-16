package by.it.filipovich.jd01_12;

import java.util.*;

public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String in;
        int position = 0;
        while (!(in = scanner.nextLine()).equals("end")){
            int number = Integer.parseInt(in);
            if(number > 0)
                list.add(position++,number);
            else if (number < 0)
                list.add(number);
            else list.add(position,number);
        }
        System.out.println(list);
    }
}
