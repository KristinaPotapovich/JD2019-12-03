package by.it.ban.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int positionZero=0;
        while (true){
            String word = scanner.next();
            if (word.equals("end")) break;
            Integer i = Integer.valueOf(word);
            if (i<0){
                list.add(i);
            }
            else if (i==0) {
                list.add(positionZero,i);
            }
            else {
                list.add(positionZero++,i);
            }
        }
        System.out.println(list);
    }
}
