package by.it.ban.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> grades=new ArrayList<>();


    private void clearBad(List<Integer> g){
        Iterator<Integer> iterator = g.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if (grade<4)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        Random random=new Random();
        for (int i = 0; i < 31; i++) {
            task.grades.add(1+random.nextInt(10));
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }



}
