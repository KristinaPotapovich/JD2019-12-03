package by.it.samuseva.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set list1 = new HashSet<>();
        list1.add(7);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(4);
        list1.add(6);
        list1.add(1);
        Set list = new HashSet();
        list.add("3");
        list.add("0");
        list.add("9");
       /* list1.add("Apple");
        list1.add("Orange");
        list1.add("Banana");
        list1.add("Pear");
        list1.add("Grape");
        list1.add("Lemon");
        list1.add("Figs");*/
        System.out.println(list1);
        list1.addAll(list);
        System.out.println(list1);


        Set myList = new SetC();
        myList.add(7);
        myList.add(2);
        myList.add(3);
        myList.add(5);
        myList.add(4);
        myList.add(6);
        myList.add(1);
      /*  myList.add("Apple");
        myList.add("Orange");
        myList.add("Banana");
        myList.add("Pear");
        myList.add("Grape");
        myList.add("Lemon");
        myList.add("Figs");*/
        System.out.println(myList);
        myList.addAll(list);
        System.out.println(myList);

       /* List list = new ArrayList();
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");
        list.add("Pear");
        list.add("Grape");
        list.add("Lemon");
        list.add("Figs");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(2));
        list.set(0, "Pineapple");
        System.out.println(list);
        System.out.println(list.set(0, "Apple"));
        System.out.println(list);
        list.add(3, "Pineapple");
        System.out.println(list);
        List list1 = new ArrayList();
        list1.add("Mango");
        list1.add("Pineapple");
        list1.add("Papaya");
        list.addAll(list1);
        System.out.println(list);



        List myList = new ListB();
        myList.add("Apple");
        myList.add("Orange");
        myList.add("Banana");
        myList.add("Pear");
        myList.add("Grape");
        myList.add("Lemon");
        myList.add("Figs");
        System.out.println(myList);
        myList.remove(3);
        System.out.println(myList);
        System.out.println(myList.get(2));
        myList.set(0, "Pineapple");
        System.out.println(myList);
        System.out.println(myList.set(0, "Apple"));
        System.out.println(myList);
        myList.add(6, "Pineapple");
        System.out.println(myList);
        myList.addAll(list1);
        System.out.println(myList);*/



    }
}
