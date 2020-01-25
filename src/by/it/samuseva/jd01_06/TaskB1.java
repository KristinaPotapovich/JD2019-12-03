package by.it.samuseva.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            String word = m.group();
            if (findWord(word)) System.out.println(word);

        }

    }
    private static final String liters = "уеыаоэяиюёУЕЫАОЭЯИЮЁ";
    private static boolean findWord(String word) {
        if (word!=null &&
           (word.length()>1) &&
           (liters.indexOf(word.charAt(0)) < 0) &&
           (liters.indexOf(word.charAt(word.length()-1)) >= 0)){
            return true;
        }

        return false;
    }
}
