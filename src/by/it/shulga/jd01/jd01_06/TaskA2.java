package by.it.shulga.jd01.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class   TaskA2 {

              private static String[] words = new String[0];
              private static int[] counters = new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()) {
            String word = matcher.group();
            int p = process(word);
            if (p >= 0) {
                counters[p]++;
            } else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = word;
                counters = Arrays.copyOf(counters, last + 1);
                counters[last] = 1;
            }
        }
           for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+counters[i]);
        }
    }

      private static int process(String word) {
         for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}

