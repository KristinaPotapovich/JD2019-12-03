package by.it.samuseva.jd01_08;

abstract class Var implements Operation{
    @Override
    public String toString() {
        return "это обстроктный класс";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сожения " + this + "+" + other + "невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция сожения " + this + "-" + other + "невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция сожения " + this + "*" + other + "невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция сожения " + this + "/" + other + "невозможна");
        return null;
    }
}
