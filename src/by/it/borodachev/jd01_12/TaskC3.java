package by.it.borodachev.jd01_12;

import by.it.borodachev.Calc.Patterns;
import by.it.borodachev.Calc.Var;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        Map<String, String> varCheck = new HashMap<>();
        // Key - открывающая скобка
        // Value - закрывающая
        varCheck.put("{", "}");
        varCheck.put("(", ")");
        varCheck.put("[", "]");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        Matcher matcher = Pattern.compile("[{()\\[\\]}+]").matcher(expression);
        ArrayDeque<String> brackets =new ArrayDeque<>();
        while (matcher.find()) {
            String bracket = matcher.group().trim();
          if (varCheck.containsKey(bracket)) // bracket открывающая скобка
            {brackets.addLast(bracket);}
          else { // bracket закрывающая скобка + должна соответвовать последней в очереди
              if (brackets.peekLast() == null) {
                  System.out.println("Для "+bracket+"нет соответсвия");
              } else {
                  String bracketCloseLast=varCheck.get(brackets.peekLast());
                  if ( bracketCloseLast.equals(bracket)) {
                      // все совпало. Удаляем из очереди
                      brackets.pollLast();
                  }
                  else {
                      System.out.println(" " + bracket + " нет соответсвия");
                  }
              }
          }
          }
// Очередь должна быть пуста
       if (!brackets.isEmpty())
           System.out.println("Ошибки");
       else
           System.out.println("Проверка закончена");

    }
    }

