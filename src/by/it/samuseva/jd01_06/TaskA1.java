package by.it.samuseva.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder text = new StringBuilder(Poem.text);
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            int start = m.start();
            text.setCharAt(start+3,'#');
            if (m.group().length()>=7) text.setCharAt(start+6,'#');
        }
        System.out.println(text);


    }
}
