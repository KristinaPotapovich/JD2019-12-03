package by.it.kuzmichalex.calc_jd01_15;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotation {
    private static final Map<String, Integer> priority = new HashMap();

    static {
        priority.put("*", 3);
        priority.put("/", 3);
        priority.put("+", 2);
        priority.put("-", 2);
        priority.put("(", 1);
        priority.put(")", 1);
    }

    private Deque<String> stack = new ArrayDeque<>();
    private Deque<String> outString = new ArrayDeque<>();

    void parseExpression(String expression) {
        String OPERATION_PATTERN = "([()])|((?<![-+*/,{])[-+*/])";


        int prevPosition = 0;
        String variable;
        String operation;
        Matcher matcher = Pattern.compile(OPERATION_PATTERN).matcher(expression);
        do {
            if (matcher.find()) {
                int currPosition = matcher.start();   //Какая-то операция
                //System.out.println("--------- prev " + prevPosition + " urr " + currPosition);
                if ((currPosition - prevPosition) > 0) {                 //И какое-то выражение
                    variable = expression.substring(prevPosition, currPosition);
                    System.out.println("var " + variable);
                    outString.addLast(variable); //Числа или переменные помещаются в выходную строку
                }
                operation = expression.substring(currPosition, currPosition + 1);
                prevPosition = currPosition + 1;
                System.out.println("oper " + operation);
                processOperator(operation);
            } else {
                variable = expression.substring(prevPosition);
                System.out.println("finish var " + variable);
                if (variable.length() > 0) outString.add(variable); //Числа или переменные помещаются в выходную строку
                break;
            }
        } while (true);

        while (stack.size() > 0) outString.add(stack.poll());

        System.out.println(outString);

    }


    private void processOperator(String operation) {
        System.out.println("process " + operation);
        if (stack.size() == 0) {
            stack.addFirst(operation);
            System.out.println("stack " + stack);
        } else {
            if (operation.equals("(")) {
                stack.addFirst(operation);
                System.out.println("stack " + stack);
            }        //Открывающие - в стек
            else if (operation.equals(")")) {                        //закрывающие из стеа
                boolean bracketOk = false;
                while (stack.size() > 0) {
                    String tmp = stack.poll();
                    if (tmp.equals("(")) {
                        bracketOk = true;
                        break;
                    }
                    if(bracketOk==false){
                        System.out.println("Bracket ass");
                    }
                    outString.add(tmp);
                }
            } else    //какая-то другая операция кроме скобок
            {
                System.out.println("other operation " + operation);
                if (priority.get(operation) <= priority.get(stack.peek())) {
                    while (stack.size() > 0) {
                        if (priority.get(operation) <= priority.get(stack.peek())) {
                            outString.add(stack.poll());
                        } else break;
                    }
                }
                stack.addFirst(operation);
            }
        }
        System.out.println("process done " + stack);
    }
    ///////////////////////////////
}