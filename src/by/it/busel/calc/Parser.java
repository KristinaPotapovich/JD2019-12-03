package by.it.busel.calc;

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
    Var calc(String varExpression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        String[] operand = pattern.split(varExpression);
        Matcher matcher = pattern.matcher(varExpression);
        if (matcher.find()) {
            String operator = matcher.group();
            if (operand.length <= 1) {
                throw new CalcException("You've entered only a mathematical operator! or only one operand");
            }
            Var operand2 = Var.createVar(operand[1].trim());
            if (operator.equals("=")) {
                Storage.putMapElement(operand[0], operand2);
                return operand2;
            }
            Var operand1 = Var.createVar(operand[0].trim());
            if (operand1 == null || operand2 == null) {
                throw new CalcException("You've entered only one operand!");
            }
            switch (operator) {
                case "+":
                    return operand1.add(operand2);
                case "-":
                    return operand1.sub(operand2);
                case "*":
                    return operand1.mul(operand2);
                case "/":
                    return operand1.div(operand2);
                default:
                    throw new CalcException("The mathematical operator has not been found.\nCheck the expression You inputted. Then re-enter your expression, please!");
            }
        }
        throw new CalcException("The mathematical operator has not been found.\nCheck the expression You inputted. Then re-enter your expression, please!");
    }
}
