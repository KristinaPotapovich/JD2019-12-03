package by.it.kuzmichalex.calc_jd01_15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) throws CalcException {
        expression = expression.replace("\\s+", "");

        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            String[] partsOfExpression = expression.split(Patterns.OPERATION, 2);
            Var rightVar = Var.createVar(partsOfExpression[1]);
            if (operation.equals("=")){
                Var.save(partsOfExpression[0],rightVar);
                return rightVar;
            }

            Var leftVar = Var.createVar(partsOfExpression[0]);
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
                    default: throw new CalcException("Unknown operation: "+ operation);
                }
            }
        }
        throw new CalcException("Operation expected");
    }

}
