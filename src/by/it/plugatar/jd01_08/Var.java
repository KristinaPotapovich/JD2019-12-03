package by.it.plugatar.jd01_08;
/*          Sacalar       Vector            Matrix
* Scalar   +-* делить     +-* делить нет    +-* делить нет
*
* Vector   +-*делить мож  +-*делить нет     нет нет нет нет
*
* Matrix   +-*делить с      умножение с огран + - * с ограничени
*           ограничен
* */
/*
abstract class Var {
    @Override
    public String toString(){
        return "Это класс Var";
    }
}
*/

public class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения" + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания" + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения" + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления" + this + "+" + other + " невозможна");
        return null;
    }
}



