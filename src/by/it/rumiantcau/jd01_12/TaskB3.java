package by.it.rumiantcau.jd01_12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) throws IOException {
      //  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       // int n = Integer.parseInt(input.readLine());
        ArrayList<String> peopleAS = new ArrayList<String>();
        LinkedList<String> peopleLL = new LinkedList<>();

        for (int i = 0; i < 4096; i++) {
            String name = "name" + i;
            peopleAS.add(name);
            peopleLL.add(name);

        }
        process(peopleAS);
        process(peopleLL);
        processWithoutIterator(peopleLL);
    }

    static String process(ArrayList<String> peoples){
        int i = 1;
        long time = System.nanoTime();
        while (peoples.size() != 1){
            Iterator<String> iterator = peoples.iterator();
            while(iterator.hasNext()){
                iterator.next();
                if ((i % 2) == 0) {
                    iterator.remove();
                }
                i++;
            }
        }
        System.out.println("Время работы ArrayList " + (System.nanoTime() - time));
        return String.valueOf(peoples.get(0));
    }


    static String process(LinkedList<String> peoples){
        int i = 1;
        long time = System.nanoTime();
        while (peoples.size() != 1){
            Iterator<String> iterator = peoples.iterator();
            while(iterator.hasNext()){
                iterator.next();
                if ((i % 2) == 0) {
                    iterator.remove();

                }
                i++;
            }
        }
        System.out.println("Время работы LinkedList " + (System.nanoTime() - time));
        return String.valueOf(peoples.get(0));
    }

    static String processWithoutIterator(LinkedList<String> peoples){
        int i = 1;
        int size;
        long time = System.nanoTime();
        while (peoples.size() != 1){
            size =  peoples.size();
            for (int j = 0; j < size; j++) {
                if ((i % 2) == 0) {
                    peoples.remove(j);
                    size--;
                }
                i++;
            }
        }
        System.out.println("Время работы LinkedList без итератора " + (System.nanoTime() - time));
        return String.valueOf(peoples.get(0));
    }

}
