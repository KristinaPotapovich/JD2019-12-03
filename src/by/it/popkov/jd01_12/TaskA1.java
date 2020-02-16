package by.it.popkov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {
    private List<Integer> marks = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() <= 3) iterator.remove();
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 taskA1 = new TaskA1();
        for (int i = 0; i < 30; i++) {
            taskA1.marks.add(random.nextInt(10) + 1);
        }
        System.out.println(taskA1.marks);
        taskA1.clearBad(taskA1.marks);
        System.out.println(taskA1.marks);
    }
}
