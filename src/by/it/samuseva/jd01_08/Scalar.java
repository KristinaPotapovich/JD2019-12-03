package by.it.samuseva.jd01_08;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }
    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
           double sum = this.value + ((Scalar) other).value;
           return new Scalar(sum);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }
        else return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            if (((Scalar) other).value==0) System.out.println("Делить на ноль нельзя!");
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
