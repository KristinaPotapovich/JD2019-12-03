package by.it.lozouski.jd01_11;

import java.util.*;

class Runner {
    public static void main(String[] args) {
        List<String> myTestListA = new ListA<>();
        List<String> javaTestListA = new ArrayList<>();
        //------------This is my collection------------//
        myTestListA.add("Alex");
        myTestListA.add("Andrew");
        myTestListA.add("Maksim");
        myTestListA.add("Viktor");
        //------
        javaTestListA.add("Alex");
        javaTestListA.add("Andrew");
        javaTestListA.add("Maksim");
        javaTestListA.add("Viktor");
        //Test add:
        System.out.println("JAVA: " + javaTestListA);
        System.out.println("My:   " + myTestListA);
        //Test remove (index):
        myTestListA.remove(2);
        javaTestListA.remove(2);
        System.out.println("JAVA: " + javaTestListA);
        System.out.println("My:   " + myTestListA);
        //Test get (index)
        String test = myTestListA.get(1);
        String test2 = javaTestListA.get(1);
        System.out.println("JAVA: " + test);
        System.out.println("My:   " + test2);
        //----------B tasks:--------------//
        List<String> myTestListB = new ListB<>();
        List<String> javaTestListB = new ArrayList<>();
        myTestListB.add("Alex");
        myTestListB.add("Andrew");
        myTestListB.add("Maksim");
        myTestListB.add("Viktor");
        //------
        javaTestListB.add("Alex");
        javaTestListB.add("Andrew");
        javaTestListB.add("Maksim");
        javaTestListB.add("Viktor");

        javaTestListB.set(1, "Maria");
        javaTestListB.set(2, "Natalie");
        myTestListB.set(1, "Maria");
        myTestListB.set(2, "Natalie");
        System.out.println("JAVA: " + javaTestListB);
        System.out.println("My:   " + myTestListB);
        //---------
        myTestListB.add(1, "TEST");
        System.out.println("My:   " + myTestListB);
        //---------
        myTestListB.addAll(javaTestListB);
        System.out.println(myTestListB);
        System.out.println(myTestListB.contains("TEST"));
        ////////////////////////////////////////////////////////////
        //taskC
        Set<Integer> myTest = new SetC<>();
        Set<Integer> javaTest = new HashSet<>();
        javaTest.add(1);
        javaTest.add(2);
        javaTest.add(3);
        javaTest.add(4);
        javaTest.add(5);
        javaTest.add(6);

        myTest.add(1);
        myTest.add(2);
        myTest.add(3);
        myTest.add(4);
        myTest.add(5);
        myTest.add(6);
        System.out.println(javaTest + " --- print collection");
        System.out.println(myTest + " --- print collection");
        //-----------
        javaTest.remove(2);
        myTest.remove(2);
        System.out.println(javaTest + " --- remove object");
        System.out.println(myTest + " --- remove object");
        //-----------
        System.out.println("Object 3: " + javaTest.contains(3) + " |||| Object 10: " + javaTest.contains(10) + " --- contains test");
        System.out.println("Object 3: " + myTest.contains(3) + " |||| Object 10: " + myTest.contains(10) + " --- contains test");
        //-----------
        System.out.println(javaTest.size() + " --- size test JAVA");
        System.out.println(myTest.size() + " --- size test MY");
        //-----------
        System.out.println(javaTest.isEmpty() + " --- test isEmpty()");
        System.out.println(myTest.isEmpty() + " --- test isEmpty()");
        //-----------
        myTest.removeAll(javaTest);
        System.out.println(myTest + " --- remove all test");
        javaTest.clear();
        System.out.println(javaTest);

    }
}
