package by.it.busel.jd01_12;

import java.util.*;

class TaskB3 {
    public static class Timer {
        private long iniTime;
        private Double Delta;

        Timer() {
            iniTime = System.nanoTime();
        }

        public void start() {
            iniTime = System.nanoTime();
        }

        public String stop() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            return Delta.toString();
        }

        @Override
        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "has been found in " + Delta.toString() + " microseconds.";
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrlist = new ArrayList<String>();
        LinkedList<String> linlist = new LinkedList<String>();
        int capacity = 4096;
        listsFiller(arrlist, capacity);
        listsFiller(linlist, capacity);
        Timer timer = new Timer();
        timer.start();
        String lastFromArrList = process(arrlist);
        String lapTimeArr = timer.stop();
        System.out.println("The survivor from an ArrayList has been caught in " + lapTimeArr + " microseconds");
        timer.start();
        String lastFromLinList = process(linlist);
        String lapTimeLink = timer.stop();
        System.out.println("The survivor from a LinkedList has been caught in " + lapTimeLink + " microseconds.");
        /*
        The output:
        The survivor from an ArrayList has been caught in 9891.471 microseconds
        The survivor from a LinkedList has been caught in 3491.47 microseconds.

        The execution of "process(ArrayList<String> peoples)" is longer than
        the execution of "process(LinkedList<String> peoples" due to the following;
        - an ArrayList has in its structure a storage of values, i.e. an array, so
        after a removal of the second element it is essential to re-establish the connection between the previous and
        the next element of the recently removed element, it's possible using method System.arraycopy(...), by copying
        the elements in a memory;
        - on the contrary, in order to remove an element a LinkedList we needn't copy elements, the only thing to do is
        to change the reference of the previous and the next elements of the recently removed element of a container;
         */
    }

    private static void listsFiller(List<String> list, int capacity) {
        String name = list.getClass().getName();
        for (int i = 0; i < capacity; i++) {
            list.add(name + i);
        }
    }

    private static List<String> randomStringsAsList(int capacity) {
        String[] sample = new String[capacity];
        for (int i = 1; i < capacity; i++) {
            sample[i] = "n" + i;
        }
        return Arrays.asList(sample);
    }

    private static String process(ArrayList<String> peoples) {
        ArrayList<String> result = new ArrayList<>(peoples);
        boolean second = false;
        while (result.size() > 1) {
            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (second) {
                    iterator.remove();
                    second = false;
                } else {
                    second = true;
                }
            }
        }
        return result.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        LinkedList<String> result = new LinkedList<>(peoples);
        boolean second = false;
        while (result.size() > 1) {
            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (second) {
                    iterator.remove();
                    second = false;
                } else {
                    second = true;
                }
            }
        }
        return result.get(0);
    }
}
