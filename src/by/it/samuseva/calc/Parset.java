package by.it.samuseva.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parset {
    Var calc (String expression) throws CalcException{
        expression = expression.replace("\\s+", "");
        Pattern pat = Pattern.compile(Patterns.OPERATION);
        Matcher mat = pat.matcher(expression);
        if (mat.find()){
            String operation = mat.group();
            String[] operands = expression.split(Patterns.OPERATION, 2);
            Var operandTwo = Var.createVar(operands[1]);
            if (expression.contains("=")){
                Var.saveVar(operands[0], operandTwo);
                return  operandTwo;
            }
            Var operandOne = Var.createVar(operands[0]);
            if ((operandOne != null ) || (operandTwo != null)){
                switch (operation){
                    case "+": return operandOne.add(operandTwo);
                    case "-": return operandOne.sub(operandTwo);
                    case "*": return operandOne.mul(operandTwo);
                    case "/": return operandOne.div(operandTwo);
                }
            }

        }
        return null;
    }
}
