package by.it.cherkas.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static String[] words=new String[0];
    private static int[] counters=new int[0];

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String words=matcher.group();
            if (ok(words))
                System.out.println(words);

        }
    }
            private static final String vowels="аеёоиыуюяАЕЁОИЫУЮЯ";
            private static boolean ok(String words){
                return words!=null && words.length()>1 && vowels.indexOf(words.charAt(0))<0 &&
                        vowels.indexOf(words.length()-1)>=0;
            }
}