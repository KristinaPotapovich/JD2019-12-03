package by.it.shpakovskiy.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll(" ","").replace("\\s+", "");
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            String[] part = expression.split(Patterns.OPERATION, 2);
            Var right = Var.createVar(part[1]);
            if (operation.equals("=")) {
                Var.saveVar(part[0], right);
                return right;
            }
            Var left = Var.createVar(part[0]);
            if (left != null && right != null) {
                switch (operation) {
                    case "+":
                        return left.add(right);
                    case "-":
                        return left.sub(right);
                    case "*":
                        return left.mul(right);
                    case "/":
                        return left.div(right);
                }
            }
        }
        return null;
    }
}
