package by.it.rumiantcau.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static boolean methodB1(String slovoPoema){
        int dlinnaSlova = slovoPoema.length();
        if (dlinnaSlova > 1) {
            String glasnye = "яиюыаоэуеёЯИЮЫАОЭУЕЁ";
            String soglasnye = "чсмтьбфвпрлджйцкнгшщзхъЧСМТЬБФВПРЛДЖЙЦКНГШЩЗХЪ";
            String firstLetter = String.valueOf(slovoPoema.charAt(0));
            String lastLetter = String.valueOf(slovoPoema.charAt(dlinnaSlova-1));
            return ((soglasnye.contains(firstLetter)) && (glasnye.contains(lastLetter)));}
        else return false;
    }

    public static void main(String[] args) {
//подразобраться с регулярками все еще не до конца одупляю
        String regex = "[А-Яа-яЕё]{1,}";
        Pattern slovaRegex =Pattern.compile(regex);
        Matcher slova = slovaRegex.matcher(Poem.text);

        while(slova.find()) {
            if (methodB1(slova.group())) System.out.println(slova.group());
            }

    }
}
