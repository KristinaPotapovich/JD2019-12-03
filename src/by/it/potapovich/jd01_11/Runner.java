package by.it.potapovich.jd01_11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List <String> myList = new ListA<>();
        List <String> arList = new ArrayList<>();

        myList.add("First"); arList.add("First");
        myList.add("Two"); arList.add("Two");
        myList.add("Four"); arList.add("Four");
        System.out.println("myList add"+myList+"\narList" + arList);
        myList.add(2,"Three"); arList.add(2,"Three");
        myList.add(0,"Start"); arList.add(0,"Start");
        System.out.println("myList add"+myList+"\narList" + arList);
        myList.remove("Start"); arList.remove("Start");
        myList.remove(2); arList.remove(2);
        System.out.println("myList remove"+myList+"\narList" + arList);
        System.out.println("myList(0) get" + myList.get(0) + "\narList" + arList.get(0));
        List <String> ownList = new ListB<>();
        ownList.add("First"); arList.add("First");
        ownList.add("Two"); arList.add("Two");
        ownList.add("Four"); arList.add("Four");
        System.out.println("ownList add"+ownList+"\narList" + arList);
        System.out.println();

        ownList.add(2,"Three"); arList.add(2,"Three");
        ownList.add(0,"Start"); arList.add(0,"Start");
        System.out.println("ownList add ()"+ ownList +"\narList" + arList);
        System.out.println();

        ownList.remove("Start"); arList.remove("Start");
        ownList.remove(2); arList.remove(2);
        System.out.println("ownList remove "+ownList+"\narList " + arList);
        System.out.println();

        System.out.println("ownList(0) remove" + ownList.get(0) + "\narList" + arList.get(0));
        System.out.println();

        ownList.set(1,"Copy");
        arList.set(1,"Copy");
        System.out.println("ownList set" + ownList + "\narList" + arList);
        System.out.println();


        ownList.addAll(arList);arList.addAll(ownList);
        System.out.println("addAll ownList " + ownList + "\naddAll arList" + arList);



    }
}
