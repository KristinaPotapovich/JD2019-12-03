package by.it.busel.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    /**
     * a method, which calculates some mathematical operations
     * on the basis of the argument "String varExpression",
     * which contains a mathematical operator and its operands
     * received from console input by the means of a Scanner-object
     *
     * @param varExpression a String-object, which contains
     *                      a mathematical operator and its operands
     *                      received from console input by the means
     *                      of a Scanner-object
     * @return a result of a mathematical operation,
     * i.e. a Scalar / Vector / Matrix expression
     */
    Var calc(String varExpression) {
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        String[] operand = pattern.split(varExpression);
        Var operand1 = Var.createVar(operand[0].trim());
        Var operand2 = Var.createVar(operand[1].trim());
        if (operand1 == null || operand2 == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(varExpression);
        if (matcher.find()) {
            switch (matcher.group()) {
                case "+":
                    return operand1.add(operand2);
                case "-":
                    return operand1.sub(operand2);
                case "*":
                    return operand1.mul(operand2);
                case "/":
                    return operand1.div(operand2);
                default:
                    System.out.println("The mathematical operator has not been found.\nCheck the expression You inputted. Then re-enter your expression, please!");
            }
        }
        return null;
    }
}
