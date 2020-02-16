package by.it.tarasevich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        myList.add("mama");
        myList.add("papa");
        myList.add("daughter");
        myList.add("sun");
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
    }
}