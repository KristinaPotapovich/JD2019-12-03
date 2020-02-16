package by.it.rumiantcau.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLL {


        public static void main(String[] args) {
            List<Integer> random = new ArrayList<>(100000);
            int n = 1000000;
            for (int i = 0; i < n; i++) {
                random.add((int) (Math.random() * 2 * n - n));
            }
        List<Integer> list=new ArrayList<>();
        int positionZero=0;
        int j;
        long timeAL = System.nanoTime();

            for (int i = 0; i < n; i++) {
                j = random.get(i);
                if (j <0){
                    list.add(j);
                }
                else if (j==0) {
                    list.add(positionZero,j);
                }
                else {
                    list.add(positionZero++,j);
                }
            }

        timeAL = System.nanoTime() - timeAL;

        System.out.println("Время работы Эррей листа на 100к числах " + timeAL);
//Реализуем на Линкед листе ради смеха посмотреть на скорость
            LinkedList<Integer> listLL=new LinkedList<>();
            List<Integer> listLL2=new LinkedList<>();
            long timeLL = System.nanoTime();

            for (int i = 0; i < n; i++) {
                if (i==0) {
                    listLL.add(i);
                }
                else {
                    listLL2.add(i);
                }
            }
            for (int i = 0; i < listLL2.size(); i++) {
                if (listLL2.get(i) < 0){
                    listLL.add(listLL2.get(i));
                }
                else
                    listLL.addFirst(listLL2.get(i));
            }
            timeLL = System.nanoTime() - timeLL;

            System.out.println("Время работы Линкед Листа на 100к числах " + timeLL);


        }

    }


