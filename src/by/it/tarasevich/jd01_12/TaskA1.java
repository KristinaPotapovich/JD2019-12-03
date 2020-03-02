package by.it.tarasevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> marks = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            int mark = iterator.next();
            if (mark < 4)
            iterator.remove();
        }
    }
    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 30; i++) {
            task.marks.add((int) Math.ceil(Math.random() * 10)); // заполнили оценками LIst
        }
        System.out.println(task.marks);
        task.clearBad(task.marks);
        System.out.println(task.marks);
    }
}
