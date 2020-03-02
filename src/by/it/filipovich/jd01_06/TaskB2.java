package by.it.filipovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String poem = Poem.text.replaceAll("\n", " ")
                                .replaceAll("\\.\\.\\.", "");
        Pattern pattern = Pattern.compile("[^.!?]+");
        Matcher matcher = pattern.matcher(poem);
        String[] str = new String[0];
        while(matcher.find()) {
            String sentence = matcher.group().replaceAll("[^а-яА-ЯёЁ]"," ").
                    replaceAll(" {2,}", " ").trim();

            int lastString = str.length;
            str = Arrays.copyOf(str, str.length+1);
            str[lastString] = sentence;
        }
        sortByLength(str);

        for (String s : str) {
            System.out.println(s);
        }
    }

    private static void sortByLength(String[] str) {
        for (int i = str.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if (str[j].length() > str[j + 1].length()) {
                    String temp = str[j + 1];
                    str[j + 1] = str[j];
                    str[j] = temp;
                }
            }
        }
    }

}
