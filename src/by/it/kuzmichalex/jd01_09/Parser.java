package by.it.kuzmichalex.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        expression = expression.replace("\\s+", "");
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            String[] partsOfExpression = expression.split(Patterns.OPERATION, 2);
            Var leftVar = Var.createVar(partsOfExpression[0]);
            Var rightVar = Var.createVar(partsOfExpression[1]);
            if (leftVar != null && rightVar != null) {
                switch (operation) {
                    case "+":
                        return leftVar.add(rightVar);
                    case "-":
                        return leftVar.sub(rightVar);
                    case "*":
                        return leftVar.mul(rightVar);
                    case "/":
                        return leftVar.div(rightVar);
                }
            }
        }
        return null;
    }

}
