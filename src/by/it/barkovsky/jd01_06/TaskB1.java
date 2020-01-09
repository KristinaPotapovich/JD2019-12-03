package by.it.barkovsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{1,}");
        StringBuilder varText = new StringBuilder(Poem.text);
        Matcher matcher = p.matcher(varText);
        while (matcher.find()){
            String word = matcher.group();
            process(word);
        }

    }

    private static void process(String word) {
        if (word.length()>1){
            char first = word.toLowerCase().charAt(0);
            char last = word.toLowerCase().charAt(word.length()-1);
            if((first>'а' && first<'е' || first>'е' && first<'и' || first>'и' && first<'о' || first>'о' && first<'у' || first>'у' && first<'ы') &&
                    (last=='а' || last=='е' || last=='ё' || last=='и' || last=='о' || last=='у' || last=='ы' || last=='э' || last=='ю' || last=='я' )
            ) System.out.println(word);
        }

    }
}
