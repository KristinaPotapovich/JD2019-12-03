package by.it.kuzmichalex.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Подсчёт количества вхожджений слов в тексте
 * слова isn't и don't считаются одинаковыми
 */
public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> lexicon = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        //Поди знай, что за текст нам предложат. лучше повторю-ка я матчеры с паттернами :)
        Pattern engWordPattern = Pattern.compile("[A-Za-z']+");
        boolean bEndFound = false;
        while (!bEndFound) {
            String inputString = scanner.next();
            Matcher engWordMatcher = engWordPattern.matcher(inputString);
            while (engWordMatcher.find()) {
                String engWord = engWordMatcher.group();
                if (engWord.equals("end")) {
                    bEndFound = true;
                    break;
                }
                //Какое-то слово есть. работаем.
                if (engWord.equals("isn't")) engWord = "don't";
                Integer previous = lexicon.get(engWord);
                lexicon.put(engWord, (previous == null ? 1 : previous + 1));
            }
        }
        //Покажем, что там наработали. Спасибо Idea за аккуратный for. Сам-то я на 5 строчек больше родил!
        for (Map.Entry<String, Integer> next : lexicon.entrySet()) {
            System.out.println(next.getKey() + "=" + next.getValue());
        }
    }
}
