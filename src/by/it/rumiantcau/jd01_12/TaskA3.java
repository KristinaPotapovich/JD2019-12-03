package by.it.rumiantcau.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
     List<Integer> list=new ArrayList<>();
        int positionZero=0;
        long time = System.nanoTime();
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
        time = System.nanoTime() - time;
        System.out.println(list);
        System.out.println(time);
/*Реализуем на Линкед листе ради смеха посмотреть на скорость
// на порядок медленнее вышло
        LinkedList<Integer> listLL=new LinkedList<>();
        List<Integer> listLL2=new LinkedList<>();

        long timeLL = System.nanoTime();


        while (true){

            String word = scanner.next();
            if (word.equals("end")) break;
            Integer i = Integer.valueOf(word);
             if (i==0) {
                listLL.add(i);
            }
            else {
                listLL2.add(i);
            }
        }
        for (int i = 0; i < listLL2.size(); i++) {
            if (listLL2.get(i) < 0){
                listLL.add(listLL2.get(i));
            }
            else
                listLL.addFirst(listLL2.get(i));
        }
        timeLL = System.nanoTime() - timeLL;
        System.out.println(listLL);
        System.out.println(timeLL);*/
    }

}
