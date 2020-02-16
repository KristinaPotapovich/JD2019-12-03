package by.it.busel.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {
    private List<Integer> pupilsGrades = new ArrayList<Integer>();

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if ((iterator.next() < 4)) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        Random randomator = new Random();
        for (int i = 0; i < 29; i++) {
            taskA1.pupilsGrades.add(randomator.nextInt(10) + 1);
        }
        System.out.println(taskA1.pupilsGrades);
        taskA1.clearBad(taskA1.pupilsGrades);
        System.out.println(taskA1.pupilsGrades);
    }
}
