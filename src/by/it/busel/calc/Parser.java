package by.it.busel.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a class that parses an expression, which is a String object,
 * whether it contains (a) var expressions, if contains this class
 * transform the expression into a Var object or its sub classes
 */
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
        String[] operand = varExpression.split(Patterns.OPERATION);
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(varExpression);
        if (matcher.find() && throwCalcExceptionIfOneOrNoOperand(operand)) {
            String operator = matcher.group();
            if (operator.equals("=")) {
                return assignVar(operand);
            } else {
                return calculateVar(operand, operator);
            }
        } else if (Storage.containsKey(varExpression)) {
            return Storage.getVarFromStorage(varExpression);
        }
        throw new CalcException("The mathematical operator has not been found.\nCheck the expression You inputted. Then re-enter your expression, please!");
    }

    /**
     * a method that checks  one of conditions whether a mathematical operation can be performed, i.e.
     * presence of two mathematical operands
     *
     * @param operand an array that should contain two mathematical operands
     * @return a boolean expression which states that there is two operands
     * @throws CalcException if a aforementioned condition isn't fulfilled
     */
    private boolean throwCalcExceptionIfOneOrNoOperand(String[] operand) throws CalcException {
        if (operand.length <= 1) {
            throw new CalcException("You've entered only a mathematical operator or only one operand!");
        }
        return true;
    }

    /**
     * a method that returns a result of calculation of two Var expressions
     *
     * @param operand  a String array which contains two mathematical operands
     * @param operator a operator that determines which mathematical operation will be performed
     * @return a result of calculation
     * @throws CalcException when a mathmetical operation can be performed
     */
    private Var calculateVar(String[] operand, String operator) throws CalcException {
        Var operand2 = Var.createVar(operand[1].trim());
        Var operand1 = Var.createVar(operand[0].trim());
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

    /**
     * a method that assigns an inputted Var expression to an inputted at the same time name.
     *
     * @param operand an array of two Strings, first one contains a name of a var expression,
     *                second one - a String representation of a Var expression
     * @return a Var object that containing its value
     * @throws CalcException if an incorrect Var expression is inputted
     */
    private Var assignVar(String[] operand) throws CalcException {
        Var operandToAssign = Var.createVar(operand[1].trim());
        Storage.putVarToStorage(operand[0], operandToAssign);
        return operandToAssign;
    }
}
