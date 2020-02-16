package by.it.lozouski.jd01_12;

import java.util.*;

class TaskB3 {
    //метод для заполнения коллекции
    static void genericArrayPlayers(List<String> listForGenerate, int quantityPlayers) {
        for (int i = 1; i <= quantityPlayers; i++) {
            listForGenerate.add("Player №" + i);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayOfPeoples = new ArrayList<>();//создадим arrayList
        LinkedList<String> linkedArrOfPeoples = new LinkedList<>();//сделаем тоже для linkedList
        genericArrayPlayers(arrayOfPeoples, 50000);//заполним arrayList
        genericArrayPlayers(linkedArrOfPeoples, 50000);//заполним linkedList

        long beginTimeArrayList = System.nanoTime();
        System.out.println("It was created with ArrayList :" + '\n' + process(arrayOfPeoples)); //распечатаем игрока
        long endTimeArrayList = System.nanoTime();
        System.out.println("Run time: " + (endTimeArrayList - beginTimeArrayList) / 1000 + " mcs." + '\n');

        long beginTimeLinkedList = System.nanoTime();
        System.out.println("It was created with LinkedList :" + '\n' + process(linkedArrOfPeoples));// аналогично
        long endTimeLinkedList = System.nanoTime();
        System.out.println("Run time: " + (endTimeLinkedList - beginTimeLinkedList) / 1000 + " mcs." + '\n');

    }

    static String process(ArrayList<String> peoples) {
        boolean flag = false;//создаем флаг, который будет указывать на каждого 2го игрока
        while (peoples.size() > 1) {//повторяем, пока размер нашей коллекции будет > 1
            Iterator<String> iterator = peoples.iterator();// создаем итератор
            while (iterator.hasNext()) {//Итератор, пока есть элементы...
                iterator.next();//...верни объект, который видишь, из коллекции
                if (flag) {//если флаг true...
                    iterator.remove();//...итератор, удали игрока...он четный по счету
                    flag = false; //Затем верни флаг на false, ведь следующий обьект нечетный.
                } else
                    flag = true;//...а иначе это нечетный обьект коллекции, ставим true для следующего обьекта, он соотв. будет четным.
            }
        }
        return peoples.get(0);//у нас в итоге останеться 1 элемент в коллекции, его и вернем по 0му индексу в качестве строки.
    }

    static String process(LinkedList<String> peoples) {
        Deque<String> result = new LinkedList<>(peoples); //создаем двунаправленную очередь передав входной linkedList
        boolean flag = false; //создаем флаг
        while (result.size() > 1) {////повторяем, пока размер нашей коллекции будет > 1
            if (flag) {//если флаг true///
                result.removeFirst();//удаляем первый элемент из коллекции.
                flag = false;// возвращаем флаг обратно на false, для дальнейших итераций
            } else {//иначе
                result.add(result.removeFirst());//добавляем в конец коллекции элемент,удаленный из начала
                flag = true;// ставим флаг на true
            }
        }
        return result.getFirst();//вернем оставшийся элемент в качестве строки.
        /*
        Как работает:
        Например у нас есть лист {1,2,3,4,5,6,7,8,9}
        поэтапно:
        {2,3,4,5,6,7,8,9,1} 1 добавили в конец, удалив с начала
        {3,4,5,6,7,8,9,1} - удалили 2
        Проходя итерацию за итерацией будем получать
        {4,5,6,7,8,9,1,3} - 3 добавили в конец, удалив с начала
        {5,6,7,8,9,1,3} - удалили 4
        {6,7,8,9,1,3,5} - 5 добавили в конец, удалив с начала
        {7,8,9,1,3,5} - удалили 6
        {8,9,1,3,5,7} - 7 добавили в конец, удалив с начала
        {9,1,3,5,7} - удалили 8
        {1,3,5,7,9} - 9 добавили в конец, удалив с начала
        {3,5,7,9} - удалили 1
        {5,7,9,3} - 3 добавили в конец, удалив с начала
        {7,9,3} - удалили 5
        {9,3,7} - 7 добавили в конец, удалив с начала
        {3,7} - удалили 9
        {7,3} - 7 добавили в конец, удалив с начала
        {3} - удалили 7
        остался 1 элемент, выходим с цикла.
        возвращаем результат.
        */
    }
}
