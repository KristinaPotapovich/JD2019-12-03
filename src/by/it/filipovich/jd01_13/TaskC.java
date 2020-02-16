package by.it.filipovich.jd01_13;

import java.util.*;

class TaskC {
    static List<Double> list = new LinkedList<>();
    static Scanner scannerOne;

    public static void main(String[] args) throws InterruptedException {
        scannerOne = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        TaskC taskC = new TaskC();
        int count = 0;
        boolean a=true;
        while (a) {
            try {
                String next = scannerOne.next();
                double number = Double.parseDouble(next);
                list.add(number);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                Collections.reverse(list);
                System.out.println(taskC);
                Collections.reverse(list);
                count++;
            } finally {
                if (count == 5) {
                    Collections.reverse(list);
                    System.out.println(taskC);
                    throw new InterruptedException();
                }
            }
        }
    }
//
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        String del = "";
        for (Double aDouble : list) {
            sb.append(del).append((double) aDouble);
            del = " ";
        }
        return sb.toString();
    }
}