package by.it.popkov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        Log.writeLog(expression);
        Matcher m = Pattern.compile(Patterns.MATH_SIGN).matcher(expression);
        if (m.find()) {
            String sing = m.group();
            String[] values = expression.split(Patterns.MATH_SIGN);
            String first = values[0];
            String second = values[1];
            if (sing.equals("=")){
                Var.save(values[0], Var.newVar(second));
                return Var.newVar(second);
            }
            if (Var.newVar(first) != null && Var.newVar(second) != null) {
                switch (sing) {
                    case "+":
                        return Var.newVar(first).add(Var.newVar(second));
                    case "-":
                        return Var.newVar(first).sub(Var.newVar(second));
                    case "*":
                        return Var.newVar(first).mul(Var.newVar(second));
                    case "/":
                        return Var.newVar(first).div(Var.newVar(second));

                }
            }
        }
        throw new CalcException("Ошибка ввода");
    }
}
