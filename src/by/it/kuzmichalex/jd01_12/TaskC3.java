package by.it.kuzmichalex.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    /**
     * Определение, открывающая скобка или нет
     *
     * @param bracket -какая-то скобка
     * @return true, если открывает
     */
    static boolean isOpener(String bracket) {
        final String openers = "([{";
        return openers.contains(bracket);
    }

    /**
     * Возвращает скобку-открыватель для соответствующей скобки-закрывашки
     * Да, можно было бы в хэшмэп. Но не хочется. И наверняка есть где-то метод вроде decode, но времени мало искать.
     *
     * @param bracket закрывающая скобка
     * @return Открывающая скобка для bracket
     */
    static String getOpener(String bracket) {
        if (bracket.equals(")")) return ("(");
        if (bracket.equals("]")) return ("[");
        if (bracket.equals(">")) return (">");
        if (bracket.equals("}")) return ("{");
        return null;
    }

    /*
     * Проверка правильности расстановки скобок. Идея - помещать скобки-открыватели в стек
     * а при встрече скобки-закрывашки из стека должна извлекаться соответствующая открывашка.
     * Если всё правильно, приходим к пустой очереди.
     */
    public static void main(String[] args) {
        boolean bExpressionOk = true;
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        Deque<String> stack = new ArrayDeque<>();
        Pattern bracketsPattern = Pattern.compile("(\\()|(\\))|(\\[)|(\\])|(\\{)|(\\})");
        Matcher bracketMatcher = bracketsPattern.matcher(inputString);
        while (bracketMatcher.find()) {
            String someBracket = bracketMatcher.group();
            if (isOpener(someBracket)) stack.addLast(someBracket);
            else {
                String opener = stack.pollLast();
                if (opener == null) {
                    //System.out.println("не хватает открывающей скобки для " + someBracket);
                    bExpressionOk = false;
                    break;
                }
                if (!opener.equals(getOpener(someBracket))) {
                    bExpressionOk = false;
                    //System.out.println("Закрывающая скобка " + someBracket+ " не имеет соответствующей пары");
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            bExpressionOk = false;
            //System.out.println("Не хватает закрывающих скобок: " + stack);
        }
        System.out.println(bExpressionOk);
    }
}
