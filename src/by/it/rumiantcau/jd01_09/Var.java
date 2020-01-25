package by.it.rumiantcau.jd01_09;

abstract class Var implements Operation{
    static Var createVAr(String operand){
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);

        return null;
    }

    @Override
    //сложение
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    //вычитание
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + "-" + other + " невозможна");
        return null;
    }

    @Override
    //умножение
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "*" + other + " невозможна");
        return null;
    }

    @Override
    //деление
    public Var div(Var other) {
        System.out.println("Операция деления " + this  + "/" + other + " невозможна");
        return null;
    }


}
