package by.it.akhmelev.jd01_09;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }



    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return new Scalar(-1).mul(other.sub(this));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double op2=((Scalar) other).value;
            if (op2==0){
                System.out.println("Omg!! Division by zero");
            }
            return new Scalar(this.value / ((Scalar) other).value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
