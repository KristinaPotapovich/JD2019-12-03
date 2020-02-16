package by.it.filipovich.jd01_12;

import java.util.*;

public class TaskB2 {
    private List<String> names1 = new ArrayList<>();
    private List<String> names2 = new LinkedList<>();
    private int number;

    public TaskB2(int number){
        this.number = number;
    }

    public static void main(String[] args) {
        TaskB2 taskB2 = new TaskB2(11);
        for (int i = 0; i < taskB2.number; i++) {
            taskB2.names1.add("Human"+(i+1));
            taskB2.names2.add("Human"+(i+1));
        }

        System.out.println(process((ArrayList<String>) taskB2.names1));
        System.out.println(process((LinkedList<String>) taskB2.names2));



    }

    static String process(ArrayList<String> peoples){
        ArrayList<String> copyOfPeoples = new ArrayList<>(peoples);
        boolean marker = false;
        while(copyOfPeoples.size()>1){
            Iterator<String> iterator = copyOfPeoples.iterator();
            while (iterator.hasNext()){
            iterator.next();

                if (marker==false) {
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

    static String process(LinkedList<String> peoples){
            LinkedList<String> copyOfPeoples = new LinkedList<>(peoples);
            boolean marker = false;
        while(copyOfPeoples.size()>1){
            ListIterator<String> iterator = copyOfPeoples.listIterator();
            while (iterator.hasNext()){
                    iterator.next();

                    if (marker==false) {
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
