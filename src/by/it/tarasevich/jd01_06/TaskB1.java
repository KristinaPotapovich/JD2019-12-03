package by.it.tarasevich.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]{2,}+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String result = matcher.group();
            if (test(result)) {
                System.out.println(result);
            }
        }
    }

    public static boolean test(String result) {
        result = result.toLowerCase();
        char first = result.charAt(0);
        char last = result.charAt(result.length() - 1);
        if (first == 'а' || first == 'у' || first == 'е' || first == 'ы' || first == 'о' || first == 'э' || first == 'я' || first == 'и'
                || first == 'ю' || first == 'ё') {
            return false;
        }
        if (last == 'а' || last == 'у' || last == 'е' || last == 'ы' || last == 'о' || last == 'э' || last == 'я' || last == 'и'
                || last == 'ю' || last == 'ё') {
            return true;
        }
        return false;
    }
}