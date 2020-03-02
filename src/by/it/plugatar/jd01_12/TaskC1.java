package by.it.plugatar.jd01_12;

import java.util.*;
/* «сжать» список C1, удаляядублирующийся наименования объектов.
Выведите полученный ассоциативный массив в консоль*/
public class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> list = new TreeMap<>();
        int k = 1;
        String word;
        while(sc.hasNext() && !(word = sc.next()).equals("end")){
            list.put(k++, word);
        }
        System.out.println("Сначала: " + list);
        HashSet<String> names = new HashSet<>();
        Iterator<String> iterator = list.values().iterator();
        while (iterator.hasNext()){
            if (!names.add(iterator.next())){
                iterator.remove();
            }
        }
        System.out.println("После: " + list);
    }
}