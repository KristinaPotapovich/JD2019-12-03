package by.it.samuseva.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] count = new int[0];

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        //StringBuilder text = new StringBuilder(Poem.text);
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            String word = m.group();
            int posX = pos(word);
            if (posX>=0) {
                count[posX]++;
            }
            else {
                int last = words.length;
                words =Arrays.copyOf(words,last+1);
                words[last] = word;
                count = Arrays.copyOf(count, last+1);
                count[last] = 1;
            }
        }
         for (int i = 0; i < words.length; i++) {
             System.out.printf("%s=%d\n", words[i], count[i]);
         }
        System.out.println();
    }

    private static int pos (String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word))
                return i;
        }
        return -1;
    }

}
