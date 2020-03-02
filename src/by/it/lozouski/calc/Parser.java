package by.it.lozouski.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calculate(String expression) throws CalcException {
        expression = expression.replace("\\s+", "");
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            String[] operands = expression.split(Patterns.OPERATION, 2);
            Var operandSecond = Var.createVar(operands[1]);
            if (operation.equals("=")) {
                Var.saveVar(operands[0], operandSecond);
                return operandSecond;
            }

            Var operandFirst = Var.createVar(operands[0]);
            if (operandFirst != null && operandSecond != null) {
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
        }
        throw new CalcException("Incorrect variable creation, please try again.");
    }
}
