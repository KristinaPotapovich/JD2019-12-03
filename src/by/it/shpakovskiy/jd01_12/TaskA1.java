package by.it.shpakovskiy.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    void clearBad(List<Integer> grades) {
        grades.removeIf(grade -> grade < 4);
    }

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            taskA1.grades.add(1 + random.nextInt(10));
        }
        System.out.println(taskA1.grades);
        taskA1.clearBad(taskA1.grades);
        System.out.println(taskA1.grades);
    }
}
