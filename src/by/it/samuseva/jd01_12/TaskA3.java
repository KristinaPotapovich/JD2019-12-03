package by.it.samuseva.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List list = new ArrayList();
        int posZero = 0;
        while (true){
            String word = scan.next();
            if (word.equals("end")) break;
            Integer i = Integer.valueOf(word);
            if (i<0) list.add(i);
            else if (i==0) list.add(posZero, i);
            else if (i>0) list.add(posZero++,i);


        }
        System.out.println(list);
    }
}
