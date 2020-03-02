package by.it.ban.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.ban.calc.Var.*;

class Parser {

    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        if (expression.equals("printvar")){
            printvar();
        }
        else if (expression.equals("sortvar")){
            sortvar();
        }
        else {
            Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
                String[] part = expression.split(Patterns.OPERATION, 2);
                Var right = createVar(part[1]);
                if (operation.equals("=")) {
                    save(part[0], right);
                    return right;
                }
                Var left = createVar(part[0]);
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
        }
        return null;
    }


}
