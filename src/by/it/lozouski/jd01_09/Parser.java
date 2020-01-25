package by.it.lozouski.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calculate(String expression) {
        String[] operands = expression.split(Patterns.OPERATION);
        Var operandFirst = Var.createVar(operands[0]);
        Var operandSecond = Var.createVar(operands[1]);
        if (operandFirst == null || operandSecond == null) {
            return null; //TODO Добавить генерацию ошибки.(Lozouski)
        }
        Pattern patternOperations = Pattern.compile(Patterns.OPERATION);
        Matcher myMatch = patternOperations.matcher(expression);
        if (myMatch.find()) {
            String operation = myMatch.group();
            switch (operation) {
                case "+":
                    return operandFirst.add(operandSecond);
                case "-":
                    return operandFirst.sub(operandSecond);
                case "*":
                    return operandFirst.mul(operandSecond);
                case "/":
                    return operandFirst.div(operandSecond);
            }
        }
        return null;
    }
}
