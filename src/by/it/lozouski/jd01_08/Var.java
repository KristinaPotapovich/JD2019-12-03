package by.it.lozouski.jd01_08;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        return null;
    }

    Var add(Scalar otherScalar) {
        System.out.println("Operation addition " + otherScalar + " + " + this + " isn't possible.");
        return null;
    }

    Var add(Vector otherVector) {
        System.out.println("Operation addition " + otherVector + " + " + this + " isn't possible.");
        return null;
    }

    Var add(Matrix otherMatrix) {
        System.out.println("Operation addition " + otherMatrix + " + " + this + " isn't possible.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    Var sub(Scalar otherScalar) {
        System.out.println("Operation addition " + otherScalar + " - " + this + " isn't possible.");
        return null;
    }

    Var sub(Vector otherVector) {
        System.out.println("Operation addition " + otherVector + " - " + this + " isn't possible.");
        return null;
    }

    Var sub(Matrix otherMatrix) {
        System.out.println("Operation addition " + otherMatrix + " - " + this + " isn't possible.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }
    Var mul(Scalar otherScalar) {
        System.out.println("Operation multiplication " + otherScalar + " * " + this + " isn't possible.");
        return null;
    }
    Var mul(Vector otherVector) {
        System.out.println("Operation multiplication " + otherVector + " * " + this + " isn't possible.");
        return null;
    }
    Var mul(Matrix otherMatrix) {
        System.out.println("Operation multiplication " + otherMatrix + " * " + this + " isn't possible.");
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
    Var div(Scalar otherScalar){
        System.out.println("Operation division " + otherScalar + " / " + this + " isn't possible.");
        return null;
    }
    Var div(Vector otherVector){
        System.out.println("Operation division " + otherVector + " / " + this + " isn't possible.");
        return null;
    }

}
