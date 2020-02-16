package by.it.kuzmichalex.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private static List<Integer> listGrades = new ArrayList<>();

    /**
     * Удаление из переданного листа оценок меньше 4.
     * @param grades List Integer оценок
     * Возвращать ничего не будем. Мы повырываем странички из оригинального дневника :)
     */
    void clearBad(List<Integer> grades) {
        grades.removeIf(next -> next < 4);
    }

    public static void main(String[] args) {
        final int countOfGrades = 30;
        final int maxGrade = 10;
        Random random = new Random();
        for (int i = 0; i < countOfGrades; i++) listGrades.add(random.nextInt(maxGrade) + 1);
        System.out.println("Grades:      " + listGrades);
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearBad(listGrades);
        System.out.println("Good grades: " + listGrades);
    }
}
