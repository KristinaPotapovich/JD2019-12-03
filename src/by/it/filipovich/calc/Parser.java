package by.it.filipovich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression){
        String[] operand = expression.split("[+\\-*/]");
        Var result = null;
        Var operand1 = Var.createVar(operand[0]);
        Var operand2 = Var.createVar(operand[1]);

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(expression);
        if(matcher.find()){
            String mark = matcher.group();
        switch (mark) {
            case ("+"):
                result = operand1.add(operand2);
            break;
            case ("-"):
                result = operand1.sub(operand2);
            break;
            case ("*"):
                result = operand1.mul(operand2);
                break;
            case ("/"):
                result = operand1.div(operand2);
                break;
            default:
                System.out.println("Unknown Operation!!!");
                break;
        }
        return result;
        }
        return null;
    }
}
