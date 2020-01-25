package by.it.lozouski.jd01_07;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String text) {
        this.value = Double.parseDouble(text);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
