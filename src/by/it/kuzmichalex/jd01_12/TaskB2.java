package by.it.kuzmichalex.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Считалка
 * */

public class TaskB2 {

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
                //System.out.println(returnStr + (isSecond?" is second":""));
                if(isSecond) iterator.remove();
            }
        }
        peoples.add(returnStr);
        return returnStr;
    }


    /**
     * Считалка по ArrayList
     * @param peoples LinkedList с именами
     * @return имя победителя
     * */
    static String process(ArrayList<String> peoples){
        boolean isSecond=true;
        String returnStr = new String();
        while(!peoples.isEmpty()) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                isSecond^=true;
                returnStr = iterator.next();
                //System.out.println(returnStr + (isSecond?" is second":""));
                if(isSecond) iterator.remove();
            }
        }
        peoples.add(returnStr);
        return returnStr;
    }

    public static void main(String[] args) {
        LinkedList<String> linkedNames = new LinkedList<>();
        ArrayList<String> arrayNames = new ArrayList<>();
        generateNames(linkedNames,5);
        generateNames(arrayNames,5);
        System.out.println("LinkedList-------------");
        System.out.println(process(linkedNames));
        System.out.println("ArrayL-----------------");
        System.out.println(process(arrayNames));
    }
}
