package by.it.akhmelev.calc11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();


    @Override
    public Var add(Var other) {
        System.out.println("Operation " + this + "+" + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation " + this + "-" + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation " + this + "*" + other + " impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation " + this + "/" + other + " impossible");
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else
            return vars.get(strVar);
        //TODO generate error here
    }

    static void save(String key, Var value) {
        vars.put(key,value);
    }

}
