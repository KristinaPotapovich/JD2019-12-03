package by.it.filipovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private List<Integer> listOfRating = new ArrayList<>(25);

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 taskA1 = new TaskA1();
        for (int i = 0;i<25;i++) {
            taskA1.listOfRating.add(1 + random.nextInt(10));
        }

        System.out.println(taskA1.listOfRating);
        new TaskA1().clearBad(taskA1.listOfRating);
        System.out.println(taskA1.listOfRating);

    }

    public void clearBad(List<Integer> grades){
        grades.removeIf(grade -> grade < 4);
    }

}
