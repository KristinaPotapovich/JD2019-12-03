package by.it.filipovich.jd01_12;

import java.util.*;

public class TaskB3 {
    private ArrayList<String> names1 = new ArrayList<>();
    private LinkedList<String> names2 = new LinkedList<>();
    private int number;

    public TaskB3(int number){
        this.number = number;
    }

    public static void main(String[] args) {
        TaskB3 taskB3 = new TaskB3(4096);
        for (int i = 0; i < taskB3.number; i++) {
            taskB3.names1.add("Human"+(i+1));
            taskB3.names2.add("Human"+(i+1));
        }
        long before = System.nanoTime();
        System.out.println(process(taskB3.names1));
        long after = System.nanoTime();
        System.out.println("Time for ArrayList = "+(after-before));

        long before1 = System.nanoTime();
        System.out.println(process(taskB3.names2));
        long after1 = System.nanoTime();
        System.out.println("Time for LinkedList = "+(after1-before1));


    }

    private static String process(ArrayList<String> peoples){
        ArrayList<String> copyOfPeoples = new ArrayList<>(peoples);
        boolean marker = false;
        while(copyOfPeoples.size()>1){
            Iterator<String> iterator = copyOfPeoples.iterator();
            while (iterator.hasNext()){
                iterator.next();

                if (!marker) {
                    marker = true;
                }
                else {
                    iterator.remove();
                    marker = false;
                }
            }
        }
        return copyOfPeoples.get(0);
    }

    private static String process(LinkedList<String> peoples){
        LinkedList<String> copyOfPeoples = new LinkedList<>(peoples);
        boolean marker = false;
        while(copyOfPeoples.size()>1){
            Iterator<String> iterator = copyOfPeoples.iterator();
            while (iterator.hasNext()){
                iterator.next();

                if (!marker) {
                    marker = true;
                }
                else {
                    iterator.remove();
                    marker = false;
                }
            }
        }

        return copyOfPeoples.get(0);
    }

}
