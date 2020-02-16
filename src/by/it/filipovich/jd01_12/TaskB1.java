package by.it.filipovich.jd01_12;

import java.util.*;

public class TaskB1 {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        String[] words = new String[]{};
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true){
            String str = scanner.nextLine();
            if(str.equals("end"))
                break;
            sb.append(" ").append(str);
        }
        words = sb.toString().trim().replaceAll("[^a-zA-Z']+", " ")
                .replaceAll(" {2,}", " ")
                .split(" ");

        for (String word : words) {
            if(map.get(word) == null)
            map.put(word,1);
            else
                map.put(word,map.get(word)+1);

//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
//                while (iter.hasNext()) {
//                    if (!(word.equals(entry.getKey()))) {
//                        map.put(word, 1);
//                    } else
//                        map.put(word, map.get(word) + 1);
//                }
//            }
        }
        System.out.println(map.entrySet());
    }

    @Override
    public String toString() {
        return "TaskB1{" +
                "map=" + map +
                '}';
    }

    public String toString(String[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length-1; i++) {
            sb.append(arr[i]).append(",");
        }
        sb.append(arr[arr.length-1]).append("]");
        return sb.toString();
    }
}
