package by.it.rumiantcau.jd01_08;

abstract class Var implements Operation{
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
