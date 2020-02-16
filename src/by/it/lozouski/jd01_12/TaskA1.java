package by.it.lozouski.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class TaskA1 {

    private List<Integer> listA = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 marks = new TaskA1();
        Random randomNumbers = new Random();
        for (int i = 0; i < 25; i++) {
            marks.listA.add(1 + randomNumbers.nextInt(10));
        }
        System.out.println(marks.listA);
        marks.clearBad(marks.listA);
        System.out.println(marks.listA);
    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> myIterator = grades.iterator();
        while (myIterator.hasNext()) {
            Integer mark = myIterator.next();
            if (mark < 4) myIterator.remove();
        }
    }

}
