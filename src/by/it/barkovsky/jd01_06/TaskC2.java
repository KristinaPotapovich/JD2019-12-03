package by.it.barkovsky.jd01_06;

import java.util.Random;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long startSlow = System.currentTimeMillis();
        System.out.println(slow(Poem.text));
        long endSlow = System.currentTimeMillis();

        long startFast = System.currentTimeMillis();
        System.out.println(fast(Poem.text));
        long endFast = System.currentTimeMillis();

        System.out.println("Slow = " + (endSlow - startSlow));
        System.out.println("Fast = " + (endFast - startFast));
    }

    private static String fast(String text) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pat = Pattern.compile("[^а-яёА-ЯЁ]+");
        String[] wordsArray = pat.split(sb);
        Random rnd = new Random(0);
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < 70000; i++) {
            strB.append(wordsArray[rnd.nextInt(wordsArray.length)]).append(" ");
        }
        return strB.toString();
    }

    private static String slow(String text) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pat = Pattern.compile("[^а-яёА-ЯЁ]+");
        String[] wordsArray = pat.split(sb);
        Random rnd = new Random(0);
        String str = "";
        for (int i = 0; i < 70000; i++) {
            str += wordsArray[rnd.nextInt(wordsArray.length)] + " ";
        }
        return str;
    }

}