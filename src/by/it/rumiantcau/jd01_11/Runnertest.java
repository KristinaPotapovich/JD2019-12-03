package by.it.rumiantcau.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runnertest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Vasya");
        list.add("Petya");
        list.add("Katya");
        list.add("Sasha");
        list.addAll(list);


        List<String> list1 = new ArrayList<>();
        list1.add("1Vasya");
        list1.add("2Petya");
        list1.add("3Katya");
        list1.add("4Sasha");
      //  list1.addAll(5, list);
        list1.addAll(list);
        System.out.println(list1);





    }


}
