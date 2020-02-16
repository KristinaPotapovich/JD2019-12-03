package by.it.busel.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            String string = scanner.next().trim();
            if (string.equals("end")) {
                break;
            }
            sb.append(string).append(' ');
        }
        String text = new String(sb);
        Pattern pattern = Pattern.compile("[A-Za-z]+([\'][A-Za-z]+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
