package by.it.plugatar.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.plugatar.calc.Patterns.OPERATION;

class Parser {
    Var calc(String expression) throws CalcException{
        Pattern cal = Pattern.compile(OPERATION);
        String[] split = expression.trim().split(OPERATION);
        Var two = Var.createVar(split[1].trim());
        if (expression.contains("=") ){
            return Var.saveVar(split[0],two);
        }
        Var one = Var.createVar(split[0].trim());

        if (one == null || two == null){
            //System.out.println("ОПЕРАЦИЯ " + expression + " НЕВОЗМОЖНА");
            //return null;//TODO CREATE ERROR
            throw new CalcException("ERROR:" + expression + " ОПЕРАЦИЯ НЕВОЗМОЖНА");
        }
        Matcher m = cal.matcher(expression);
        if (m.find()){
            String operation = m.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }

     //2+2
    /* expression=expression.replace("\\s+","");
     Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if (matcher.find()){
            String operation=matcher.group();
            String[] part=expression.split(Patterns.OPERATION,2);
            Var left=Var.CreateVar(part[0]);
        }
     return null;
    }
     */
}
