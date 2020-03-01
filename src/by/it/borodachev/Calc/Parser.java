package by.it.borodachev.Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static by.it.borodachev.Calc.Var.*;

class Parser {

    Var calc(String expression) throws CalcException {
        expression = expression.replace("\\s+", "");
        if (expression.equals("printvar")) {
            printvar();
        } else if (expression.equals("sortvar")) {
            sortvar();
        } else
        {
            Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            String[] part = expression.split(Patterns.OPERATION, 2);
            Var left = Var.createVar(part[0]);
            Var right = Var.createVar(part[1]);
            if (left != null && right != null) {
                switch (operation) {
                    case "=": {
                        save(part[0], right);
                        return right;
                    }

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
    }
        return null;
    }


}
