package by.it.filipovich.jd01_09;

abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.println("Operating for "+this+" + "+ other + " is impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operating for "+this+" - "+ other + " is impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operating for "+this+" * "+ other + " is impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operating for "+this+" / "+ other + " is impossible");
        return null;
    }

    @Override
    public String toString(){
        return "Я метод Var, я не хочу ничего решать!";
    }

    static Var createVar(String operand){
        String a = operand.trim();
        if(a.matches(Patterns.SCALAR))
            return new Scalar(a);
        else if(a.matches(Patterns.VECTOR))
            return new Vector(a);
        else if(a.matches(Patterns.MATRIX))
            return new Matrix(a);

        return null;
    }
}
