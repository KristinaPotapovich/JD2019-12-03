package by.it.tarasevich.jd01_12;


;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in); //считываем текст
        while (true) {
            String str = scanner.nextLine();
            String[] line = str.split("[^A-Za-z']+");
            if (str.equals("end")) break;
            for (String word : line) {
                if (map.containsKey(word)) {
                    Integer integer = map.get(word);
                    integer++;
                    map.put(word, integer);
                } else {
                    map.put(word, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> values : map.entrySet()) {
            System.out.println(values.getKey() + "=" + values.getValue());
        }
    }
}
