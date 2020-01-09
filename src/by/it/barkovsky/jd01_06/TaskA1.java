package by.it.barkovsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder varText = new StringBuilder(Poem.text);
        Matcher matcher = p.matcher(varText);
        while (matcher.find()){
            int start = matcher.start();
            varText.setCharAt((start+3),'#');
            if(matcher.end()-start >=7){
                varText.setCharAt((start+6),'#');
            }
        }
        System.out.println(varText);
    }
}
