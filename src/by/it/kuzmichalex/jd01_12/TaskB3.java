package by.it.kuzmichalex.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {

    /**
     * Генерация имён. Такие имена будут в ходу в будущем, когда какой-то робот поумнеет настолько,
     * что с лязгом взгромоздится на убогий броневик модели Tesla Cyber Track, толкнёт речь
     * и возъмёт власть в свои руки методом свержения угнетающего класса, то есть человеков.
     * @param list Куда записать новые имена.
     * @param count Сколько имён придумать
     * */
    static void generateNames(List<String> list, int count){
        list.clear();
        for (int i = 0; i <count ; i++) list.add("Robot-" + Integer.toHexString(i));
    }
    /**
     * Считалка по линкедлисту
     * @param peoples LinkedList с именами
     * @return имя победителя
     * */
    static String process(LinkedList<String> peoples){
        boolean isSecond=true;
        String returnStr = new String("EMPTY LIST!!!");
        while(!peoples.isEmpty()) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                isSecond^=true;
                returnStr = iterator.next();
                if(isSecond) iterator.remove();
            }
        }
        return returnStr;
    }


    /**
     * Считалка по ArrayList
     * @param peoples LinkedList с именами
     * @return имя победителя
     * */
    static String process(ArrayList<String> peoples){
        boolean isSecond=true;
        String returnStr = new String("EMPTY LIST!!!");
        while(!peoples.isEmpty()) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                isSecond^=true;
                returnStr = iterator.next();
                if(isSecond) iterator.remove();
            }
        }
        return returnStr;
    }

    public static void main(String[] args) {
        LinkedList<String> linkedNames = new LinkedList<>();
        ArrayList<String> arrayNames = new ArrayList<>();
        generateNames(linkedNames,4096);
        generateNames(arrayNames,4096);

        System.out.println("LinkedList starts.......................");
        long timeLinked = System.nanoTime();
        String process = process(linkedNames);
        timeLinked = System.nanoTime()-timeLinked;
        System.out.println("Linked List process Time: " + timeLinked);
        System.out.println("P.S. Winner name is: " + process);

        System.out.println("ArrayList starts........................");
        long timeArray = System.nanoTime();
        System.out.println(process(arrayNames));
        timeArray = System.nanoTime()-timeArray;
        System.out.println("Array List process Time: " + timeArray);
        System.out.println("P.S. Winner name is: " + process);
        System.out.println("LinkedList is faster when using deleting from BIG collections: "+ (double)timeArray/(double)timeLinked);
        //Потому что удаление из LinkedList не подрузамевает под собой перемещения содержимого массива, как в ArrayList;
        //При увеличении размера массива разнца ещёё более существенна.
        //также установлено, что при размерах массива менее 800 выигрывает ArrayList.

    }
}
