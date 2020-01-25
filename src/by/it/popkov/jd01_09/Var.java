package by.it.popkov.jd01_09;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println(this + " + " + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println(this + " - " + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println(this + " * " + other + " impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println(this + " / " + other + " impossible");
        return null;
    }

    static Var newVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        else return null;
    }
}
