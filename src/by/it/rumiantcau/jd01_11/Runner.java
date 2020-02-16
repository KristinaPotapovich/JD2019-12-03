package by.it.rumiantcau.jd01_11;

import java.util.List;

public class Runner {

    public static void main(String[] args) {



        List<String> list1 = new ListB<>();
        list1.add("1Vasya");
        list1.add("2Petya");
        list1.add("3Katya");
        list1.add("4Sasha");
        System.out.println(list1);
      //  list1.addAll(5, list);
      //  list1.addAll(list);
      //  list1.addAll(2, list);
        list1.add(0, "qqqq");
        System.out.println(list1);





    }


}
