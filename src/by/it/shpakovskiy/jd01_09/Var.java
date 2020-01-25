package by.it.shpakovskiy.jd01_09;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var add(Scalar other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var add(Vector other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var add(Matrix other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var sub(Scalar other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var sub(Vector other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var sub(Matrix other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var mul(Scalar other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var mul(Vector other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var mul(Matrix other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }

    public Var div(Scalar other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var div(Vector other){
        System.out.println("Operation" + this + "with " + other + " impossible");
        return null;
    }
    public Var div(Matrix other){
        System.out.println("Operation" + this + "with " + other + " impossible");
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
            return null;
    }
}
