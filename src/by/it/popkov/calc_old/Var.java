package by.it.popkov.calc_old;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static Map<String, Var> valueMap = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(this + " + " + other + " impossible");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(this + " - " + other + " impossible");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(this + " * " + other + " impossible");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(this + " / " + other + " impossible");
    }

    static Var newVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        else if (strVar.matches(Patterns.LITTER)) return valueMap.get(strVar);
        else throw new CalcException("Неправильный ввод");
    }

    static void save(String value, Var value1) {
        valueMap.put(value, value1);
    }

    static void printvar() {
        System.out.println(valueMap);
//        String[] keys = valueMap.keySet().toArray(new String[0]);
//        for (String key : keys) {
//            System.out.println(key + "="+ valueMap.get(key));
//        }
    }

    static void sortvar() {
        System.out.println(new TreeMap<>(valueMap));
//        TreeSet<String> objects = new TreeSet<>(valueMap.keySet());
//        String[] sortedKeys = objects.toArray(new String[0]);
//        for (String sortedKey : sortedKeys) {
//            System.out.println(sortedKey + "="+ valueMap.get(sortedKey));
        //}
    }
}
