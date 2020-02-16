package by.it.samuseva.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }
    static void sortvar (){
        Set<Map.Entry<String, Var>> entries = vars.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey()+ " = " + entry.getValue());
        }
    }

    static Var createVar (String operand) throws CalcException {
        operand = operand.trim().replaceAll("\\s+", "");
        if (operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)){
            return new Matrix(operand);
        }
        if (vars.containsKey(operand)) {
            return vars.get(operand);
        }
        throw new CalcException("Невозможно создать такую переменную: " + operand);
    }

    @Override
    public String toString() {
        return "это обстроктный класс";
    }

    //////////   methods for add operation
    @Override
    public Var add(Var right) throws CalcException {
        throw new CalcException("Операция сожения " + this + "+" + right + "невозможна");
    }
    public Var add(Scalar left) throws CalcException {
        throw new CalcException("Операция сожения " + this + "+" + left + "невозможна");
    }
    public Var add(Vector left) throws CalcException {
        throw new CalcException("Операция сожения " + this + "+" + left + "невозможна");

    }
    public Var add(Matrix left) throws CalcException {
        throw new CalcException("Операция сожения " + this + "+" + left + "невозможна");
    }
    //////////   methods for sub operation
    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция сожения " + this + "-" + other + "невозможна");
    }
    //////////   methods for mul operation

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция сожения " + this + "*" + other + "невозможна");
    }

    //////////   methods for div operation
    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция сожения " + this + "/" + other + "невозможна");
    }


}
