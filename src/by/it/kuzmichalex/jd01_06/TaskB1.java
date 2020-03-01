package by.it.kuzmichalex.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author kuzmichalex
 * Тестовое задание B1 Вывод слов поэмы, начинающихся солгасной буквой и заканчивающейся гласной
 * */
public class TaskB1 {
    public static void main(String[] args) {
        Pattern patternRussianWord =Pattern.compile("[А-Яа-яЕё]{1,}");
        Matcher russianWord = patternRussianWord.matcher(Poem.text);
        while(russianWord.find())
        {
            if (checkWord(russianWord.group())) System.out.println(russianWord.group());
        }
    }
    /**
     * @author kuzmichalex
     * Проверка слова. Должно начинаться согласной буквой и заканчиваться гласной. регулярные не использовать.
     * @param wordToCheck проверяемое слова
     * @return true если слово начинается с согласной буквы и заканчивается гласной
     * */
    private static boolean checkWord(String wordToCheck) {
        final String aaaLetters="АЕЁИОУЫЭЮЯ";    //Их так мало. Кто бы мог подумать!
        final String bbbLetters="БВГДЖЗЙКЛМНПРСТФХЦЧШЩЬЪ";      //Дада. Я в курсе, что можно обойтись одним массивом.
        if(wordToCheck.length()<1)return false;
        StringBuffer letter = new StringBuffer();
        letter.append(wordToCheck.toUpperCase().charAt(0));
        if(aaaLetters.contains(letter))return false;
        letter.setCharAt(0, wordToCheck.toUpperCase().charAt(wordToCheck.length()-1));
        if(bbbLetters.contains(letter))return false;
        return true;
    }
}
