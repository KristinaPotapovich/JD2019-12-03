package by.it.shulga.jd01.jd01_08;

public abstract class Var implements Operation {
    @Override
    public String toString() {
        return "Var{}";
    }

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
    public Var add(Scalar other) {
        System.out.println("Operation " + this + "+" + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Scalar other) {
        System.out.println("Operation " + this + "-" + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Scalar other) {
        System.out.println("Operation " + this + "*" + other + " impossible");
        return null;
    }

    @Override
    public Var div(Scalar other) {
        System.out.println("Operation " + this + "/" + other + " impossible");
        return null;
    }

    @Override
    public Var add(Vector other) {
        System.out.println("Operation " + this + "+" + other + " impossible");
        return null;
    }

    @Override
    public Var sub(Vector other) {
        System.out.println("Operation " + this + "-" + other + " impossible");
        return null;
    }

    @Override
    public Var mul(Vector other) {
        System.out.println("Operation " + this + "*" + other + " impossible");
        return null;
    }

    @Override
    public Var div(Vector other) {
        System.out.println("Operation " + this + "/" + other + " impossible");
        return null;
    }


}