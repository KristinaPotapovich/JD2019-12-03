package by.it.lozouski.jd01_12;

import java.util.*;

class TaskB2 {
    public static void main(String[] args) {
        String[] arrPeople = {"Andrew", "Vasili", "Maksim", "Pavel", "Ivan", "Petr", "Vlad", "Oleg", "Dima"};//массив имен игроков
        ArrayList<String> arrayOfPeoples = new ArrayList<>(Arrays.asList(arrPeople));//заполним arrayList передав наш массив
        LinkedList<String> linkedArrOfPeoples = new LinkedList<>(Arrays.asList(arrPeople));//сделаем тоже для linkedList
        System.out.println(process(arrayOfPeoples)); //распечатаем
        System.out.println(process(linkedArrOfPeoples));// аналогично
    }
    static String process(ArrayList<String> peoples){
        boolean flag = false;//создаем флаг, который будет указывать на каждого 2го игрока
        while (peoples.size() > 1) {//повторяем, пока размер нашей коллекции будет > 1
            Iterator<String> iterator = peoples.iterator();// создаем итератор
            while (iterator.hasNext()){//Итератор, пока есть элементы...
                iterator.next();//...верни объект, который видишь, из коллекции
                if (flag){//если флаг true...
                    iterator.remove();//...итератор, удали игрока...он четный по счету
                    flag = false; //Затем верни флаг на false, ведь следующий обьект нечетный.
                }else flag = true;//...а иначе это нечетный обьект коллекции, ставим true для следующего обьекта, он соотв. будет четным.
            }
        }
        return peoples.get(0);//у нас в итоге останеться 1 элемент в коллекции, его и вернем по 0му индексу в качестве строки.
    }
    //тоже самое...
    static String process(LinkedList<String> peoples){
        boolean flag = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if (flag){
                    iterator.remove();
                    flag = false;
                }else flag = true;
            }
        }
        return peoples.get(0);
    }
}
